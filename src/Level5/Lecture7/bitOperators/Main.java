package Level5.Lecture7.bitOperators;

public class Main {
    public static void main(String[] args) {
        int a = 555^0b0010101001;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(a^0b0010101001);
    }
}
