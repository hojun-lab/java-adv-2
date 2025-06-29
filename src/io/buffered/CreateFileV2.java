package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

public class CreateFileV2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(BufferedConst.FILE_NAME);

        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[BufferedConst.BUFFER_SIZE];
        int bufferIndex = 0;

        for (int i = 0; i < BufferedConst.FILE_SIZE; i++) {
            buffer[bufferIndex++] = 1;

            // 버파가 가득 차면 쓰고, 버퍼를 비운다.
            if (bufferIndex == BufferedConst.BUFFER_SIZE) {
                fileOutputStream.write(buffer);
                bufferIndex = 0;
            }
        }

        // 끝 부분에 오면 버퍼가 가득차지 않고, 남아있을 수 있다. 버퍼에 남은 부분 쓰기
        if (bufferIndex > 0) {
            fileOutputStream.write(buffer, 0, bufferIndex);
        }
        fileOutputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.println("File Created : " + BufferedConst.FILE_NAME);
        System.out.println("File Created : " + BufferedConst.FILE_SIZE / 1024/ 1024 + "MB");
        System.out.println("File created time : " + (endTime - startTime) + "ms");
    }
}
