package logica.animales;

import enums.Razas;


public class Perro {
    
    Razas raza;
    String  trucos [];

    public Perro(Razas raza, String[] trucos) {
        this.raza = raza;
        this.trucos = trucos;
    }

    public void alimento(){
        if(raza == Razas.Labrador){
            System.out.println("2 libras al dia");            
        }else if(raza == Razas.GranChan){
            System.out.println("Media libra al dia");            
        }

    }
    
    public static void saludar(){
        System.out.println("*Mueve la cola");
    }
    

}
