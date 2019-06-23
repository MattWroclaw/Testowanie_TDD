/**
 * Klasa główna
 */
public class Main {
    /**
     * @param args Argumnety które są dostarczane z wywołania konsoli
     */
    public static void main(String[] args) {
        PetBuilder petBuilder = new PetBuilder();
       Pet grububyFafik =  petBuilder.setName("Fafik").setAge(5).setHeight(10).setWeight(50).build();
        System.out.println(Calculator.doPotegiN(3,0.5));


    }
}
