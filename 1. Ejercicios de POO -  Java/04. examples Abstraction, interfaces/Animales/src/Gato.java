public class Gato extends Felino implements MejorAmigoDeHombre, Dioses{

    private String nombre;
    private boolean caeDePie;
    public Gato(boolean sexo, int edad, boolean sangreCaliente, String formaDeAlimentacion, double cantidadSueno,
            String nombre, boolean caeDePie) {
        super(sexo, edad, sangreCaliente, formaDeAlimentacion, cantidadSueno);
        this.nombre = nombre;
        this.caeDePie = caeDePie;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isCaeDePie() {
        return caeDePie;
    }
    public void setCaeDePie(boolean caeDePie) {
        this.caeDePie = caeDePie;
    }
    @Override
    public void arunar() {
        System.out.println("despacito");
    }
    @Override
    public void chupanPucheca() {
        System.out.println("que rico");        
    }
    @Override
    public void dormir() {
        System.out.println(":3");
    }
    @Override
    public void manipular() {
        System.out.println("ojos de cordero");
        
    }
    @Override
    public void pasea() {
        System.out.println("no me dejo uwu");
    }
    @Override
    public void dominar() {
        System.out.println("todo es mio");
    }

    

}
