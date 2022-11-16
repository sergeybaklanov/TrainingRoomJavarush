package JavaCore.Lv8.Lec5.w4;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String str = "D:/LessonTry/Input.txt\nD:/LessonTry/Output.txt";

        InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        System.setIn(is);

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String firstFile = buffer.readLine();
        String secondFile = buffer.readLine();
        List<Integer> list = new ArrayList<>();

        try (FileInputStream input = new FileInputStream(firstFile);
             FileOutputStream output = new FileOutputStream(secondFile)) {
              while(input.available()>0){
                  list.add(input.read());
              }
              Collections.reverse(list);
            for (Integer element: list) {
                output.write(element);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
