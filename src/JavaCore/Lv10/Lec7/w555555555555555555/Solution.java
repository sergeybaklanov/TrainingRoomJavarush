package JavaCore.Lv10.Lec7.w555555555555555555;


import java.io.*;

/*
Переопределение сериализации
Сделайте (переопределите метод readObject) так, чтобы после инициализации объекта типа
Solution посредством десериализации нить runner запускалась автоматически.
Ключевые слова объекта runner менять нельзя.

Подсказка: конструктор не вызывается при десериализации, только инициализируются все поля.

Требования:
•	Класс Solution должен поддерживать интерфейс Serializable.
•	Класс Solution должен поддерживать интерфейс Runnable.
•	Поле runner в классе Solution должно быть объявлено с модификатором transient.
•	В методе readObject должен быть создан новый объект типа Thread с текущим объектом в качестве параметра.
•	В методе readObject должен быть вызван метод start у нового объекта типа Thread.
*/

public class Solution implements Serializable, Runnable{
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        System.out.println("Doing something");
        // do something here, doesn't matter what
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    @Serial
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    @Serial
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) {

    }
}

