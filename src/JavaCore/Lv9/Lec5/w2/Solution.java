package JavaCore.Lv9.Lec5.w2;
/*
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.

Требования:
•	Программа должна считывать имя файла с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Считаем слово
*/

public class Solution {
    private static int counter = 0;

    public static void main(String[] args) {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
             FileReader input = new FileReader(buffer.readLine());
             BufferedReader inputBuffer = new BufferedReader(input)) {

            while (inputBuffer.ready()) {
                String[] temp = inputBuffer.readLine().split("\\p{P}|\\s");
                for (String el :
                        temp) {
                    if (el.equals("world")) {
                        counter++;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(counter);
    }
}