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
