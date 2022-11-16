package SOLID.InterfaceSegregationPrinciple;

public class Facade implements FacadeInterface {
    public static final Facade facade = new Facade();

    private Facade() {
    }

    private int age;
    private String name;

    @Override
    public void getName() {
        System.out.println("Name = " + name);
    }

    @Override
    public void getAge() {
        System.out.println("Age = " + age);
    }
}
