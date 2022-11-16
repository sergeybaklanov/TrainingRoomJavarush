package SOLID.InterfaceSegregationPrinciple;

public class Client implements ClientInterface {
    FacadeInterface facade;

    public Client(FacadeInterface facade){
        this.facade=facade;
    }

    @Override
    public void getName() {
        facade.getName();
    }
}
