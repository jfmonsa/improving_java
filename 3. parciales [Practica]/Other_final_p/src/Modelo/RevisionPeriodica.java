package Modelo;
public class RevisionPeriodica extends Revision{
    
    private Boolean antesVencimiento;

    //Cosntructor
    public RevisionPeriodica(int numero, String fecha, double horasDuracion, int tarifaBase, Boolean antesVencimiento) {
        super(numero, fecha, horasDuracion, tarifaBase);
        this.antesVencimiento = antesVencimiento;
    }
    
    //Getters & setters
    public Boolean getAntesVencimiento() {
        return antesVencimiento;
    }

    public void setAntesVencimiento(Boolean antesVencimiento) {
        this.antesVencimiento = antesVencimiento;
    }

    //ToString
    @Override
    public String toString() {
        return super.toString()+"\nRevisionEspecial [antesVencimiento=" + antesVencimiento + "]";
        //TODO: revisar que la implementación de los toStrings sea congruente entre clases
    }

    //public double calcularCosto()
}
