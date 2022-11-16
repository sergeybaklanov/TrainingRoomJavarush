package JavaCore.Lv9.Lec8.w5;
/*
Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить весь текст и на консоль и в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
 */

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream oldStream = System.out;
        try(
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(bufferedReader.readLine());
        ) {
            PrintStream newPrintStream = new PrintStream(byteArrayOutputStream);
            System.setOut(newPrintStream);
            testString.printSomething();
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            String res = byteArrayOutputStream.toString();
            System.setOut(oldStream);
            System.out.println(res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}