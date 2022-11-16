package Level15.Lecture1.Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class Comp {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"Sergey","Julia","Andrew");

        list.forEach(System.out::println);

    }
}
