public class MediumClient extends BasicClient {
    short maxBooks=3;
    static int membership=30000;

    public MediumClient(String name, String lastName, int idCode, short booksViewed, int pricePerBook, short maxBooks,
            int membership) {
        super(name, lastName, idCode, booksViewed, pricePerBook);
        this.maxBooks = maxBooks;
        MediumClient.membership = membership;
    }

    public short getMaxBooks() {
        return maxBooks;
    }

    public void setMaxBooks(short maxBooks) {
        this.maxBooks = maxBooks;
    }

    public static int getMembership() {
        return membership;
    }

    public static void setMembership(int membership) {
        MediumClient.membership = membership;
    }

    //Poliformism
    @Override
    public int calculateFinalAmount() {
        return membership+membership*(int)0.20;
    }
}

