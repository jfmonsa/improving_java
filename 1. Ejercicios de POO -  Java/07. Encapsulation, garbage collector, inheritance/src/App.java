import java.util.Random;
//import java.util.Scanner;
//import javax.swing.JOptionPane;

import enums.Razas;
//Importing the packages
import logica.animales.Gato;
import logica.animales.Perro;
/*
 * What's garbage collector
	In java, garbage means unreferenced objects.

	Garbage Collection is process of reclaiming the runtime unused memory automatically.
	In other words, it is a way to destroy the unused objects.

How can an object be unreferenced?
* nulling the reference. Ex:
	Employee e=new Employee();  
	e=null;
* By assigning a reference to another:
	Employee e1=new Employee();  
	Employee e2=new Employee();  
	e1=e2;//now the first object referred by e1 is available for garbage collection  

* By anonymous object:
	new Employee();

finalize() method
	The finalize() method is invoked each time before the object is garbage collected.
	This method can be used to perform cleanup processing. This method is defined in Object class as:

Example:

public class TestGarbage1{ 
@Override 
 public void finalize(){System.out.println("object is garbage collected");}  
 public static void main(String args[]){  
  TestGarbage1 s1=new TestGarbage1();  
  TestGarbage1 s2=new TestGarbage1();  
  s1=null;  
  s2=null;  
  System.gc();  // The garbage collector acts
 }  
} 
 */

public class App {
    public static void main(String[] args) throws Exception {
        /* Some basic sintax examples;
         * System.out.println("Hello, World!");
         * int salario = 10000000;
         * //JOptionPane.showMessageDialog(null, "Hello world!");
         * int lista [] = {1,2,3}; // declaring an array
         */
        
        //
        Gato baguira;
        baguira = new Gato();
        Gato gatico = new Gato("Petunia", (byte) 5);
        System.out.println(baguira.getNumeroDeVidas());
        System.out.println(gatico.getNumeroDeVidas());
        gatico = null;
        System.gc();
        
        //Gato lista2 [] = {baguira, gatico};
        /*System.out.println(lista2[1].nombre);
        for(Gato i: lista2){
            System.out.println(i.nombre);
        }*/
        
        Gato [] lista3 = new Gato[2];
        lista3[0] = new Gato("axel", (byte)3);
        String trucos [] = {"ser infiel"};
        Perro perro = new Perro(Razas.Tulueños,trucos);
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Digame la raza del perro");
        String raza = scanner.next();

        

        if (Razas.valueOf(raza) == Razas.GranChan){
            Perro perroNuevo = new Perro(Razas.GranChan,trucos);
        }
        System.out.println(Razas.valueOf(raza));
        System.out.println(Razas.values());
        //Perro perroNuevo = new Perro(raza,trucos);
        */
        //gatico.setNumeroDeVidas((byte)87);;
        /*System.out.println(gatico.getNumeroDeVidas());
        System.out.println(Gato.numeroDeGatos);
        Perro perro1 = new Perro(Razas.Labrador,trucos);
        Perro perro2 = new Perro(Razas.GranChan,trucos);
        perro1.alimento();
        perro2.alimento();*/
        Perro.saludar();
        Random random = new Random();
        System.out.println(random.nextGaussian());

        
    }
}
