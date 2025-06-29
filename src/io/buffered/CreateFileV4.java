package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(BufferedConst.FILE_NAME);

        long startTime = System.currentTimeMillis();
        byte[] buffer = new byte[BufferedConst.FILE_SIZE];
        for (int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            buffer[i] = 1;
        }
        fileOutputStream.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + BufferedConst.FILE_NAME);
        System.out.println("File Created : " + buffer.length / 1024/ 1024 + "MB");
        System.out.println("File created time : " + (endTime - startTime) + "ms");
    }
}
