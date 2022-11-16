package JavaCore.Lv8.Lec11.w3;

import java.io.*;
import java.util.Comparator;
import java.util.TreeMap;

/*
CRUD для таблицы внутри файла.
Напиши программу, которая считывает с консоли путь к файлу для операций CRUD
и при запуске в зависимости от флага, переданного в параметрах обновляет данные
товара с заданным id или производит физическое удаление товара с заданным id
(удаляет из файла все данные, которые относятся к переданному id).

-u id productName price quantity
-d id

Значения параметров:
-u - флаг, который означает обновление данных товара с заданным id
-d - флаг, который означает физическое удаление товара с заданным id
(из файла удаляются все данные, которые относятся к переданному id)

id - id товара, 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Для чтения и записи файла нужно использовать FileReader и FileWriter соответственно.

Пример содержимого файла:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

Требования:
•	Программа должна считать имя файла для операций CRUD с консоли.
•	При запуске программы без параметров список товаров должен остаться неизменным.
•	При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
•	При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
•	Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        // BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        final TreeMap<String, Product> products = new TreeMap<>();
        // String filePath = buffer.readLine();
        String filePath = "D:/LessonTry/Input.txt";


        Product product = null;

        Comparator<String> myComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals(o2))
                    return 0;
                if (Integer.parseInt(o1) > Integer.parseInt(o2)) {
                    return 1;
                } else return -1;
            }
        };
        try (FileReader input = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(input, 50);
             FileWriter output = new FileWriter(filePath, true)) {
            {
                while (bufferedReader.ready()) {
                    product = Product.parseFile(bufferedReader.readLine());
                    products.put(product.getId(), product);
                }
                for (var el : products.values()) {
                    System.out.println(el.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (args.length > 0) {
            try (FileWriter output = new FileWriter(filePath)) {
                switch (args[0]) {
                    //Create Data
                    case "-c":
                        System.out.println("I'm in this thread");
                        Integer maxId = Integer.parseInt(products.keySet().stream().max(myComparator).get());

                        System.out.println("i have passed this point");
                        if (args[1].length() > 30) {
                            args[1] = args[1].substring(0, 30);
                        }
                        if (args[2].length() > 30) {
                            args[2] = args[2].substring(0, 8);
                        }
                        if (args[3].length() > 30) {
                            args[3] = args[3].substring(0, 4);
                        }
                        Product newProduct = new Product((++maxId).toString(), args[1], args[2], args[3]);
                        products.put(newProduct.getId(), newProduct);
                        writeInFile(output, products);
                        break;

                    //Upload Data in file
                    case "-u":

                        break;

                    //Delete Data in file
                    case "-d":
                        break;
                    default:
                   writeInFile(output,products);
                }
                writeInFile(output,products);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void writeInFile(Writer outputStream, TreeMap<String, Product> list) throws IOException {
        for (Product el : list.values()) {

            outputStream.write(el.toString());
         //   outputStream.
          //  outputStream.write("\n");
        }
        System.out.println("File was written");
    }

}