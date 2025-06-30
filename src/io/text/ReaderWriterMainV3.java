package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        String writeString = "abc";
        System.out.println("write string: " + writeString);

        // 파일에 쓰기
        FileWriter fileWriter = new FileWriter(TextConst.FILE_NAME, StandardCharsets.UTF_8);
        // FileWriter = FileOutputStream + OutputStreamWriter
        fileWriter.write(writeString);
        fileWriter.close();

        // 파일에서 읽기
        StringBuilder content = new StringBuilder();
        FileReader fileReader = new FileReader(TextConst.FILE_NAME, StandardCharsets.UTF_8);
        int ch;
        while ((ch = fileReader.read()) != -1) {
            content.append((char) ch);
        }
        fileReader.close();

        String string = content.toString();
        System.out.println("read string: " + string);
    }
}
