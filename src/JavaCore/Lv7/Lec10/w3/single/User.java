package JavaCore.Lv7.Lec10.w3.single;

public class User {
    public static void main(String[] args) {
        Logger.getLogger().addLogInfo("Logger 1");
        Logger.getLogger().addLogInfo("Logger 2");
        Logger.getLogger().addLogInfo("Logger 3");
        Logger.getLogger().addLogInfo("Logger 4");
        System.out.println(Logger.getLogger().getFileLog());
    }
}
