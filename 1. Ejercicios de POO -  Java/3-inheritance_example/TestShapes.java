public class Cilindro extends Circulo{
    private double altura;

    public Cilindro(double radio, double altura) {
        super(radio);
        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea(){
        return super.getArea() * altura;
    }
    
}

public class Circulo {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double getArea(){
        return Math.PI * getRadio() * getRadio();
    }
    
}

class TestShapes {
    public static void main(String[] args) {
        //test drive code
    }
}