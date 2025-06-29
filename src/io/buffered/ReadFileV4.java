package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV4 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(BufferedConst.FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] bytes = fileInputStream.readAllBytes();
        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File Created : " + BufferedConst.FILE_NAME);
        System.out.println("File size : " + bytes.length / 1024 / 1024 + "MB");
        System.out.println("File created time : " + (endTime - startTime) + "ms");
    }
}
