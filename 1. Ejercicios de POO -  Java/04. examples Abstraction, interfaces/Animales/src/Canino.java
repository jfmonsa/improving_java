public abstract class Canino extends Mamifero{

    private String formaColmillos;

    public Canino(boolean sexo, int edad, boolean sangreCaliente, String formaDeAlimentacion, String formaColmillos) {
        super(sexo, edad, sangreCaliente, formaDeAlimentacion);
        this.formaColmillos = formaColmillos;
    }

    public String getFormaColmillos() {
        return formaColmillos;
    }

    public void setFormaColmillos(String formaColmillos) {
        this.formaColmillos = formaColmillos;
    }

    public abstract void ladrar();
    
}
