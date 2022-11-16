package Pattern.Adapter;

public class Client {


    public static void main(String[] args) {
        Adapter adapter = new ConcreteAdapter(new Adaptee());
        adapter.operation();
    }

}
