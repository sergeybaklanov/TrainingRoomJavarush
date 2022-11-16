package Pattern.Decorator.w1;

public class SeniorJavaDeveloper  extends DeveloperDecorator{
    public SeniorJavaDeveloper(Developer developer) {
        super(developer);
    }
    public static String makeCodeReview(){
        return "Make Code review ";
    }

    @Override
    public String makeJob() {
        return super.makeJob()+makeCodeReview();
    }
}
