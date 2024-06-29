package library;

import java.util.Scanner;

public class Admin extends User{
    
    public Admin(String name){
        super(name);

        this.operations = new IOOperation[]{
            new Exit(),
            new ViewBooks(),
            new AddBook(),
            new DeleteBook(),
            new Search(),
            new DeleteAllData(),
            new ViewOrders(),
        };
    }

    public Admin(String name, String email, String phoneNumber){
        super(name, email, phoneNumber);

        this.operations = new IOOperation[]{
            new Exit(),
            new ViewBooks(),
            new AddBook(),
            new DeleteBook(),
            new Search(),
            new DeleteAllData(),
            new ViewOrders(),
        };
    }


    @Override
    public void menu(Database database, User user){
        System.out.println(
            "0.Exit\n"+
            "1.Viewed Books\n"+
            "2.Add Book\n"+
            "3.Delete Book\n"+
            "4.Search\n"+
            "5.Delete all data\n"+
            "6.View Orders\n");
        Scanner s = new Scanner(System.in);
        int opt = s.nextInt();
        this.operations[opt-1].oper(database,user);
        s.close();

    }
}
