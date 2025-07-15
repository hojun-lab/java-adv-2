package was.v5.servelt;

import was.httpServer.HttpRequest;
import was.httpServer.HttpResponse;
import was.httpServer.HttpServlet;

import java.io.IOException;

public class Site1Servlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.writeBody("<h1>site1</h1>");
    }
}
