public class Gato extends Animal{
    
    private int numeroDeVidas;
    private String volumenDelGrito;

    public Gato(int numeroDeVidas, String volumenDelGrito, int edad, Sangre tipo, Sexo sexo){
        super(edad, tipo, sexo);
        this.numeroDeVidas = numeroDeVidas;
        this.volumenDelGrito = volumenDelGrito;
    }

    @Override
    public void dormir(){
        super.dormir();
        System.out.println("acuestan boca arriba");
    }

}
