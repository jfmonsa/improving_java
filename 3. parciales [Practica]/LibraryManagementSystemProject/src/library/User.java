package library;

public abstract class User {
    protected String name, email, phonNumber;
    protected IOOperation[] operations;

    //Constructors
    public User(String name){
        this.name = name;
    }
    public User(String name, String email, String phonNumber) {
        this.name = name;
        this.email = email;
        this.phonNumber = phonNumber;
    }


    //Getters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPhonNumber() {
        return phonNumber;
    }

    abstract public void menu(Database dataBase,User user);

    
}
