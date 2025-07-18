package was.v6;

import was.httpServer.HttpRequest;
import was.httpServer.HttpResponse;

import java.io.IOException;

public class SiteControllerV6 {
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String query = request.getParameter("q");
        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
