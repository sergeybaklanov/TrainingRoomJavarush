package JavaCore.Lv9.Lec5.w1;

import java.io.*;

/*
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).

Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод

Требования:
•	Программа должна считывать имена файлов с консоли (используй BufferedReader).
•	BufferedReader для считывания данных с консоли должен быть закрыт.
•	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
•	Поток чтения из файла (FileReader) должен быть закрыт.
•	Программа должна записывать во второй файл все символы из первого файла с четным порядковым номером (используй FileWriter).
•	Поток записи в файл (FileWriter) должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) {
        

        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
             FileReader fileReader = new FileReader(buffer.readLine());
             FileWriter fileWriter = new FileWriter(buffer.readLine())) {
            int counter=1;
            while (fileReader.ready()){
               int temp=fileReader.read();
               if(counter%2==0){
                   fileWriter.write(temp);
               }
               counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
