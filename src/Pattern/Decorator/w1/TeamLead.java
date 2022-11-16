package Pattern.Decorator.w1;

public class TeamLead extends DeveloperDecorator{
    public TeamLead(Developer developer) {
        super(developer);
    }
    public static String getConnectionWithCustomer(){
        return "Make discussion with Customer ";
    }

    @Override
    public String makeJob() {
        return super.makeJob()+getConnectionWithCustomer();
    }
}
