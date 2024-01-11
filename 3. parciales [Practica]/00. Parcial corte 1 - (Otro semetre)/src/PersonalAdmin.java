import java.util.Arrays;

public class PersonalAdmin extends Empleado{
    Facultades facultad;
    Tecnologias[] tecnologias;
    //Constructor
    public PersonalAdmin(String nombre, String cedula, Facultades facultad, Tecnologias[] tecnologias) {
        super(nombre, cedula);
        this.facultad = facultad;
        this.tecnologias = tecnologias;
    }
    //Setters & getters
    public Facultades getFacultad() {
        return facultad;
    }
    public void setFacultad(Facultades facultad) {
        this.facultad = facultad;
    }
    public Tecnologias[] getTecnologias() {
        return tecnologias;
    }
    public void setTecnologias(Tecnologias[] tecnologias) {
        this.tecnologias = tecnologias;
    }
    @Override
    public String toString() {
        return super.toString()+"PersonalAdmin [facultad=" + facultad + ", tecnologias=" + Arrays.toString(tecnologias) + "]";
    }
    
}
