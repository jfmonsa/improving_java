package ejemplostimer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Animacion extends JPanel{
    
    Timer tempo;
    Manejador manejador;
    ImageIcon iconos [];
    int imagenActual = 0;
    int imagenesTotales = 4;
    
    public Animacion(){
        ImageIcon imagen0 = new ImageIcon("imagenes/imagen0.gif");        
        ImageIcon imagen1 = new ImageIcon("imagenes/imagen1.gif");
        ImageIcon imagen2 = new ImageIcon("imagenes/imagen2.gif");
        ImageIcon imagen3 = new ImageIcon("imagenes/imagen3.gif");
        iconos = new ImageIcon[4];
        iconos[0]=imagen0;
        iconos[1]=imagen1;
        iconos[2]=imagen2;
        iconos[3]=imagen3;
        
        manejador = new Manejador();
        tempo = new Timer(500, manejador);
        tempo.start();
    }
    
    public void paint(Graphics g){
        
        iconos[imagenActual].paintIcon( this, g, 20, 0 );            
        imagenActual = ( imagenActual + 1 ) % imagenesTotales;         
    }
    
    private class Manejador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            repaint();
        }
    
    }
    
}
