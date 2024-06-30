package library;

public class Book {
    public String name;
    private String author, publisher, adress /*Collection location*/, status /*Borrow status*/;
    private int qty /*Copies for sale*/, brwcopies /*Price*/;
    private double price /*Copies for borrowing*/;

    public Book(String name, String author, String publisher, String adress, String status, int qty, int brwcopies,
    double price) {
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.adress = adress;
        this.status = status;
        this.qty = qty;
        this.brwcopies = brwcopies;
        this.price = price;
    }
    
    
    //Setters & getters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getAdress() {
        return adress;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getQty() {
        return qty;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getBrwcopies() {
        return brwcopies;
    }
    public void setBrwcopies(int brwcopies) {
        this.brwcopies = brwcopies;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book name:" + name + ", author: " + author + ", publisher: " + publisher + ", Collection adress:" + adress
                + ", Borrow status:" + status + ", Qty:" + String.valueOf(qty) + ", Borrowing copies:" + brwcopies + ", price:" + String.valueOf(price) + "]";
    }
}
