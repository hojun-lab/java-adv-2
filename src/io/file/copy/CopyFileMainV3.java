package io.file.copy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyFileMainV3 {

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");

        // 가장 빠른 이유는?
        // 운영체제의 파일 복사 기능 사용 파일 -> 파일
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        long endTime = System.currentTimeMillis();
    }
}
