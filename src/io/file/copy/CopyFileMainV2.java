package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileMainV2 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("temp/copy.dat");
        FileOutputStream fos = new FileOutputStream("temp/copy_new.dat");

        // transferTo가 가장 최적화 되어 있음
        // 생성과정 : 파일(original) -> 자바 -> 파일(copy)
        fis.transferTo(fos);
        fis.close();
        fos.close();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " +  (endTime - startTime) + " ms");
    }
}
