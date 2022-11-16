package JavaCore.Lv7.Lec1;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadMy implements Runnable {
    private static AtomicInteger myInt = new AtomicInteger();
    private String name1 = "Оля";
    private String name2 = "Лена";

    public static void main(String[] args) throws InterruptedException {

        MultiThreadMy my = new MultiThreadMy();

        for (int i = 0; i < 20; i++) {
            Thread th = new Thread(my);
            Thread th2 = new Thread(my);
            th.start();
            th2.start();
            System.out.println(my + " " + my.name1.equals(my.name2));
        }
        myInt.getAndIncrement();
        myInt.getAndIncrement();
       // myInt.getAndDecrement();
        System.out.println(myInt.get());
    }

    @Override
    public String toString() {
        return "MultiThreadMy{" +
                "name1='" + name1 + '\'' +
                ", name2='" + name2 + '\'' +
                '}';
    }

    public synchronized void swap() throws InterruptedException {

        String s = name1;
        Thread.sleep(1);
        name1 = name2;
        name2 = s;


    }

    public void swap2() throws InterruptedException {
        synchronized (this) {
            String s = name1;
            Thread.sleep(1);
            name1 = name2;
            name2 = s;
        }

    }

    @Override
    public void run() {
        try {
            swap();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


