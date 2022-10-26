import java.util.concurrent.ThreadLocalRandom;

public class Empleado {
    private String nombre;
    private String cargo;
    private Rango rango;

//Constructor
    public Empleado(){}
    public Empleado(String nombre, String cargo, Rango rango) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.rango = rango;
    }
    public Empleado(String nombre, String cargo){
        this.nombre = nombre;
        this.cargo = cargo;
    }

//Setters y getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public Rango getRango() {
        return rango;
    }
    public void setRango(Rango rango) {
        this.rango = rango;
    }

    //Otras funciones
    public void asignacionAleatoria(Empleado emp){
        // here values() method returns all the instances of Enum
        Rango[] listaRangos = Rango.values();
        int randomElementIndex = ThreadLocalRandom.current().nextInt(listaRangos.length) % listaRangos.length;
        emp.setRango(listaRangos[randomElementIndex]);
        
    }

    public static void imprimir(Empleado emp){
        System.out.println("El empleado "+emp.getNombre()+" Se desempeña como: "+emp.getCargo()+" Y su rango es: "+emp.getRango());
    }
    

}
