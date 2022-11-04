import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejemplo2 {

    public static void main(String[] args) {
        
        int numero = 0;
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese un numero?");            
            try{
                String linea = scanner.nextLine();
                numero = Integer.parseInt(linea);
                System.out.println("Ahora digame en sobre cuanto lo quiere dividir");            
                linea = scanner.nextLine();
                int dividendo = Integer.parseInt(linea);
                System.out.println("La division es" + (numero/dividendo));
                
                break;
            }catch(NumberFormatException e){
                System.out.println("Ingresa numeros cabezon!");
            }catch(ArithmeticException e){
                System.out.println("No ingreses 0 como dividendoz!");
            }catch(Exception e){
                System.out.println("Algo salio mal xD");
                e.printStackTrace();
            }
        }                

    }
    
    
}
