package JavaCore.Lv9.Lec11.w1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
*/

public class Solution {

    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
             FileReader oldFile = new FileReader
                     ("C:/Users/User/IdeaProjects/TraningRoom/src/JavaCore/Lv9/Lec11/w1/file1");
             FileReader updatedFle = new FileReader
                     ("C:/Users/User/IdeaProjects/TraningRoom/src/JavaCore/Lv9/Lec11/w1/file2");
             BufferedReader oldFileBuffer = new BufferedReader(oldFile);
             BufferedReader updatedFileBuffer = new BufferedReader(updatedFle)) {

            List<String> oldFileLines = new ArrayList<>();
            String strOldFile = "";
            while ((strOldFile = oldFileBuffer.readLine()) != null) {
                oldFileLines.add(strOldFile);
            }

            List<String> updatedFileLines = new ArrayList<>();
            String strUpdatedFile = "";
            while ((strUpdatedFile = updatedFileBuffer.readLine()) != null) {
                updatedFileLines.add(strUpdatedFile);
            }

            LineItem lineItem = null;
            boolean flag = true;

            for (int i = 0; i < oldFileLines.size(); i++) {
                for (int j = 0; j < updatedFileLines.size(); j++) {
                    if (oldFileLines.get(i).equals(updatedFileLines.get(j))) {
                        lineItem = new LineItem(Type.SAME, oldFileLines.get(i));
                        break;

                    } else if(!oldFileLines.get(i).equals(updatedFileLines.get(j))) {

                    }
                }
            }


            for (var element : lines) {
                System.out.println(element);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return String.format("%-10s%s", type.toString(), line);
        }
    }
}