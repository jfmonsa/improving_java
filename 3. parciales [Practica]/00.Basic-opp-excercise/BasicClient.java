public class BasicClient extends Client {
    private final int visualizationCost = 1000;
    private int booksViewedOrDownloaded;

    public BasicClient(int id, String lastName, String name, int booksViewedOrDownloaded) {
        super(id, lastName, name);
        this.booksViewedOrDownloaded = booksViewedOrDownloaded;
    }

    public int calculateMembershipFee() {
        return booksViewedOrDownloaded * visualizationCost;
    }

    public String toString() {
        return "Basic Client: " + getName() + " " + getLastName() +
                "\nBooks Viewed or Downloaded: " + booksViewedOrDownloaded +
                "\nMembership Fee: $" + calculateMembershipFee();
    }

    public int getVisualizationCost() {
        return visualizationCost;
    }

    
}