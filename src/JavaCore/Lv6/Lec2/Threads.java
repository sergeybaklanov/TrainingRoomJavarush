package JavaCore.Lv6.Lec2;

public class Threads {

    public static int count;
    public String name;

    public Threads(String name) {
         ++count;
        this.name = name;
    }

    public static void main(String[] args) {
        Threads first = new Threads("First");
        Threads second = new Threads("Second");
        System.out.println(first.name+" "+first.count);
        System.out.println(second.name+" "+second.count);
    }
}