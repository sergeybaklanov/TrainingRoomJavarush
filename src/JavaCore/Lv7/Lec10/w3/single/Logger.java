package JavaCore.Lv7.Lec10.w3.single;

public class Logger {
    private static Logger logger;
    private static String fileLog = "This is file log...";

    public Logger (){}

    public static synchronized Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public String getFileLog(){
        return fileLog;
    }
    public void addLogInfo(String str){
        fileLog+="\n"+str;
    }



}
