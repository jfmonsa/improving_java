package logica.animales;
/* ¿What's package keyword?
 * A package in Java is used to group related classes. 
 * Think of it as a folder in a file directory. 
 * We use packages to avoid name conflicts, and to write a better 
 * maintainable code. Packages are divided into two categories:
 */


public class Gato {
 
    private String nombre;
    private byte numeroDeVidas; 
    static int numeroDeGatos;

    //Constructor's overloading
    public Gato(String nuevoNombre, byte nuevoNumeroDeVidas){
        nombre = nuevoNombre;
        numeroDeVidas = nuevoNumeroDeVidas;
        numeroDeGatos++;
    }

    public Gato(){   
    }

    //Setters & getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public byte getNumeroDeVidas() {
        return numeroDeVidas;
    }
    public void setNumeroDeVidas(byte numeroDeVidas) {
        this.numeroDeVidas = numeroDeVidas;
    }

    //Overrinding the finalize() method
    @Override
    public void finalize(){
        numeroDeGatos--;
    }   
    
}

