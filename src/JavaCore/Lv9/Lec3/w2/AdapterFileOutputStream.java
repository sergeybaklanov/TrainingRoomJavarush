package JavaCore.Lv9.Lec3.w2;
/*
Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.

Требования:
•	AmigoStringWriter должен быть интерфейсом.
•	Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
•	Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
•	Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
•	Метод flush() класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу fileOutputStream.
•	Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу write() объекта fileOutputStream.
•	Метод close() класса AdapterFileOutputStream должен делегировать полномочие соответствующему методу fileOutputStream.
 */


import java.io.FileOutputStream;
import java.io.IOException;

/*
Адаптер
*/

public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream outputStream;

    public AdapterFileOutputStream(FileOutputStream outputStream) {
        this.outputStream = outputStream;
    }


    public static void main(String[] args) {

    }


    @Override
    public void flush() throws IOException {
        outputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        outputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
        outputStream.close();
    }
}

