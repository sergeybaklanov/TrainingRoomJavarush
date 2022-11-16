package JavaCore.Lv8.Lec11.w1;

/*
Шифровка
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class Solution {
    private static final int code= 5;
    public static void main(String[] args) {
        if(args.length<=0){
            throw  new RuntimeException("Ошибка с вводом параметррв");
        }

        try (FileInputStream input = new FileInputStream(args[1]);
             FileOutputStream output = new FileOutputStream(args[2]);
             BufferedInputStream buffer = new BufferedInputStream(input)) {
            int a;
            switch (args[0]) {
                case "-e" -> {
                    while ((a=buffer.read())!=-1){
                        output.write(a+code);
                    }
                }
                case "-d" -> {
                    while ((a=buffer.read())!=-1){
                        output.write(a-code);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
