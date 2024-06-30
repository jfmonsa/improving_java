public class AsignarMatricula {
    String jornada; //"Mañana", "Tarde"
    Profesor[] profesor;
    String materia;

    //Const
    public AsignarMatricula(String jornada, Profesor[] profesor, String materia) {
        this.jornada = jornada;
        this.profesor = profesor;
        this.materia = materia;
    }
    //Setters & getters
    public String getJornada() {
        return jornada;
    }
    public void setJornada(String jornada) {
        this.jornada = jornada;
    }
    public Profesor[] getProfesor() {
        return profesor;
    }
    public void setProfesor(Profesor[] profesor) {
        this.profesor = profesor;
    }
    public String getMateria() {
        return materia;
    }
    public void setMateria(String materia) {
        this.materia = materia;
    }

    
}
