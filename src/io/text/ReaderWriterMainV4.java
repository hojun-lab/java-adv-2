package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV4 {
    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println("== Writing String ==");
        System.out.println(writeString);

        // 파일에 쓰기
        FileWriter fileWriter = new FileWriter(TextConst.FILE_NAME, StandardCharsets.UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, BUFFER_SIZE);
        // FileWriter = FileOutputStream + OutputStreamWriter
        bufferedWriter.write(writeString);
        bufferedWriter.close();

        // 파일에서 읽기
        StringBuilder content = new StringBuilder();
        FileReader fileReader = new FileReader(TextConst.FILE_NAME, StandardCharsets.UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader,  BUFFER_SIZE);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();

        System.out.println("== Read String ==");
        System.out.println(content);
    }
}
