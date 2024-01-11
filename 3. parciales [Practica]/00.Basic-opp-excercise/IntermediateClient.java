public class IntermediateClient extends Client {
    private final int monthlyMembershipFee = 30000;
    private final int maxDownloads = 3;
    private int booksViewedOrDownloaded;

    public IntermediateClient(int id, String lastName, String name, int booksViewedOrDownloaded) {
        super(id, lastName, name);
        this.booksViewedOrDownloaded = booksViewedOrDownloaded;
    }

    public int calculateMembershipFee() {
        return monthlyMembershipFee + booksViewedOrDownloaded * 1000;
    }

    public String toString() {
        return "Intermediate Client: " + getName() + " " + getLastName() +
                "\nBooks Viewed or Downloaded: " + booksViewedOrDownloaded +
                "\nMembership Fee: $" + calculateMembershipFee();
    }
}