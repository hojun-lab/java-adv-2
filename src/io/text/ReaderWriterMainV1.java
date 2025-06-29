 package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        byte[] writeBytes = writeString.getBytes(StandardCharsets.UTF_8);
        System.out.println("Write String: " + writeString);
        System.out.println("Write Bytes: " + Arrays.toString(writeBytes));

        FileOutputStream fileOutputStream = new FileOutputStream(TextConst.FILE_NAME);
        fileOutputStream.write(writeBytes);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream(TextConst.FILE_NAME);

        byte[] bytes = fileInputStream.readAllBytes();
        String decodedString = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("Read String: " + decodedString);
        System.out.println("Read Bytes: " + Arrays.toString(bytes));
    }
}
