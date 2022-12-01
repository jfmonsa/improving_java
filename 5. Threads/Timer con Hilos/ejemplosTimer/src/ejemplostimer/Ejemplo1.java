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
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class Ejemplo1 extends JFrame{
    
    Container contenedor;
    JTextArea area;
    Timer temporizador;
    Manejador manejador;
    
    public Ejemplo1(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());
        area = new JTextArea("", 15, 15);
        contenedor.add(area);
        manejador = new Manejador();
        temporizador = new Timer(5000, manejador);
        temporizador.start();
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String args []){
        Ejemplo1 gui = new Ejemplo1();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class Manejador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            area.setText(area.getText()+"Se genero un evento nuevo \n");
        }
    
    }
    
}
