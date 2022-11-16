package Level9.Lecture02.ArrayLists;

import java.util.*;

public class Lists {

    public static ArrayList<String> arrayList = new ArrayList<>();


    public static void main(String[] args) {

        arrayList.add("Julia");
        arrayList.add("Stanislav");
        arrayList.add("Victor");
        arrayList.add("Olga");
        arrayList.add("Nikolay");
        arrayList.add("Vladimir");
        arrayList.add("Sergey");
        arrayList.add("Julia");

        System.out.println(arrayList.get(6));
        arrayList.set(6, "Andrew");

        for (var element : arrayList) {
            System.out.print(element + " ");
        }
        arrayList.remove(6);
        arrayList.remove("Julia");

        String[] array = new String[arrayList.size()];
        arrayList.toArray(array);
        System.out.println("\n" + Arrays.toString(array));

        LinkedList<String> linkedList = new LinkedList<>(arrayList);
        Iterator<String> iteratorLinkedList = linkedList.iterator();
        System.out.println("This is from linked list");

        while (iteratorLinkedList.hasNext()) {
            System.out.print(iteratorLinkedList.next() + " ");
        }

    }
}
