package was.httpServer.annotation;

import was.httpServer.HttpRequest;
import was.httpServer.HttpResponse;
import was.httpServer.HttpServlet;
import was.httpServer.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationServletV1 implements HttpServlet {
    private final List<Object> controllers;

    public AnnotationServletV1(List<Object> controllers) {
        this.controllers = controllers;
    }


    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        for (Object controller : controllers) {
            Method[] methods = controller.getClass().getDeclaredMethods();
            for (Method m : methods) {
                if (m.isAnnotationPresent(Mapping.class)) {
                    Mapping mapping = m.getAnnotation(Mapping.class);
                    String value = mapping.value();

                    if (value.equals(path)) {
                        invoke(controller, request, response, m);
                        return;
                    }
                }
            }
        }
        throw new PageNotFoundException("request: " + path);
    }

    private static void invoke(Object controller, HttpRequest request, HttpResponse response, Method m) {
        try {
            m.invoke(controller, request, response);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
