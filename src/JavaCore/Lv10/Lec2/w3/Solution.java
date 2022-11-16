package JavaCore.Lv10.Lec2.w3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
В методе main() происходит считывание пути к файлу с консоли и заполнение runtimeStorage данными из файла.
Тебе необходимо в методе save() реализовать логику записи в файл для карты runtimeStorage,
а в методе load() - логику чтения из файла для runtimeStorage.
Файл должен быть в формате .properties. Комментарии в файле игнорируй.
Про .properties прочитай в вики.
Подсказка: используй объект класса Properties.

Требования:
•	Метод save() должен сохранять карту runtimeStorage в параметр outputStream.
•	Метод load() должен восстанавливать состояние карты runtimeStorage из параметра inputStream.
 */

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();
    public static Properties properties = new Properties();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        for (Map.Entry<String,String> element:
            runtimeStorage.entrySet() ) {
            properties.setProperty(element.getKey(), element.getValue());
        }
    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
