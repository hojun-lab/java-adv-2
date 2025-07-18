package was.v6;

import was.httpServer.HttpRequest;
import was.httpServer.HttpResponse;

public class SearchControllerV6 {
    public void site1(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>site1</h1>");
    }

    public void site2(HttpRequest request, HttpResponse response) {
        response.writeBody("<h1>site2</h1>");
    }
}
