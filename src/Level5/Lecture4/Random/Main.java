package Level5.Lecture4.Random;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            int a = (int) (Math.random() * 9) + 1;
            System.out.print(a);
            System.out.print(" ");
        }
        System.out.println();
        Random temp = new Random();

        for (int i = 0; i < 50; i++) {
            double a = temp.nextGaussian();

            System.out.print(a);
            System.out.print(" ");
        }
        try {
            TimeUnit.HOURS.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        byte[] massBytes = new byte[50];
        temp.nextBytes(massBytes);
        System.out.print(Arrays.toString(massBytes));
    }
}
