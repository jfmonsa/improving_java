public class Perro extends Canino implements MejorAmigoDeHombre{

    private String pedigree;
    private String nombre;
    public Perro(boolean sexo, int edad, boolean sangreCaliente, String formaDeAlimentacion, String formaColmillos,
            String pedigree, String nombre) {
        super(sexo, edad, sangreCaliente, formaDeAlimentacion, formaColmillos);
        this.pedigree = pedigree;
        this.nombre = nombre;
        Presidente.petro.queHacen();
    }
    public String getPedigree() {
        return pedigree;
    }
    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void chupanPucheca() {
        System.out.println(":)");
    }
    @Override
    public void dormir() {
        System.out.println(":O");
    }

    @Override
    public void ladrar(){
        System.out.println("woff");
    }
    @Override
    public void manipular() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void pasea() {
        // TODO Auto-generated method stub
        
    };
    
}
