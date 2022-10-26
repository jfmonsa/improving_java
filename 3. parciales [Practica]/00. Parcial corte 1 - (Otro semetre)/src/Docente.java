public class Docente extends Empleado {
    gradoAcademico grado;
    int numero_papers;
    Materias materia;

    //Constructor
    public Docente(String nombre, String cedula, gradoAcademico grado, int numero_papers, Materias materia) {
        super(nombre, cedula);
        this.grado = grado;
        this.numero_papers = numero_papers;
        this.materia=materia;
    }

    //Setters & getters
    public gradoAcademico getGrado() {
        return grado;
    }
    public void setGrado(gradoAcademico grado) {
        this.grado = grado;
    }
    public int getNumero_papers() {
        return numero_papers;
    }
    public void setNumero_papers(int numero_papers) {
        this.numero_papers = numero_papers;
    }
    public Materias getMateria() {
        return materia;
    }
    public void setMateria(Materias materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return super.toString()+" || Docente [grado=" + grado + ", numero_papers=" + numero_papers + ", materia=" + materia + "]";
    } 
}
