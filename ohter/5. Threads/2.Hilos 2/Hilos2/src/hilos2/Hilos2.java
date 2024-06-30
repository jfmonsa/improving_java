/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos2;

/**
 *
 * @author User
 */
public class Hilos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ejemploHilos hilo1 = new ejemploHilos("Hilo Joshua");
        ejemploHilos hilo2 = new ejemploHilos("Hilo Univalle");
        ejemploHilos hilo3 = new ejemploHilos("Hilo Tulua");
        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
    
}
