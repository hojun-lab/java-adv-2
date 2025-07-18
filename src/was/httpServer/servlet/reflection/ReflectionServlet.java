package was.httpServer.servlet.reflection;

import was.httpServer.HttpRequest;
import was.httpServer.HttpResponse;
import was.httpServer.HttpServlet;
import was.httpServer.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectionServlet implements HttpServlet {

    private final List<Object> controllers;

    public ReflectionServlet(List<Object> controllers) {
        this.controllers = controllers;
    }

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();

        for (Object controller : controllers) {
            Class<?> aClass = controller.getClass();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                String name = declaredMethod.getName();
                if (path.equals("/" + name)) {
                    invoke(request, response, controller, declaredMethod);
                    return;
                }
            }
        }
        throw new PageNotFoundException("request = " + path);
    }

    private static void invoke(HttpRequest request, HttpResponse response, Object controller, Method declaredMethod) {
        try {
            declaredMethod.invoke(controller, request, response);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
