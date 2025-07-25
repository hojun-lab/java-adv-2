package was.httpServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static util.MyLogger.log;

public class HttpRequestHandler implements  Runnable {
    private final Socket socket;
    private final ServletManager servlet;

    public HttpRequestHandler(Socket socket, ServletManager servlet) {
        this.socket = socket;
        this.servlet = servlet;
    }

    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
            log(e);
        }
    }

    private void process() throws IOException {
        try (socket;
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, StandardCharsets.UTF_8)) {

            HttpRequest request = new HttpRequest(reader);
            HttpResponse response = new HttpResponse(writer);

            log("HTTP 요청 : " + request);
            servlet.execute(request, response);
            response.flush();
            log("HTTP 응답 완료");
        }
    }
}
