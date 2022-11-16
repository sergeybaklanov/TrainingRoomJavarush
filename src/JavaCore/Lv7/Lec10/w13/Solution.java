package JavaCore.Lv7.Lec10.w13;

/*
Посчитаем
1. Сделай так, чтобы результат успел посчитаться для всех элементов массива values НЕ используя
Thread.sleep в методе main(String[] args)
2. Исправь synchronized блок так, чтобы массив values заполнился значением 1

Требования:
•	Класс Solution должен содержать класс Counter.
•	Класс Counter должен быть нитью.
•	Метод run() класса Counter должен содержать synchronized блок.
•	Synchronized блок метода run() не должен блокировать мьютекс this.
•	Метод main(String[] args) класса Solution не должен использовать Thread.sleep().
•	Для каждой нити, в методе main(String[] args) класса Solution используй метод, который ожидает завершение нити.
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();
        System.out.println(Arrays.toString(values));

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (Solution.class) {
                    incrementCount();
                    values[getCount()]++;
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            } while (getCount() < 100);
        }
    }
}
