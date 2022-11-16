package Pattern.Facade;

public class WorkFlow {
    Program program = new Program();
    Developer developer = new Developer();
    BugTracker bugTracker = new BugTracker();

    public void work  (){
        program.runProgram();
        bugTracker.setStatus(true);
        developer.checkBugTracker(bugTracker);
        bugTracker.setStatus(false);
        developer.checkBugTracker(bugTracker);
    }
}
