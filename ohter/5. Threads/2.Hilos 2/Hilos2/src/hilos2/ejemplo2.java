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
public class ejemplo2 {
    
    public static void main(String args []){
        Intermediario intermediario = new Intermediario();
        Productor p1 = new Productor(intermediario, 1);
        Consumidor c1 = new Consumidor(intermediario, 1);
        p1.start();
        c1.start();
    }
    
}

class Intermediario{
    int contenido = 1;
    boolean disponible=false;
    
    public synchronized int obtener(){
        while(disponible==false){
            try {
                wait();
            } catch (InterruptedException ex) {                
            }
        }
        disponible=false;
        notifyAll();
        return contenido;
    }
    public synchronized void poner(int nuevoContenido){
        while(disponible == true){
            try {
                wait();
            } catch (InterruptedException ex) {                
            }
            
        }
        disponible=true;
        contenido=nuevoContenido;
        notifyAll();
    }
}

class Productor extends Thread{
    Intermediario inter;
    int numero;
    
    public Productor(Intermediario inter, int numero){
        this.inter= inter;
        this.numero=numero;
    }
    
    public void run(){
        for(int i =0;i<10;i++){
            inter.poner(i);
            System.out.println("Productor " + numero + " puso " + i);
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
    }
    
}

class Consumidor extends Thread{
    Intermediario inter;
    int numero;
    
    public Consumidor(Intermediario inter, int numero){
        this.inter= inter;
        this.numero=numero;
    }
    
    public void run(){
        int valor = 0;
        for(int i =0; i < 10; i++){
            valor = inter.obtener();
            System.out.println("Consumidor "+ numero+" obtuvo " + valor);
        }
    }
    
}