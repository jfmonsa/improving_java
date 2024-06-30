public class PremiumClient extends Client {
    private final int monthlyMembershipFee = 2 * 30000;
    private final int maxDownloads = 5;
    private int booksViewedOrDownloaded;
    private int points;

    public PremiumClient(int id, String lastName, String name, int booksViewedOrDownloaded, int points) {
        super(id, lastName, name);
        this.booksViewedOrDownloaded = booksViewedOrDownloaded;
        this.points = points;
    }

    public int calculateMembershipFee() {
        return (int) (monthlyMembershipFee * 1.20 + booksViewedOrDownloaded * 1000);
    }

    public void accumulatePoints() {
        points += booksViewedOrDownloaded * 10;
    }

    public int getPoints() {
        return points;
    }

    public int calculateFreeBooks() {
        int freeBooks = points / 100;
        points = points % 100; // Remaining points
        return freeBooks;
    }

    public String toString() {
        return "Premium Client: " + getName() + " " + getLastName() +
                "\nBooks Viewed or Downloaded: " + booksViewedOrDownloaded +
                "\nMembership Fee: $" + calculateMembershipFee() +
                "\nPoints Accumulated: " + points +
                "\nFree Books Available: " + calculateFreeBooks();
    }
}