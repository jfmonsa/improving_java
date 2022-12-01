/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplostimer;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author User
 */
public class ejemploDado extends JPanel implements ActionListener{
    Container contenedor;
    JButton boton1;
    ImageIcon dados [];
    Timer timer;    
    int contador = 0;
    int aceleracion = 500;
    int controlInicia = 0;
    int altoImagen = 0;
    int anchoImagen = 0;
    int posicionAleatoria;
    
    public ejemploDado(){
        
        dados = new ImageIcon[7];
        for(int i = 1; i < 7; i++){
            dados[i] = new ImageIcon("imagenes/dado"+i+".gif");
        }
        
        altoImagen = dados[1].getIconHeight();
        anchoImagen = dados[1].getIconWidth();
                
        setSize(500,500);
        setVisible(true);
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(controlInicia==0){
            ImageIcon imagenInicial = new ImageIcon("imagenes/dado0.gif");
            imagenInicial.paintIcon(this, g, 0, 0);            
        }
        if(controlInicia==1){
            posicionAleatoria = (int)((Math.random()*6)+1);        
            dados[posicionAleatoria].paintIcon(this, g, 0, 0);
        }
        
        
    }
        
    public void controlAnimacion(){
        System.out.println("entra a control");
        if(timer==null){
            System.out.println("entra a null");
            timer = new Timer(aceleracion, this);
            timer.start();
            controlInicia=1;
        }else if(!timer.isRunning()){
            System.out.println("Ya no esta corriendo");
        }
        
        /*contador = contador + aceleracion;
        if (contador==3000){
            aceleracion=200;
            timer.setDelay(aceleracion);
        }else if(contador==6000){
            timer.stop();
        }*/
    }
    
    public void pararAnimacion(){
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("entra a action");
        repaint();
    }
       
    
    public Dimension getMinimumSize(){
        return getPreferedSize();
    }
    
    public Dimension getPreferedSize(){
        return new Dimension(anchoImagen, altoImagen);
    }
    
    public int getResultado(){
        return posicionAleatoria;
    }
    
}
