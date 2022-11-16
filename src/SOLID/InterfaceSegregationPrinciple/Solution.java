package SOLID.InterfaceSegregationPrinciple;

public class Solution {
    public static void main(String[] args) {
        FacadeInterface facade = Facade.facade;
        facade.getAge();
        facade.getName();

        ClientInterface client = new Client(facade);

        client.getName();

    }
}
