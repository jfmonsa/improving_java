import java.util.Scanner;

import library.*;

public class App {
    static Scanner s;
    static Database dataBase = new Database();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Library Management System\n");
        int option;

        do{
            System.out.println(
            "0.Exit\n1. Login\n2. New User");

            s = new Scanner(System.in);
            option = s.nextInt();

            switch (option) {
                case 1:
                    login();
                    break;
                case 2:
                    newUser();
                    break;
                default:
                    System.out.println("Error, invalid option");
            }
        }while (option!=0);
    }

    private static void login(){
        System.out.println("Enter phone number:");
        String phoneNumber = s.next();
        System.out.println("Enter email:");
        String email = s.next();

        User usr = dataBase.login(phoneNumber, email);
        if(usr != null){
            System.out.println("Welcome user: "+usr.getName());
            usr.menu(dataBase,usr);
        }else{
            System.out.println("Invalid user");
        }
    }

    private static void newUser(){
        System.out.println("Enter name:");
        String name = s.next();
        System.out.println("Enter phone number:");
        String phoneNumber = s.next();
        System.out.println("Enter email:");
        String email = s.next();
        System.out.println("1. Admin\n2. Normal User");
        int option2 = s.nextInt();

        User user;
        if (option2==1){
            user = new Admin(name,email,phoneNumber);
        }else{
            user = new NormalUser(name,email,phoneNumber);
        }
        dataBase.addUser(user);
        user.menu(dataBase,user);
        System.out.println("User created succesfully!");
    }
}


//TODO: follow this tutorial https://youtube.com/playlist?list=PL-cxzMmn1xXG87ak7josmprqsp3da_Ovk&si=KpEX85MxX_0EliK9

