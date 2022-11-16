package JavaCore.Lv8.Lec11.w2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;

/*
++++++++++++++++++++++++
Прайсы
CRUD для таблицы внутри файла.
Напиши программу, которая считывает с консоли путь к файлу для операций CRUD и при запуске со следующим набором параметров:
-c productName price quantity
добавляет товар с заданными параметрами в конец файла, генерируя id (8 символов) самостоятельно путем
инкремента максимального id, найденного в файле.

Значения параметров:
-c - флаг, который означает добавления товара.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity

Данные дополнены пробелами до их длины.

Для чтения и записи файла нужно использовать FileReader и FileWriter соответственно.

Пример содержимого файла:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

Требования:
•	Программа должна считать имя файла для операций CRUD с консоли.
•	В классе Solution не должны быть использованы статические переменные.
•	При запуске программы без параметров список товаров должен остаться неизменным.
•	При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
•	Товар должен иметь следующий id, после максимального, найденного в файле.
•	Форматирование новой строки товара должно четко совпадать с указанным в задании.
•	Созданные для файлов потоки должны быть закрыты.
*/

/*
public class Solution {

    public static void main(String[] args) throws Exception {

       // BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        final HashMap<String, Product> products = new HashMap();
        //String filePath = buffer.readLine();
        String filePath = "D:/LessonTry/Input1.txt";


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

            while (bufferedReader.ready()) {
                product = parseFile(bufferedReader.readLine());
                products.put(product.getId(), product);
            }

            if (args.length > 0) {
                switch (args[0]) {
                    case "-c":
                        Integer maxId = Integer.parseInt(products.keySet().stream().max(myComparator).get());
                        if(args[1].length()>30){
                            args[1]=args[1].substring(0,30);
                        }
                        if(args[2].length()>30){
                            args[2]=args[2].substring(0,8);
                        }
                        if(args[3].length()>30){
                            args[3]=args[3].substring(0,4);
                        }
                        String writeInFile = String.format("%-8d%-30s%-8s%-4s", ++maxId, args[1], args[2], args[3]);
                        output.write("\n");
                        output.write(writeInFile);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Product parseFile(String temp) throws IOException {
        if (temp == null) {
            throw new IOException();
        }
        Product product = new Product();
        product.setId(temp.substring(0, 8).trim());
        product.setProductName(temp.substring(8, 38).trim());
        product.setPrice(temp.substring(38, 46).trim());
        product.setQuantity(temp.substring(46).trim());
        return product;
    }
}

 */