public abstract class Mamifero extends Animal{

    private boolean sangreCaliente;
    private String formaDeAlimentacion;
    public Mamifero(boolean sexo, int edad, boolean sangreCaliente, String formaDeAlimentacion) {
        super(sexo, edad);
        this.sangreCaliente = sangreCaliente;
        this.formaDeAlimentacion = formaDeAlimentacion;
    }
    public boolean isSangreCaliente() {
        return sangreCaliente;
    }
    public void setSangreCaliente(boolean sangreCaliente) {
        this.sangreCaliente = sangreCaliente;
    }
    public String getFormaDeAlimentacion() {
        return formaDeAlimentacion;
    }
    public void setFormaDeAlimentacion(String formaDeAlimentacion) {
        this.formaDeAlimentacion = formaDeAlimentacion;
    }

    public abstract void chupanPucheca();
    
}
