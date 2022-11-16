package Level7.Lecture3.ConstructorFinalElements;

public class Constructor {

    public static void main(String[] args) {

    }
}

class ConstructorStart {

    private final int a;

    public ConstructorStart() {
        a = -1;
    }

    public ConstructorStart(int a) {
        this.a = a;
    }
}