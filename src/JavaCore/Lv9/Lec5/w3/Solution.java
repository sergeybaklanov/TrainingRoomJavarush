package JavaCore.Lv9.Lec5.w3;

import java.io.*;
import java.util.regex.Pattern;

/*
Считать с консоли 2 пути к файлам.
Вывести во второй файл все целые числа, которые есть в первом файле (54у не является числом).
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1

Требования:
•	Программа должна считывать пути к файлам с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
•	Поток чтения из файла (BufferedReader) должен быть закрыт.
•	Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
•	Поток записи в файл (BufferedWriter) должен быть закрыт.
 */
public class Solution {
    public static void main(String[] args) {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             FileReader input = new FileReader(bufferedReader.readLine());
             FileWriter output = new FileWriter(bufferedReader.readLine());
             BufferedReader buffer = new BufferedReader(input);
             BufferedWriter bufferedWriter = new BufferedWriter(output)) {
            while(buffer.ready()) {
                String[] temp = buffer.readLine().split("\\s");

                for (int i = 0; i < temp.length; i++) {
                    if (Pattern.matches("\\d*", temp[i])) {
                        bufferedWriter.write(temp[i]+" ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
