import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Buttons extends JFrame implements ActionListener{
    //Vamos a ver un ejemplo del uso de botones
    Container contenedor3=this.getContentPane();
    //Declaramso botones
    JButton btn1;

    Buttons(){
        super("Button's tutorial");
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);

        //Componentes xd
        btn1 = new JButton("Activame");
        btn1.setBounds(200,100,200,75);
        //----------------------------------------------------------------
        btn1.addActionListener(this); //OJO esto no se nos puede olvidar xd
        // si no el action listener no funciona
        /*
         * TIP: para abreviar codigo, para ejecutar una acción cuando sea 'performado'
         * xd el boton podemos utilizar la siguiente sintaxis
         * 
         *  btn1.addActionListener(e -> JOptionPane.showMessageDialog(contenedor3, "Hola guapo me activaste 7v7"));
         */
        //----------------------------------------------------------------
        btn1.setFocusable(false);
        //se puede utilizar para que no sea focusable pero tambien quita un borde medio feito xd
        //btn1.setVerticalTextPosition(JButton.CENTER);
        //btn1.setHorizontalTextPosition(JButton.TOP);
        btn1.setFont(new Font("Comic Sans",Font.BOLD,25)); //customizando la letras
        btn1.setBackground(Color.DARK_GRAY);
        btn1.setForeground(Color.CYAN);
        btn1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2)); //Poniendole un borde al boton
        //btn1.setEnabled(false); sirve para desactivar el boton xd
        contenedor3.add(btn1);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btn1){
            JOptionPane.showMessageDialog(contenedor3, "Hola guapo me activaste 7v7");

            /*
             * action performed es muy interesante por que pq podemos hacer que cosas aparescan y
             * dsaparescan modificandole su setVisible(boolean)
             */
        }
    }
}
