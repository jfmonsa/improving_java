public class profHoraCatedra extends Profesor{
   String titulo;
   int horas_x_semana;

   //Constr
   public profHoraCatedra(String nombre, String cedula, String titulo, int horas_x_semana) {
    super(nombre, cedula);
    this.titulo = titulo;
    this.horas_x_semana = horas_x_semana;
}



    //Setters y getters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public int getHoras_x_semana() {
        return horas_x_semana;
    }
    public void setHoras_x_semana(int horas_x_semana) {
        this.horas_x_semana = horas_x_semana;
    }
   
   
}
