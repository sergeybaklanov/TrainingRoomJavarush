package JavaCore.Lv9.Lec3.w4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/*
И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним аргументом типа Scanner.

Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные только одного человека.

Требования:
•	PersonScanner должен быть интерфейсом.
•	Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
•	Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
•	Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
•	Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
•	Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного человека, в виде объекта класса Person.
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {


        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner) {
            fileScanner = scanner;
        }


        @Override
        public Person read() throws IOException {

            Person person = null;
            if (fileScanner.hasNext()) {
                String stringFromFile = fileScanner.nextLine();
                String[] personData = stringFromFile.split(" ");

                Calendar calendar = new GregorianCalendar(Integer.parseInt(personData[5]), Integer.parseInt(personData[4]) - 1, Integer.parseInt(personData[3]));
                Date date = calendar.getTime();
                person = new Person(personData[1], personData[2], personData[0], date);
            }
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
