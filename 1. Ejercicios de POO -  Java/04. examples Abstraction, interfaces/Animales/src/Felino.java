public abstract class Felino extends Mamifero{

    private double cantidadSueno;

    public Felino(boolean sexo, int edad, boolean sangreCaliente, String formaDeAlimentacion, double cantidadSueno) {
        super(sexo, edad, sangreCaliente, formaDeAlimentacion);
        this.cantidadSueno = cantidadSueno;
    }

    public double getCantidadSueno() {
        return cantidadSueno;
    }

    public void setCantidadSueno(double cantidadSueno) {
        this.cantidadSueno = cantidadSueno;
    }

    public abstract void arunar();    
    
}
