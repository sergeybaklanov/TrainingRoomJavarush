package JavaCore.Lv10.Lec2.w1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Читаем и пишем в файл: Human
Часто необходимо сохранять состояние работы программы. До появления сериализации каждый
 делал это своим способом. В этой задаче нужно сохранить в файл состояние работы программы
 и вычитать состояние из файла без использования сериализации.

Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для тебя и не участвует в тестировании.

Требования:
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае,
 если список assets пустой.
•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае,
 если поле name и список assets не пустые.
•	Класс Solution.Human не должен поддерживать интерфейс Serializable.
•	Класс Solution.Human должен быть публичным.
•	Класс Solution.Human не должен поддерживать интерфейс Externalizable.
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("C:/Users/User/IdeaProjects/TraningRoom/src/JavaCore/Lv10/Lec2/w1/Human.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            try (PrintWriter printer = new PrintWriter(outputStream)) {
                printer.println(this.name);
                if (this.assets.size() > 0) {
                    for (Asset current :
                            this.assets) {
                        printer.println(current.getName());
                        printer.println(current.getPrice());
                    }
                }
                printer.flush();
                //System.out.println("Saved");
            }
        }

        public void load(InputStream inputStream) throws Exception {

            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream))) {

                this.name = buffer.readLine();

                while (buffer.ready()) {
                    String assetsName = buffer.readLine();
                    double assetsPrice = Double.parseDouble(buffer.readLine());
                    this.assets.add(new Asset(assetsName, assetsPrice));
                }
               // System.out.println("Loaded");
            }
        }
    }
}
