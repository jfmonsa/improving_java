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
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class ejemploReloj extends JFrame{
    
    Container contenedor;
    JLabel etiqueta1;
    Timer tempo;
    Manejador manejador;
    int contadorSegundos = 0;
    int contadorMinutos = 0;
    int contadorHoras = 0;
    
    public ejemploReloj(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());
        etiqueta1 = new JLabel("0");
        contenedor.add(etiqueta1);
        manejador = new Manejador();
        tempo = new Timer(1, manejador);
        tempo.start();
        setSize(200,200);
        setVisible(true);    
    }
    
    public static void main(String args []){
        ejemploReloj gui = new ejemploReloj();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private class Manejador implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            contadorSegundos++;
            if(contadorSegundos==60){  
                contadorMinutos++;
                contadorSegundos=0;                
                if(contadorMinutos==60){
                    contadorHoras++;
                    contadorMinutos=0;
                }
            }
            
            etiqueta1.setText(contadorHoras+":"+contadorMinutos+":"+contadorSegundos);            
        }
    
    }
    
}
