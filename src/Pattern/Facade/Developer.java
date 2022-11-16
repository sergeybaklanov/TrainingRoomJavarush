package Pattern.Facade;

public class Developer {
    public void checkBugTracker(BugTracker bugTracker)
    {
        if(bugTracker.isStatus()){
            System.out.println("Developer is looking problems");
        } else {
            System.out.println("developer is working");
        }
    }
}
