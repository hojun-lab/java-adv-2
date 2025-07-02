package io.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NewFilesPath {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("temp/..");
        System.out.println("path = " + path);

        // 절대 경로
        System.out.println("AbsolutePath = " + path.toAbsolutePath());

        // 정규 경로
        System.out.println("CanonicalPath = " + path.toRealPath());

        List<Path> pathList = Files.list(path).toList();
        for (Path p : pathList) {
            System.out.println( (Files.isRegularFile(p) ? "F" : "D") + " | " + p.getFileName() );
        }    }
}
