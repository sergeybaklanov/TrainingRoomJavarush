package JavaCore.Lv8.Lec8.w2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Расширяем AmigoOutputStream

Используя шаблон проектирования Wrapper (Decorator) расширь функциональность AmigoOutputStream.
В классе QuestionFileOutputStream при вызове метода close() должна быть реализована следующая функциональность:
1. Вывести в консоль фразу "Вы действительно хотите закрыть поток? Д/Н".
2. Считай строку.
3. Если считанная строка равна "Д", то закрыть поток.
4. Если считанная строка не равна "Д", то не закрывать поток.

Требования:
•	Интерфейс AmigoOutputStream изменять нельзя.
•	Класс QuestionFileOutputStream должен реализовывать интерфейс AmigoOutputStream.
•	Класс QuestionFileOutputStream должен инициализировать в конструкторе поле типа AmigoOutputStream.
•	Все методы QuestionFileOutputStream должны делегировать свое выполнение объекту AmigoOutputStream.
•	Метод close() должен спрашивать у пользователя "Вы действительно хотите закрыть поток? Д/Н".
•	Метод close() должен закрывать поток только в случае, если считает с консоли ответ "Д".
 */

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream amigoOutputStream;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
        this.amigoOutputStream = amigoOutputStream;
    }

    @Override
    public void flush() throws IOException {
        amigoOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        amigoOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        amigoOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        amigoOutputStream.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        String str = "Д";
        InputStream is = new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8));
        System.setIn(is);
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        Scanner console = new Scanner(System.in);
        String answer = console.nextLine();

        if (answer.equals("Д")) {
            System.out.println("was closed");
            amigoOutputStream.close();
        }
    }

    public static void main(String[] args) {


    }
}