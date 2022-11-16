package Level15.Lecture2.Lambda;

interface SecuritySystem {
    void startSystem();
}

class GeneralSecurity implements SecuritySystem{

    @Override
    public void startSystem() {

    }
}

public class Anonim {

    public static void main(String[] args) {
        SecuritySystem generalSecurity = new SecuritySystem() {
            @Override
            public void startSystem() {
                System.out.println("generalSecurity system starts");
            }
        };
        SecuritySystem generalSecurity2 = new SecuritySystem() {
            @Override
            public void startSystem() {
                System.out.println("generalSecurity system starts");
            }
        };
        SecuritySystem logSecurity = new SecuritySystem() {
            @Override
            public void startSystem() {
                System.out.println("logSecurity system starts");
            }
        };
        SecuritySystem elseSecurity = new SecuritySystem() {
            @Override
            public void startSystem() {
                System.out.println("elseSecurity system starts");
            }
        };

        generalSecurity.startSystem();
        logSecurity.startSystem();
        elseSecurity.startSystem();

    }
}