package Level9.Lecture02.Collections;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Random;

public class Collections {
   static ArrayList <String> list = new ArrayList<>(){{
        add("Julia");
        add("Sergey");
        add("Stanislav");
        add("Olga");
        add("Nikolay");
        add("Mark");
        add("Andrew");
        add("Anatolii");
        add("Viola");
    }};
   static ArrayList<String> addArray = new ArrayList<>(){{
        add("Stanislav");

        add("Nikolay");

        add("Andrew");
    }};

   public  static <T> void printArrayList (ArrayList <T> list){
       for (var element: list) {
           System.out.print(element+" ");
       }
       System.out.println();
   }

    public static void main(String[] args) {
       printArrayList(list);
       printArrayList(addArray);

        System.out.println(list.removeAll(addArray));

        printArrayList(list);




    }
}
