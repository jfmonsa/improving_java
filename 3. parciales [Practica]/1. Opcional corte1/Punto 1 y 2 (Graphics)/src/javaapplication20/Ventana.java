/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication20;

/**
 *
 * @author Juan Felipe Monsalve - 2160145-3743
 */
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Graphics;

public class Ventana  extends JFrame implements MouseListener, KeyListener{
    Container contenedor;
    int x1, y1;  //Punto del centro de la x
    int ancho_ventana=500, largo_ventana=500;
    //Punto mitad de la pantalla
    final int xm=(int) Math.ceil((double) ancho_ventana/2);
    final int ym=(int) Math.ceil((double) largo_ventana/2);
    static boolean pintar_x, pintar_letra_a, pintar_letra_u;

    public Ventana(){
        contenedor = getContentPane();
        addMouseListener(this); 
        addKeyListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(ancho_ventana,largo_ventana);
        setResizable(false);
        //---------------------
        setVisible(true);
    }
    public void rePaint(Graphics g){
        //Punto 1
        if(x1!=0 && y1!=0 && pintar_x==true){
            g.setColor(Color.red);
            int opc =  1 + (int)(Math.random() * 4);
            System.out.println(opc);
            switch (opc) {
                case 1:
                    g.drawLine(x1, y1, x1+100, y1+100);
                    g.drawLine(x1, y1, x1+100, y1-100);
                    break;
                case 2:
                    g.drawLine(x1, y1, x1-100, y1+100);
                    g.drawLine(x1, y1, x1+100, y1+100);
                    break;
                case 3:
                    g.drawLine(x1, y1, x1-100, y1-100);
                    g.drawLine(x1, y1, x1+100, y1-100);
                    break;
                case 4:
                    g.drawLine(x1, y1, x1-100, y1+100);
                    g.drawLine(x1, y1, x1-100, y1-100);
                    break;
            }
            System.out.println(opc);
            pintar_x=false;
        }
        //Punto 2
        if(pintar_letra_u || pintar_letra_a){
            //Otras declaraciones
            final int ancho_figura=200, largo_figura=200;
            //Centro de los rectangulos y los ovalos
            final int punto_centro_local_x = xm-ancho_figura/2;
            final int punto_centro_local_y = ym-largo_figura/2;
            
            if(pintar_letra_u){
                g.drawString("Presiono la tecla u",xm,+100);
                g.setColor(Color.blue);
                pintar_letra_u=false;
                g.drawRect(punto_centro_local_x, punto_centro_local_y, ancho_figura, largo_figura);
                g.drawOval(punto_centro_local_x,punto_centro_local_y,ancho_figura,largo_figura);
                //Dibujando lineas de la izquierda
                g.drawLine(xm, ym, xm+ancho_figura/2, ym+largo_figura/2);
                g.drawLine(xm, ym, xm+ancho_figura/2, ym-largo_figura/2);
                //Linea que se atraviesa por la mitad
                g.drawLine(xm, ym+largo_figura/2, xm, ym-largo_figura/2);
                /*
                g.drawLine(x1, y1, x1+100, y1+100);
                    g.drawLine(x1, y1, x1+100, y1-100);s
                */
            }

            if(pintar_letra_a){
                g.drawString("Presiono la tecla a",xm,+100);
                g.setColor(Color.magenta);
                pintar_letra_a=false;
                g.drawRect(punto_centro_local_x, punto_centro_local_y, ancho_figura, largo_figura);
                g.drawOval(punto_centro_local_x,punto_centro_local_y,ancho_figura,largo_figura);
                //Lineas vertticales que se atraviesan por la mitad
                g.drawLine(xm, ym+largo_figura/2, xm, ym-largo_figura/2);
                g.drawLine(xm-ancho_figura/4, ym+largo_figura/2, xm-ancho_figura/4, ym-largo_figura/2);
                //Linea horizontal que se atraviesa por la mitad
                g.drawLine(xm-ancho_figura/2, ym, xm, ym);
            }
        }      
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
        pintar_x=true;
        rePaint(getGraphics());
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        if(e.getKeyChar()=='u'){
            pintar_letra_u=true;
            rePaint(getGraphics());
        }
        if(e.getKeyChar()=='a'){
            pintar_letra_a=true;
            rePaint(getGraphics());
        }
    }

    //Otros métodos
    //Keyboard
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    //Mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub      
    }      
}
