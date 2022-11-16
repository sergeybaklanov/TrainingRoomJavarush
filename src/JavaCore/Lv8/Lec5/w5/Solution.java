package JavaCore.Lv8.Lec5.w5;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {

        String str = "D:/LessonTry/Input.txt\nD:/LessonTry/Output.txt";

        InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        System.setIn(is);

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String filePath = buffer.readLine();
            try (FileInputStream input = new FileInputStream(filePath)) {
                if (input.available() < 1000)
                    throw new DownloadException("Emegency stop");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DownloadException extends Exception {
        public DownloadException(String str) {
            System.out.println(str);
        }
    }
}