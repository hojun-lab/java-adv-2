package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadFileV3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(BufferedConst.FILE_NAME);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, BufferedConst.BUFFER_SIZE);
        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data ;
        while ((data = bufferedInputStream.read()) != -1) {
            fileSize++;
        }
        bufferedInputStream.close();

        long endTime = System.currentTimeMillis();
        System.out.println("File Created : " + BufferedConst.FILE_NAME);
        System.out.println("File Created : " + fileSize / 1024/ 1024 + "MB");
        System.out.println("File created time : " + (endTime - startTime) + "ms");
    }
}
