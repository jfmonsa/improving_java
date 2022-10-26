public abstract class Client {
    String name, lastName;
    int idCode;
    
    public Client(String name, String lastName, int  idCode){
        this.name = name;
        this.lastName=lastName;
        this.idCode=idCode;
    } 
    public abstract int calculateFinalAmount();
    public abstract String toString();
}
