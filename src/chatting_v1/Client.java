package chatting_v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class Client {
    private static final int PORT = 12345;
    private static String command;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", PORT);
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        DataInputStream input = new DataInputStream(socket.getInputStream());

        actByCommand();


        if (command.contains("/exit")) {
            log("연결 종료: " + socket);
            input.close();
            output.close();
            socket.close();
        }
    }

    private static void actByCommand() {
        System.out.println("""
                CLI 채팅 프로그램
                1. 입장
                명령어 : /join| {name}
                2. 메시지
                명령어 : /message| {내용}
                3. 이름 변경
                명령어 : /change| {name}
                4. 전체 사용자
                명령어 : /users
                5. 종료
                명령어 : /exit
                *****************************
                명령어를 입력해주세요
                """);

        Scanner scanner = new Scanner(System.in);
        command = scanner.nextLine();
    }
}