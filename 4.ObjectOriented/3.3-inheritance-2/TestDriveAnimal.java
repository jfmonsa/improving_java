/**
 * Concepts:
 * + Enums
 * + Inheritance
 * + Abstraction
 * + Polymorphism: Method overriding
 */

// Enums
public enum Sexo {
    Macho, Hembra
}

public enum Sangre {
    Fria, Caliente
}


public class Animal {
    
    private int edad;
    private Sangre tipo;
    private Sexo sexo;

    public Animal(int edad, Sangre tipo, Sexo sexo) {
        this.edad = edad;
        this.tipo = tipo;
        this.sexo = sexo;
    }

    public Animal(boolean sexo2, int edad2) {
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public Sangre getTipo() {
        return tipo;
    }
    public void setTipo(Sangre tipo) {
        this.tipo = tipo;
    }
    public Sexo getSexo() {
        return sexo;
    }
    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void dormir(){
        System.out.println("cierran los ojos");
    }
    

}

public class Gato extends Animal{
    
    private int numeroDeVidas;
    private String volumenDelGrito;

    public Gato(int numeroDeVidas, String volumenDelGrito, int edad, Sangre tipo, Sexo sexo){
        super(edad, tipo, sexo);
        this.numeroDeVidas = numeroDeVidas;
        this.volumenDelGrito = volumenDelGrito;
    }

    @Override
    public void dormir(){
        super.dormir();
        System.out.println("acuestan boca arriba");
    }

}


//Main Class (Driver codes)
public class TestDriveAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal(5, Sangre.Fria,Sexo.Hembra);
        Gato gato = new Gato(1,"muy duro", 25, Sangre.Caliente, Sexo.Macho);
        Gato gato2 = new Gato(1,"muy duro", 25, Sangre.Caliente, Sexo.Macho);
        System.out.println(animal.getEdad());
        System.out.println(gato.getEdad());        
        gato.dormir();
        gato2.dormir();
    }
    
}
