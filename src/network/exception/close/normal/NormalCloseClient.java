package network.exception.close.normal;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class NormalCloseClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream input = socket.getInputStream();

        readByInputStream(input, socket);
        readByBufferReader(input, socket);
        readByDataInputSteam(input, socket);

        log("연결 종료: " + socket.isClosed());
    }

    private static void readByInputStream(InputStream input, Socket socket) throws IOException {
        int read = input.read();        // 1 byte 반위
        log("read = " + read);
        if (read == -1) {
            input.close();
            socket.close();
        }
    }

    private static void readByBufferReader(InputStream input, Socket socket) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));       // 라인 단위
        String readString = bufferedReader.readLine();
        log("readString = " + readString);
        if (readString != null) {
            bufferedReader.close();
            socket.close();
        }
    }

    private static void readByDataInputSteam(InputStream input, Socket socket) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(input);
        try {
            dataInputStream.readUTF();
        } catch (EOFException e) {
            log(e);
        } finally {
            dataInputStream.close();
            socket.close();
        }
    }
}
