 package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

 public class ReaderWriterMainV2 {
     public static void main(String[] args) throws IOException {
         String writeString = "ABC";
         System.out.println("Write String: " + writeString);

         FileOutputStream fileOutputStream = new FileOutputStream(TextConst.FILE_NAME);
         OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);

         outputStreamWriter.write(writeString);
         outputStreamWriter.close();

         FileInputStream fileInputStream = new FileInputStream(TextConst.FILE_NAME);
         InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);

         StringBuilder stringBuilder = new StringBuilder();
         int ch;
         while ((ch = inputStreamReader.read()) != -1) {
            stringBuilder.append((char) ch);
         }
         inputStreamReader.close();

         System.out.println("read String: " + stringBuilder);
     }
 }
