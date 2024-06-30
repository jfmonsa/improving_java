import java.util.Scanner;
/**
 * Concepts:
 * + Test drive class
 * + I/O with Scanner
 * + println != print
 */

// Driver Class: HelloWorld
public class HelloWorld {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese cualquier palabra: ");
        String inputString = scan.nextLine();
        // Close the scanner object, because we've finished reading
        // all the input from stdin
        scan.close();
        //sout
        System.out.println("Hello, World!");
        System.out.println(inputString);
    }
}
