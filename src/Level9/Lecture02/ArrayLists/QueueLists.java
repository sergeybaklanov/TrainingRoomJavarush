package Level9.Lecture02.ArrayLists;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueLists {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();

        queue.offer("Julia");
        queue.offer("Stanislav");
        queue.offer("Victor");
        queue.offer("Olga");
        queue.offer("Nikolay");
        queue.offer("Vladimir");
        queue.offer("Sergey");
        queue.offer("Julia2");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }


    }
}
