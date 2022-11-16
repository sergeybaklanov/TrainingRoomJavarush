package JavaCore.Lv9.Lec8.w4;


import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;

/*
Решаем пример

В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9

Требования:
•	Класс Solution должен содержать класс TestString.
•	Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
•	Класс TestString должен содержать публичный void метод printSomething().
•	Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
•	Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
•	Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
•	Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
•	Метод main(String[] args) класса Solution должен модифицировать строку выведенную методом printSomething() согласно заданию, и выводить её в консоль.
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream defaultConsoleOut = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        new TestString().printSomething();

        System.setOut(defaultConsoleOut);

        String mathString = byteArrayOutputStream.toString();
        String[] elements = mathString.split(" ");

        int result;
        switch (elements[1]) {
            case "+":
                result = Integer.parseInt(elements[0]) + Integer.parseInt(elements[2]);
                break;
            case "-":
                result = Integer.parseInt(elements[0]) - Integer.parseInt(elements[2]);
                break;
            case "*":
                result = Integer.parseInt(elements[0]) * Integer.parseInt(elements[2]);
                break;
            default:
                throw new NumberFormatException();
        }
        System.out.printf("%s %s %s = %d",elements[0],elements[1],elements[2],result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 * 6 = ");
        }
    }
}

