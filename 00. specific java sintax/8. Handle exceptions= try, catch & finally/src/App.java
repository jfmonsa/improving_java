import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		// exception = 	an event that occurs during the execution of a program that,
		//				disrupts the normal flow of instructions
        
		Scanner scanner = new Scanner(System.in);
		while (true){
			try {
				System.out.println("Enter a whole number to divide: ");
				int x = scanner.nextInt();
				System.out.println("Enter a whole number to divide by: ");
				int y = scanner.nextInt();
				int z = x/y;
				System.out.println("result: " + z);
			}
			catch(ArithmeticException e) {
				System.out.println("You can't divide by zero! IDIOT!");
				/*
				 * El objeto e de la clase ArithmeticException tiene tambien varios metodos
				 * que nos ayudan en el proceso de debugging
				 * 
				 *  Ej: e.printStackTrace();
				 */
			}
			catch(InputMismatchException e) {
				System.out.println("PLEASE ENTER A NUMBER OMFG!!!");
			}
			catch(Exception e) {
				//Default exception
				System.out.println("Something went wrong");
			}
			finally {
				//This allways is excecuted
				scanner.close();
			}
		}
			
	}
}