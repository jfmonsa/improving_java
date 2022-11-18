import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejemplo1 {

    public static void main(String[] args) {
        
        int edad = 0;
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Cuantos años tiene usted?");            
            try{
                edad = scanner.nextInt();
                System.out.println("Cuantos años tiene usted?");            
                break;
            }catch(InputMismatchException e){
                System.out.println("Ingresa numeros cabezon!");
            }        
        }
        
        edad = edad + 5;
        System.out.println("En 5 años tendras: " + edad);

    }
    
}
