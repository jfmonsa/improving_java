/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ejemploProductorConsumidor {
    
    LinkedList <Object> lista = new LinkedList<>();
    
    public void producir(){        
        int cantidadActual = 0;
        
        synchronized(lista){            
            Object empanada = new Object();
            lista.addFirst(empanada);
            lista.notifyAll();    
            cantidadActual = lista.size();
        }
        System.out.println("El numero de empanadas que quedaron es " + cantidadActual);
    }
    
    public void consumir(){
        Object empanada = null;
        int cantidadActual = 0;
        
        synchronized(lista){
            while(lista.size()==0){
                try {
                    lista.wait();
                } catch (InterruptedException ex) {
                    return;
                }
            }
            empanada = lista.removeLast();
            cantidadActual = lista.size();
        }
        System.out.println("despues del consumo, quedaron " + cantidadActual);
    }
    
    public static void main(String args []){
        ejemploProductorConsumidor controlador = new ejemploProductorConsumidor();
        System.out.println("Presione 'p' para producir, 'c' para consumir o 'e' para salir");
        try {
            int entrada;
            while((entrada = System.in.read()) != -1){                
                char simbolo = (char) entrada;
                switch(simbolo){
                    case 'p':                        
                        controlador.producir();
                        break;
                    case 'c':
                        controlador.consumir();
                        break;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(ejemploProductorConsumidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
