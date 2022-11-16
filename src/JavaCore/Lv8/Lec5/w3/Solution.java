package JavaCore.Lv8.Lec5.w3;

import java.io.*;

/*
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String firstFile = buffer.readLine();
        String secondFile = buffer.readLine();
        String thirdFile = buffer.readLine();

        try(FileInputStream input = new FileInputStream(firstFile);
                FileOutputStream output1 = new FileOutputStream(secondFile);
                FileOutputStream output2 = new FileOutputStream(thirdFile)){
            if(input.available()==-1){
                throw new IOException("File is empty");
            }
            byte [] bufferBytes = new byte[(input.available()+1)/2];

            int count = input.read(bufferBytes);
               output1.write(bufferBytes,0,count);

               count =input.read(bufferBytes);
               output2.write(bufferBytes,0,count);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}