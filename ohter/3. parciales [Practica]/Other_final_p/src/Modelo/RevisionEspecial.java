package Modelo;
public class RevisionEspecial extends Revision{
    private Boolean urgencia;

    //Cosntructor
    public RevisionEspecial(int numero, String fecha, double horasDuracion, int tarifaBase, Boolean urgencia) {
        super(numero, fecha, horasDuracion, tarifaBase);
        this.urgencia = urgencia;
    }
    
    //Getters & setters
    public Boolean getUrgencia() {
        return urgencia;
    }
    public void setUrgencia(Boolean urgencia) {
        this.urgencia = urgencia;
    }

    //ToString
    @Override
    public String toString() {
        return "RevisionEspecial [urgencia=" + urgencia + "]";
    }
    
    //public double calcularCosto()
  
}