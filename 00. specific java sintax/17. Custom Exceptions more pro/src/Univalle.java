import java.text.NumberFormat;
import java.util.Scanner;

public class Univalle {
    
    public static void main(String[] args) {
        System.out.println("Cuantos creditos va a matricular");
        try{
            Scanner scanner = new Scanner(System.in);
            String linea = scanner.nextLine();
            int creditos = Integer.parseInt(linea);
            if(creditos < 6 || creditos > 21){
                throw new MatriculaException("No cumples con el minimo o el maximo");
            }
            System.out.println("Cuantos años tiene usted?");
            String linea2 = scanner.nextLine();
            int edad = Integer.parseInt(linea2);
            if(edad<15 || edad > 90){
                throw new MatriculaException("Eres muy pelado o muy cucho");
            }

        }catch(NumberFormatException e){
            System.out.println("Ingresa un numero");
        }catch(MatriculaException e){
            System.out.println(e.getMessage());
        }
        System.out.println(":)");
    }

}
