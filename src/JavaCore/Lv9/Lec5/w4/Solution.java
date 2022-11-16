package JavaCore.Lv9.Lec5.w4;

/*
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла и заменить все точки "." на знак "!".
Результат вывести во второй файл.
Закрыть потоки.

Требования:
•	Программа должна считывать имена файлов с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
•	Поток чтения из файла (BufferedReader) должен быть закрыт.
•	Программа должна записывать во второй файл содержимое первого файла, где заменены все точки "." на знак "!" (Для записи в файл используй BufferedWriter с конструктором FileWriter).
•	Поток записи в файл (BufferedWriter) должен быть закрыт.
 */

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        try(BufferedReader addressReader = new BufferedReader(new InputStreamReader(System.in));
            FileReader input = new FileReader(String.valueOf(addressReader.readLine()));
            BufferedReader buffer = new BufferedReader(input);
            FileWriter output = new FileWriter(String.valueOf(addressReader.readLine()));
            BufferedWriter bufferOut = new BufferedWriter(output)) {
            while(buffer.ready()){
                String temp = buffer.readLine().replace(".","!");
                bufferOut.write(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
