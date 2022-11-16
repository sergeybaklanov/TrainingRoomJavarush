package Level15.Lecture2.Lambda;

public class Bicycle {
    Handle handle;
    Seat seat;


    private String model;
    private int weight;
    private int seatPostParameter;

    public Bicycle(String model, int weight, int seatPostParameter) {
        this.model = model;
        this.weight = weight;
        this.seatPostParameter = seatPostParameter;
        handle = new Handle();
        seat = new Seat();
    }

    public void start() {
        System.out.println("Come on!!");
    }

    public class Seat {
        public void up() {
            System.out.println("Take up");
        }

        public void down() {
            System.out.println("Take down");
        }

        public void showSeatDiameter() {
            System.out.println("Diameter of seat is " + Bicycle.this.seatPostParameter);
        }

    }

     public class Handle {
        public void left() {
            System.out.println("Turn to the left");
        }

        public void right() {
            System.out.println("Turn to the right");
        }
    }
}
