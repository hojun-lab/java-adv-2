package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(BufferedConst.FILE_NAME);
        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BufferedConst.BUFFER_SIZE];
        int fileSize = 0;
        int size;
        while ((size = fileInputStream.read(buffer)) != -1) {
            fileSize += size;
        }
        fileInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File Created : " + BufferedConst.FILE_NAME);
        System.out.println("File Created : " + fileSize / 1024/ 1024 + "MB");
        System.out.println("File created time : " + (endTime - startTime) + "ms");
    }
}
