/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplostimer;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Ejemplo2 extends JFrame{
    
    Container contenedor;
    JLabel etiqueta;
    Timer temporizador;
    Manejador manejador;
    int contador = 0;
    
    public Ejemplo2(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());
        etiqueta = new JLabel("Total eventos 0");
        contenedor.add(etiqueta);
        manejador = new Manejador();
        temporizador = new Timer(1000, manejador);
        temporizador.start();
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String args []){
        Ejemplo2 gui = new Ejemplo2();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class Manejador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            contador++;
            etiqueta.setText("Total eventos " + contador);
        }
    
    }
    
}
