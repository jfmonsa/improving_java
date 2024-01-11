public class App {
    public static void main(String[] args) {
        BasicClient basicClient = new BasicClient(1, "Doe", "John", 2);
        IntermediateClient intermediateClient = new IntermediateClient(2, "Smith", "Alice", 3);
        PremiumClient premiumClient = new PremiumClient(3, "Johnson", "Bob", 5, 50);

        System.out.println(basicClient.toString());
        System.out.println("\n-----------------\n");
        System.out.println(intermediateClient.toString());
        System.out.println("\n-----------------\n");
        System.out.println(premiumClient.toString());

        // Assuming PremiumClient accumulates points for downloading/viewing
        premiumClient.accumulatePoints();
        System.out.println("\nAfter accumulating points:\n");
        System.out.println(premiumClient.toString());
    }
}
