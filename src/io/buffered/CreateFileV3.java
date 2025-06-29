package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(BufferedConst.FILE_NAME);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, BufferedConst.BUFFER_SIZE);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            bufferedOutputStream.write(1);
        }
        bufferedOutputStream.close();
        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + BufferedConst.FILE_NAME);
        System.out.println("File Created : " + BufferedConst.FILE_SIZE / 1024/ 1024 + "MB");
        System.out.println("File created time : " + (endTime - startTime) + "ms");
    }
}
