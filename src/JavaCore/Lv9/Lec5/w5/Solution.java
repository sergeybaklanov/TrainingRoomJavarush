package JavaCore.Lv9.Lec5.w5;

import java.io.*;

/*
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader addressReader = new BufferedReader(new InputStreamReader(System.in));
            FileReader input = new FileReader(String.valueOf(addressReader.readLine()));
            BufferedReader buffer = new BufferedReader(input);
            FileWriter output = new FileWriter(String.valueOf(addressReader.readLine()));
            BufferedWriter bufferOut = new BufferedWriter(output))

         {
            while (buffer.ready()) {
                String temp = buffer.readLine().replaceAll("\\p{Punct}", "");
                bufferOut.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}