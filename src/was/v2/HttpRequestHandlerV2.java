package was.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static util.MyLogger.log;

public class HttpRequestHandlerV2 implements  Runnable {
    private final Socket socket;

    public HttpRequestHandlerV2(Socket socket) {
        this.socket = socket;
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

            String requestString = requestToString(reader);
            if (requestString.contains("/favicon.ico")) {
                log("favicon 요청");
                return;
            }

            log("HTTP 요청 정보 출력");
            System.out.println(requestString);

            log("HTTP 응답 생성중 ...");
            sleep(5000L);
            responseToClient(writer);
        }
    }

    private void responseToClient(PrintWriter writer) {
        String body = "<h1>Hello World!</h1>";
        int length = body.getBytes(StandardCharsets.UTF_8).length;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 200 OK\r\n");
        stringBuilder.append("Content-Type: text/html; charset=utf-8\r\n");
        stringBuilder.append("Content-Length: ").append(length).append("\r\n");
        stringBuilder.append("\r\n"); // 헤더 바디 구분 라인
        stringBuilder.append(body);

        log("HTTP 응답 정보 출력");
        System.out.println(stringBuilder);

        writer.println(stringBuilder);
        writer.flush();
    }

    private static String requestToString(BufferedReader reader) throws IOException {
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            builder.append(line).append("\n");
        }
        return reader.toString();
    }

    private static void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
