package JavaCollections.Lv1.Lec1.w1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то записать его содержимое в allFilesContent.txt.
После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).

Требования:
•	Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
•	Нужно создать поток для записи в переименованный файл.
•	Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt.
•	Поток для записи в файл нужно закрыть.
•	Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) {

    }
}
