/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplostimer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




/**
 *
 * @author User
 */
public class Impresion {
    
    Timer timer;
    ManejadorTimer manejador;
    
    public Impresion(){
        manejador = new ManejadorTimer();
        timer = new Timer(1500, manejador);
        System.out.println("Empieza");
        timer.start();
        System.out.println("Termina");
    }
    
    private class ManejadorTimer implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("Imprimir...");
        }
    
    }
    
}
