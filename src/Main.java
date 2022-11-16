import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
      // int result=0;
        System.out.println(calculate(5,4));

    }
    public static int calculate(int a, int b){
       int  result=0;
        while (a>b){
            a=a-b;
            result ++;
        }
        return result;
    }
}
