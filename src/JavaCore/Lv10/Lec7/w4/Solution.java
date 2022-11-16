package JavaCore.Lv10.Lec7.w4;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
Serializable Solution
Сериализуй класс Solution.
Подумай, какие поля не нужно сериализовать, пометь ненужные поля модификатором transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream);
2) создать экземпляр класса Solution - savedObject;
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть);
4) создать другой экземпляр класса Solution с другим параметром;
5) загрузить из потока на чтение объект - loadedObject;
6) проверить, что savedObject.string равна loadedObject.string;
7) обработать исключения.

Требования:
•	Поле pattern должно быть отмечено модификатором transient.
•	Поле currentDate должно быть отмечено модификатором transient.
•	Поле temperature должно быть отмечено модификатором transient.
•	Поле string НЕ должно быть отмечено модификатором transient.
*/

public class Solution implements Serializable {
    public static void main(String[] args) {
      //  System.out.println(new Solution(4));


        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\TraningRoom\\src\\JavaCore\\Lv10\\Lec7\\w4\\FileInput.txt");
             OutputStream outputStream = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\TraningRoom\\src\\JavaCore\\Lv10\\Lec7\\w4\\FileInput.txt")
        ) {
            ObjectOutputStream writer = new ObjectOutputStream(outputStream);
            ObjectInputStream loader = new ObjectInputStream(inputStream);

            Solution savedObject = new Solution(25);
            System.out.println(savedObject);
            writer.writeObject(savedObject);
            System.out.println("+++++++++++++++++++++++++++");

            Solution loadedObject = new Solution(30);
            System.out.println(loadedObject);
            loadedObject = (Solution) loader.readObject();
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println(loadedObject);

            System.out.println(loadedObject.equals(savedObject));
            loader.close();
            writer.close();


        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return string.equals(solution.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}

