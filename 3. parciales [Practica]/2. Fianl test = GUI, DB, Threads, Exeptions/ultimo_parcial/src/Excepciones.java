import javax.swing.JOptionPane;

public class Excepciones extends Exception {
    public Excepciones(String message) {
        JOptionPane.showMessageDialog(null, message, "Excepcion:", JOptionPane.ERROR_MESSAGE);
    }

    public Excepciones(String message, int constant) {
        JOptionPane.showMessageDialog(null, message, "Excepcion:", constant);
    }
}