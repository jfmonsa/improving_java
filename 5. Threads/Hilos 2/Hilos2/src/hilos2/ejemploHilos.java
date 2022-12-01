/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ejemploHilos extends Thread{
    
    
    
    public ejemploHilos(String nombre){
        super(nombre);
    }
    
    @Override
    public void run(){
        for(int i = 0 ; i<10;i++ ){
            try {
                int tiempoDeSueño = (int)(Math.random()*10000);
                sleep(tiempoDeSueño);
            } catch (InterruptedException ex) {
                Logger.getLogger(ejemploHilos.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Mensaje "+i+" del hilo " + getName());
        }                
    }
    
}
