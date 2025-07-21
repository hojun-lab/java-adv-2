package was.v7;

import was.httpServer.HttpRequest;
import was.httpServer.HttpResponse;
import was.httpServer.annotation.Mapping;

import java.io.IOException;

public class SearchController {
    @Mapping("/search")
    public void search(HttpRequest request, HttpResponse response) throws IOException {
        String query = request.getParameter("q");
        response.writeBody("<h1>Search</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li>query: " + query + "</li>");
        response.writeBody("</ul>");
    }
}
