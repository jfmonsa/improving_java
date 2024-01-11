import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejemplo3 {

    public static void main(String[] args) {
        
        int numero = 0;
        
        try {
            calcular();
        } 
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        while(true){            
            try{                
                
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
    
    public static void calcular() throws NumberFormatException, ArithmeticException, FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero?");            
        String linea = scanner.nextLine();
        int numero = Integer.parseInt(linea);
        System.out.println("Ahora digame en sobre cuanto lo quiere dividir");            
        linea = scanner.nextLine();
        int dividendo = Integer.parseInt(linea);
        System.out.println("La division es" + (numero/dividendo));
        RandomAccessFile archivo = new RandomAccessFile("archivo.txt", "r");
    }
    
}
