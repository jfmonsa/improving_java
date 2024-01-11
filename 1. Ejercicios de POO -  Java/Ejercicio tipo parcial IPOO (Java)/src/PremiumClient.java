import java.lang.Math;

public class PremiumClient extends MediumClient{
    int points;
    public PremiumClient(String name, String lastName, int idCode, short booksViewed, int pricePerBook, short maxBooks,
            int membership, int points) {
        super(name, lastName, idCode, booksViewed, pricePerBook, maxBooks, membership);
        this.points = points;
        this.maxBooks=5;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int calculateFinalAmount() {
        points=booksViewed*10;
        int off=Math.floorDiv(points, 100);
        return super.calculateFinalAmount()*2;
    }

    @Override
    public String toString() {
        return super.toString()+"\nPuntos acomulados: "+points;
    }

    
}
