import javax.swing.JOptionPane;

public class Excepciones extends Exception{
    public Excepciones(String message){
        JOptionPane.showMessageDialog(null, message, "Excepcion:", JOptionPane.ERROR_MESSAGE);
        //super(mensaje);
    }
    public Excepciones(String message, int constant){
        JOptionPane.showMessageDialog(null, message, "Excepcion:", constant);
        //super(mensaje);
    }
    //throw new Excepciones("Error: Debes seleccionar al menos una pelicula");
}