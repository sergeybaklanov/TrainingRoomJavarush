package Level9.Lecture7.Generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Generics {

   public static ArrayList<String> list  = new ArrayList<>(){{
        add("Element1 list");
        add("Element2 list");
        add("Element3 list");
        add("Element4 list");
    }};

    public static void main(String[] args) {
        Iterator <String> iterator = list.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
            if(iterator.equals("Element3 list"))
            iterator.remove();
        }
        System.out.println("New iterator working");
        Person person = new Person();
        person.setAge(25);
        person.setName("Sergey");

        ArrayList listObject = new ArrayList();
        listObject.add(1);
        listObject.add("String");
        listObject.add(person);

        for (var element:listObject) {
            if(element instanceof Person)
                System.out.println(((Person) element).getName() +" Person");
            if(element instanceof Integer)
                System.out.println("Integer");
            if(element instanceof String)
                System.out.println("String");
        }

          for (var element:listObject
             ) {
            System.out.println(element);

        }


    }
}

