package was.v8;

import was.httpServer.HttpServer;
import was.httpServer.HttpServlet;
import was.httpServer.ServletManager;
import was.httpServer.annotation.AnnotationServletV3;
import was.httpServer.servlet.DiscardServlet;

import java.io.IOException;
import java.util.List;

public class ServerMainV8 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteController(), new SearchController());
//        HttpServlet servlet = new AnnotationServletV2(controllers);
        HttpServlet servlet = new AnnotationServletV3(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(servlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
