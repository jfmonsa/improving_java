package library;

import java.util.Scanner;

public class NormalUser extends User {
    public NormalUser(String name){
        super(name);
        this.operations = new IOOperation[]{
            new Exit(),
            new ViewBooks(),
            new Search(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
        };
    }

    public NormalUser(String name, String email, String phoneNumber){
        super(name,email,phoneNumber);
        this.operations = new IOOperation[]{
            new Exit(),
            new ViewBooks(),
            new Search(),
            new PlaceOrder(),
            new BorrowBook(),
            new CalculateFine(),
            new ReturnBook(),
        };
    }

    @Override
    public void menu(Database dataBase,User user){
        System.out.println(
            "0.Exit\n"+
            "1.View Books\n"+
            "2.Search\n"+
            "3.Place Order\n"+
            "4.Borrow Book\n"+
            "5.Calculate Fine\n"+
            "6.Return Book\n");
        Scanner s = new Scanner(System.in);
        int opt = s.nextInt();
        this.operations[opt-1].oper(dataBase,user);
        s.close();
    }
}
