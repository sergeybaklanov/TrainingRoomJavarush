package Level6.Lecture3.Symbol;

public class Symbols {
    public static void main(String[] args) {
reference(2);
    }
    public static void reference (int digit)
    {
        int tempInt=switch (digit){
            case 1-> 1;
            case 2-> 2;
            case 3-> 3;
            case 4-> 4;
            case 5-> 5;
            default -> 6;
        };
        System.out.println(tempInt);
    }
}
