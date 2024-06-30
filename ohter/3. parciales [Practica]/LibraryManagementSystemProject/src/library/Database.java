package library;

import java.io.File;
import java.util.ArrayList;

public class Database {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<String> usernames = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<String> bookNames = new ArrayList<>();

    private File usersFile = new File(App.class.getClassLoader().getResource("Users").getFile());

    public void addUser(User usr){
        users.add(usr);
        usernames.add(usr.getName());
    }

    public User login(String phoneNumber, String email){
        for(User usr: users){
            if(usr.getPhonNumber().matches(phoneNumber) && usr.getEmail().matches(email)){
                return usr;
            }
        }
        return null;
    }

    public void addBook(Book book){
        books.add(book);
        bookNames.add(book.getName());
    }

}
