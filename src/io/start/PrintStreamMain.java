package io.start;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {
        System.out.println("hello world");
        PrintStream printStream = System.out;
        printStream.println("hello");

        byte[] bytes = "Hellop!\n".getBytes(StandardCharsets.UTF_8);
        printStream.write(bytes);
    }
}
