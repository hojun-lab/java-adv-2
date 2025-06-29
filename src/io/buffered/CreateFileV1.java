package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(BufferedConst.FILE_NAME);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            fileOutputStream.write(1);
        }
        long endTime = System.currentTimeMillis();
        fileOutputStream.close();

        System.out.println("File Created : " + BufferedConst.FILE_NAME);
        System.out.println("File Created : " + BufferedConst.FILE_SIZE / 1024/ 1024 + "MB");
        System.out.println("File created time : " + (endTime - startTime) + "ms");
    }
}
