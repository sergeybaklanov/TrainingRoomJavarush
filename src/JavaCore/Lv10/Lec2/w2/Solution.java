package JavaCore.Lv10.Lec2.w2;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
Читаем и пишем в файл: JavaRush
Реализуй логику записи в файл и чтения из файла для класса JavaRush.
Пустых полей у объекта User быть не может. Дату в файле удобно хранить в формате long.
Метод main реализован только для тебя и не участвует в тестировании.

Требования:
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
•	Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
•	Класс Solution.JavaRush должен быть публичным.
•	Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("C:\\Users\\User\\IdeaProjects\\TraningRoom\\src\\JavaCore\\Lv10\\Lec2\\w2\\JavaRushClass.txt", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();

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

            javaRush.users.add(user1);
            javaRush.users.add(user2);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            if (outputStream != null) {
                if (!this.users.isEmpty()) {
                    try (OutputStreamWriter output = new OutputStreamWriter(outputStream);
                         BufferedWriter outputBuffer = new BufferedWriter(output)) {
                        for (User user :
                                this.users) {
                            String userString = user.getFirstName() + "/" +
                                    user.getLastName() + "/" +
                                    user.getBirthDate().getTime() + "/" +
                                    (user.isMale() ? "Male" : "Female") + "/" +
                                    user.getCountry() + "\n";
                            outputBuffer.write(userString);
                        }
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try (InputStreamReader reader = new InputStreamReader(inputStream);
                 BufferedReader bufferedReader = new BufferedReader(reader)) {
                while (bufferedReader.ready()) {
                    String[] stringWitUserData = bufferedReader.readLine().split("/");

                    String userFirstName = stringWitUserData[0];
                    String userLastName = stringWitUserData[1];
                    Date dateOfUserBirthday = new Date(Long.parseLong(stringWitUserData[2]));
                    boolean userIsMale = (stringWitUserData[3].equals("Male") ? Boolean.TRUE : Boolean.FALSE);
                    User.Country userCountry = User.Country.valueOf(stringWitUserData[4]);

                    User newUser = new User();

                    newUser.setFirstName(userFirstName);
                    newUser.setLastName(userLastName);
                    newUser.setBirthDate(dateOfUserBirthday);
                    newUser.setCountry(userCountry);
                    newUser.setMale(userIsMale);

                    if (users != null) {
                        boolean containsSimilarUser = false;

                        for (User user :
                            users) {
                            if (newUser.equals(user)) {
                                containsSimilarUser = true;
                                break;
                            }
                        }
                        if (!containsSimilarUser) {
                            users.add(newUser);
                        }
                    }
                }

            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return Objects.equals(users, javaRush.users);

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
