package JavaCore.Lv7.Lec1;

import java.util.concurrent.CountDownLatch;

public class CotDown {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            (new MyThread(latch)).start();
        }
    }

    static class MyThread extends Thread {
        private final CountDownLatch latch;

        public MyThread(CountDownLatch latch) {
            this.latch = latch;
        }
//
//        public void run() {
//            try {
//             //   doSomething();
//            } catch (InterruptedException ex) {
//                System.out.println(getName()+" Was interrupted");
//            }
//        }
    }


}
