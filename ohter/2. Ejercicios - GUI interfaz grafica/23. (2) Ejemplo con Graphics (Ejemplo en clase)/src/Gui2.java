import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;

public class Gui2 extends JFrame implements MouseListener, KeyListener {

    Container contenedor;
    // Creando los puntos
    int x1, y1, x2, y2;
    boolean primerClick = true;
    boolean pintarLinea = true;

    public Gui2() {
        contenedor = getContentPane();
        addMouseListener(this); // this se refiere a la clase actual, al JFrame sobre el cual estamos
                                // extendiendo
        addKeyListener(this); // Añadimos eventos de teclado

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Obtener las coordenadas del mouse
        if (primerClick) { // Si es el primer click entra
            x1 = e.getX();
            y1 = e.getY();

            primerClick = false; // Ya no es primer click el siguiente
        } else { // Para el segundo click
            x2 = e.getX();
            y2 = e.getY();
            primerClick = true;
            rePaint(getGraphics());
        }
        /*
         * int x = e.getX(); //e es el evento del mouse;
         * int y = e.getY();
         * System.out.println("("+x+","+y+")");
         */
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // contenedor.setBackground(Color.red);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // contenedor.setBackground(Color.cyan);

    }

    // Para mejoras en los graficos utilizariamos la clase Graphics2D que mejora
    // y da más posibilidades de customización
    public void paint(Graphics g) { // el método debe escribirse tal cual

        // Este método solos sirve para crear una interfaz por primera vez atees de que
        // el usuario interactue con ella
        // en ese caso utilizamos el método Repaint
        /*
         * //Este método sirve para pintar sobre el canvas
         * g.setColor(Color.red);
         * g.drawLine(0, 0, 500, 500);
         * 
         * g.setColor(Color.blue); //Todo lo que se pinte de aquí hasta que se declare
         * otro setColor va a ser blue
         * g.drawLine(0, 500, 500, 0);
         * 
         * //Creando un rectangulo
         * g.drawRect(100, 100, 50, 50);
         * //Creando rectangulo 2
         * g.fillRect(225,225,50,50);
         * 
         * g.setColor(Color.green);
         * g.drawOval(300,300,50,50);
         * 
         * g.setColor(Color.magenta);
         * g.fillOval(325,325,50,50);
         * 
         * g.drawString("Hola mundo",150,150);
         */

    }

    public void rePaint(Graphics g) {

        if (x1 != 0 && x2 != 0 && y1 != 0 && y2 != 0) {
            g.setColor(Color.red);
            if (pintarLinea) {
                g.drawLine(x1, y1, x2, y2);
            } else {
                if (y2 > y1 && x2 > x1) {
                    int ancho = x2 - x1;
                    int alto = y2 - y1;
                    g.drawRect(x1, y1, ancho, alto);
                } else if (y2 > y1 && x1 > x2) {
                    int ancho = x1 - x2;
                    int alto = y2 - y1;
                    g.drawRect(x2, y1, ancho, alto);
                } else if (y1 > y2 && x2 > x1) {
                    int ancho = x2 - x1;
                    int alto = y1 - y2;
                    g.drawRect(x1, y2, ancho, alto);
                } else if (y1 > y2 && x1 > x2) {
                    int ancho = x1 - x2;
                    int alto = y1 - y2;
                    g.drawRect(x2, y2, ancho, alto);
                }

            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Cuando se mantiene sostenida una tecla
        System.out.println(e.getKeyCode());
        if (e.getKeyChar() == 'l') {
            pintarLinea = true;
        } else if (e.getKeyChar() == 'r') {
            pintarLinea = false;
        } else {
            JOptionPane.showMessageDialog(contenedor, "No es valido");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) throws Exception {
        Gui2 ventanita = new Gui2();
    }
}
