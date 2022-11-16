package JavaCore.Lv8.Lec11.w5;

import java.io.FileReader;
import java.io.IOException;

/*
Пробелы
*/

public class Solution {
    private double count;

    public static void main(String[] args) {
        int spaceCount = 0;
        int charactersCount = 0;
        char temp =' ';
        if (args.length > 0) {
            try (FileReader input = new FileReader(args[0])) {
                while (input.ready()) {
                    temp = (char) input.read();
                    if(temp==' '){
                        spaceCount++;
                    }
                    charactersCount++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("%.2f",(double)spaceCount/charactersCount*100);
    }
}
