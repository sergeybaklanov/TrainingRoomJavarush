package Level15.Lecture2.Lambda;

public class Main {
    public static void main(String[] args) {
        Bicycle peugeot = new Bicycle("Peugeot", 25, 15);

        peugeot.seat.up();
        peugeot.seat.down();

        peugeot.handle.left();
        peugeot.handle.right();
        peugeot.start();

        peugeot.seat.showSeatDiameter();



    }
}
