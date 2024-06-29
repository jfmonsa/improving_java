/**
 * Concepts:
 * - toString(): special method that all objects inherit, 
 *      that returns a string that "textually represents" an object.
 * - can be @override: Sobrecarga
 * - can be use explicit or inplicit
 */


public class Car {
    String make = "Ford";
    String model = "Mustang";
    String color = "red";
    int year = 2021;
    
    @Override
    public String toString() {
        return "Car [make=" + make + ", model=" + model + ", color=" + color + ", year=" + year + "]";
    }
    
   }

public class TestDriveCar {

    public static void main(String[] args) {

    Car car = new Car();
    
    
    // explicit call
    System.out.println(car.toString());
    // inplicit call
    System.out.println(car);
   
       
    }
   }