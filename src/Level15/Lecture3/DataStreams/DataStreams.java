package Level15.Lecture3.DataStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class DataStreams {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"Julia","Morgana", "Sergey", "Andrew","Nikolay");
        String maxLength = list.stream().max((s1,s2)->s1.length()-s2.length()).get();
        System.out.println(maxLength);

        Integer [] ms = new Integer[]
        {1,2,3,4,5,6,7,8,9,10,15,2,5,8,4,6,9,8,7,51,323,21,5,4,8,6};
        Stream<Integer> stream=Arrays.stream(ms);
        Integer [] res = stream.sorted((a1,a2)->a1-a2).distinct().filter(a1->a1>=10).toArray(Integer[]::new);
        System.out.println(Arrays.toString(res));

    }
}
