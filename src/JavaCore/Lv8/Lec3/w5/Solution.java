package JavaCore.Lv8.Lec3.w5;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
Ввести с консоли имя файла.
        Считать все байты из файла.
        Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
        Вывести на экран.
        Закрыть поток ввода-вывода.

        Пример байт входного файла:
        44 83 44

        Пример вывода:
        44 83

        Требования:
        •	Программа должна считывать имя файла с консоли.
        •	Для чтения из файла используй поток FileInputStream.
        •	В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
        •	Данные в консоль должны выводится в одну строку.
        •	Поток чтения из файла должен быть закрыт.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> integerSet = new TreeSet<>();
       // int[] bytesArray = new int[256];
        String fileAddress = buffer.readLine();

        try (FileInputStream input = new FileInputStream(fileAddress)) {
            while(input.available()>0){
                integerSet.add(input.read());
            }
            for (var element: integerSet) {
                System.out.print(element+" ");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}