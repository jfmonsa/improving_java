public abstract class Client {
    private int id;
    private String lastName;
    private String name;

    public Client(int id, String lastName, String name) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
    }

    public abstract int calculateMembershipFee();
    public abstract String toString();

    //getters
    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }
    public String getName() {
        return name;
    }
}