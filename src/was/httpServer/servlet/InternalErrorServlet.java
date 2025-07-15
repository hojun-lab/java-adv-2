package was.httpServer.servlet;

import was.httpServer.HttpRequest;
import was.httpServer.HttpResponse;
import was.httpServer.HttpServlet;

import java.io.IOException;

public class InternalErrorServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.setStatusCode(500);
        response.writeBody("<h1>Internal Error</h1>");
    }
}
