package Level15.Lecture4.StreamAPIM;

import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {

        int [] mas = {-5,-3,-2,-1,0,2,6,59,8,-10,-25,5};
        long count = IntStream.of(mas)
                .filter(a1->a1>0).count();
        System.out.println(count);
    }
}
