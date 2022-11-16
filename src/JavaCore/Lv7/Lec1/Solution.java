package JavaCore.Lv7.Lec1;
/*
Продвижение на политических дебатах
1. Разберись, что делает программа.
2. Нужно сделать так, чтобы Иванов сказал больше всего речей на политических дебатах.
3. Подумай, какой метод можно вызвать у объекта ivanov, чтобы Иванов разговаривал,
 пока не завершится всё свободное время.

Требования:
•	Вызови метод join у нужного объекта.
•	Метод toString класса политик Politician должен выводить сколько речей сказал политик,
 например: "Иванов сказал речь 35 раз".
•	Программа должна создавать 3 объекта типа Politician.
•	Методы, которые отвечают за вывод в консоль, не изменять.
•	Вывод программы должен свидетельствовать о том, что Иванов сказал больше всего речей на
 политических дебатах.
*/

public class Solution implements Runnable {
    private boolean isCancel = false;


    public static void main(String[] args) throws InterruptedException {
        Solution solution =new Solution();
        Thread th = new Thread(solution);
        Thread th2 = new Thread(solution);
        th.start();
        Thread.sleep(250);
        th2.start();
        System.out.println(th.isAlive());
        System.out.println(th.isDaemon());
        System.out.println(th.isDaemon());

        Thread.sleep(2000);
        th.interrupt();
        th2.interrupt();

    }
    public void cancel(){
        isCancel=true;
    }

    public void run() {
        Thread current = Thread.currentThread();
        try {
            while (!current.isInterrupted()) {
                System.out.print("Tik-");
                Thread.sleep(50000);
                System.out.println("Tak");
                Thread.sleep(50000);
            }
        } catch (InterruptedException e) {
            System.out.println("STOP!");
           // e.printStackTrace();
        }
    }
}

