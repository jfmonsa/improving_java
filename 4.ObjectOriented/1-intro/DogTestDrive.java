/**
 * Concepts:
 * 1. TestDrive class: Contains the main function psvm
 *      and its objective its to run the code
 * 2. Abstraction: using getters and its importance
 * 3. Reference variables
 * 4. Branching (if-else)
 */

class Dog {
    private int size;

    private int getSize(){
        return this.size;
    }

    public void setSize(int s){
        this.size = s;
    }

    void bark(){
        if (size > 60){
            System.out.println("Wooof! Woof!");
        }else if (size > 40){
            System.out.println("Ruff! Ruff!");
        }else{
            System.out.println("Yiip! Yip!");
        }
    }
}

public class DogTestDrive {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setSize(70);
        Dog dog2 = new Dog();
        dog2.setSize(8);
        dog1.bark();
        dog2.bark();
    }   
}