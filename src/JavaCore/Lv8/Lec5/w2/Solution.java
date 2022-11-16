package JavaCore.Lv8.Lec5.w2;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader (System.in));

        int count = 0;
        byte[] b = ",".getBytes(StandardCharsets.UTF_8);

        try (FileInputStream input = new FileInputStream(buffer.readLine())){
            while(input.available()>0){
                if(b[0]==input.read())
                    count++;
            }
            System.out.println(count);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }
}
