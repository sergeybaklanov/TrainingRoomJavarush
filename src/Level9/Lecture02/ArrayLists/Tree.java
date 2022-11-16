package Level9.Lecture02.ArrayLists;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Tree {

    int value;
    Tree left;
    Tree right;


    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree(int value) {
        this.value = value;
    }

    public int summ() {
        int summ = value;
        if (this.right != null) {
            summ += right.summ();
        }
        if (this.left != null) {
            summ += left.summ();
        }
        return summ;
    }
    public static boolean isPalindrome(String digit)
    {
        boolean result=true;
       char [] element = digit.toCharArray();
        for (int i = 0; i < element.length; i++) {
            if(element[i]!= element[element.length-1-i])
                result = false;
        }
        return  result;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(20,
                new Tree(7,
                        new Tree(4, null, new Tree(6)),
                        new Tree(9)),
                new Tree(35,
                        new Tree(31, new Tree(28), null),
                        new Tree(40, new Tree(38), new Tree(52))));

        System.out.println(tree.summ());

        Set<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return 1;
                if (o1 < o2) return -1;
                return 0;
            }
        });

        set.add(1);
        set.add(2);
        set.add(1);
        System.out.println(set);

        System.out.println(isPalindrome("123210"));

    }
}
