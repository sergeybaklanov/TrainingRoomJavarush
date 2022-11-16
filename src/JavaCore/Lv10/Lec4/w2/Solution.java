package JavaCore.Lv10.Lec4.w2;


import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
Как сериализовать JavaRush?

Сделай так, чтобы сериализация класса JavaRush была возможной.

Требования:
•	Класс JavaRush должен существовать внутри класса Solution.
•	Класс JavaRush должен быть статическим.
•	Класс JavaRush должен быть публичным.
•	Должна быть возможна сериализация класса JavaRush.
*/

public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();

        public  void saveObject(OutputStream outputStream) {
            try (ObjectOutputStream objectOutput = new ObjectOutputStream(outputStream)) {
                objectOutput.writeObject(this);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static JavaRush loadObject(InputStream inputStream){
            JavaRush temp = null;
            try(ObjectInputStream objectInput = new ObjectInputStream(inputStream)) {
               temp =(JavaRush) objectInput.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return temp;
        }

        @Override
        public String toString() {
            return "JavaRush{" +
                    "users=" + users +
                    '}';
        }
    }

    public static void main(String[] args) {

        try (OutputStream outputStream = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\TraningRoom\\src\\JavaCore\\Lv10\\Lec4\\w2\\OutputFile.txt");
        InputStream inputStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\TraningRoom\\src\\JavaCore\\Lv10\\Lec4\\w2\\OutputFile.txt")){


            User user1 = new User();
            {
                user1.setBirthDate(new Date(90, Calendar.JULY, 5));
                user1.setCountry(User.Country.UKRAINE);
                user1.setMale(true);
                user1.setFirstName("Sergey");
                user1.setLastName("Baklanov");
            }

            User user2 = new User();
            {
                user2.setBirthDate(new Date(92, Calendar.JUNE, 14));
                user2.setCountry(User.Country.UKRAINE);
                user2.setMale(false);
                user2.setFirstName("Juliya");
                user2.setLastName("Baklanova");
            }

            JavaRush javaRush = new JavaRush();
            javaRush.users.add(user1);
            javaRush.users.add(user2);

            javaRush.saveObject(outputStream);
            JavaRush newJavaRush = JavaRush.loadObject(inputStream);
            System.out.println(javaRush);
            System.out.println(newJavaRush);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
