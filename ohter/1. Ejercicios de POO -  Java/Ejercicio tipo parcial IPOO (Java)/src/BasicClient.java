public class BasicClient extends Client{
    short booksViewed;
    int pricePerBook;
    int amountToPay;
    
    
    //Constructor
    public BasicClient(String name, String lastName, int idCode, short booksViewed, int pricePerBook){
        super(name, lastName, idCode);
        this.booksViewed=booksViewed;
        this.pricePerBook=pricePerBook;
    }

    //Setters & getters
    public void setBooksViewed(short booksViewed){
        this.booksViewed=booksViewed;
    }
    public short getBooksViewed(){
        return booksViewed;
    }
    public void setPricePerBook(int pricePerBook){
        this.pricePerBook=pricePerBook;
    }
    public int getPricePerBook(){
        return pricePerBook;
    }
    public void setAmountToPay(){
        this.amountToPay=pricePerBook*(int)booksViewed;
    }
    /*
    public int getAmountToPay(){
        return amountToPay;
    }
    */

    //Inherited methods
    @Override
    public int calculateFinalAmount(){
        return amountToPay;
    }
    public String toString(){
        return 
        "Nombre: "+name+"\nApellido: "+lastName+"\nCodigo id: "+
        Integer.toString(idCode)+"\nLibros vistos"+Integer.toString(booksViewed)+
        "\nPrecio a pagar: "+Integer.toString(this.calculateFinalAmount());
    }

    
}
