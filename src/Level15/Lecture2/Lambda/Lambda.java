package Level15.Lecture2.Lambda;

public class Lambda {
    public static void main(String[] args) {

        Dog dog = new Dog("Andrew", 25);
        Dog dog2 = new Dog();
        Dog dog1 = new Dog("Mark", 20) {

            @Override
            public void printInfo() {
                System.out.println("This is another dog");
            }
        };
        dog.printInfo();
        dog1.printInfo();
    }
}

class Dog {
    private String name;
    private int age;

    public  Dog(){};

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("This animal");
    }

}