/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplostimer;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class usoDado extends JFrame implements ActionListener{
    
    Container contenedor;
    JButton boton1, boton2;
    ejemploDado dado1, dado2;
    int resultado1, resultado2;
    
    public usoDado(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());
        
        boton1 = new JButton("Lanzar");
        boton1.addActionListener(this);
        //contenedor.add(boton1);
        
        JPanel panel1 = new JPanel(new GridLayout(2,2));
        panel1.add(boton1);
        
        dado1 = new ejemploDado();
        panel1.add(dado1);
                
        boton2 = new JButton("Lanzar");
        boton2.addActionListener(this);
        panel1.add(boton2);
        
        dado2 = new ejemploDado();        
        panel1.add(dado2);
        
        contenedor.add(panel1);        
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String args []){
        usoDado gui = new usoDado();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==boton1)
        {
            if(boton1.getText().equals("Lanzar")){
            dado1.controlAnimacion();
            boton1.setText("Detener");
            }
            else{
                System.out.println("Se va a detener");
                dado1.pararAnimacion();
                //JOptionPane.showMessageDialog(this, dado1.getResultado());
                resultado1 = dado1.getResultado();
                boton1.setText("Lanzar");
            }
        }
        else if(ae.getSource()==boton2){
            if(boton2.getText().equals("Lanzar")){
            dado2.controlAnimacion();
            boton2.setText("Detener");
            }
            else{
                System.out.println("Se va a detener");
                dado2.pararAnimacion();
                //JOptionPane.showMessageDialog(this, dado2.getResultado());
                resultado2 = dado2.getResultado();
                boton2.setText("Lanzar");
            }
        }
        System.out.println("Resultados");
        System.out.println(resultado1);
        System.out.println(resultado2);
        if (resultado1 !=0 && resultado2 !=0 ){
            if(resultado1>resultado2){
                JOptionPane.showMessageDialog(this, "gano el jugador 1");
            }else{
                JOptionPane.showMessageDialog(this, "gano el jugador 2");
            }
        }
        
    }
    
}
