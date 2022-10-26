public class App2 {

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
