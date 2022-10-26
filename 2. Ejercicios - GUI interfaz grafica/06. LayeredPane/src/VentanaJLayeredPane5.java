import javax.swing.*;
import java.awt.*;
/*
 *  JLayeredPane -> Swing container that provides a 
				third dimension for positioning components
				ex. depth, Z-index   
 */

public class VentanaJLayeredPane {
    VentanaJLayeredPane(){
        // ------- gui window settings ---------
        JFrame frame = new JFrame("JLayeredPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLayout(null);
        // ------- gui window settings ---------

        // ------ Labels -------
        JLabel label1 = new JLabel();
        label1.setOpaque(true);
        label1.setBackground(Color.RED);
        label1.setBounds(50,50,200,200);
        
        JLabel label2= new JLabel();
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setBounds(100,100,200,200);
        
        JLabel label3= new JLabel();
        label3.setOpaque(true);
        label3.setBackground(Color.BLUE);
        label3.setBounds(150,150,200,200);
        // ------ Labels -------

        // ------ Layered pane settings -------
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0,0,500,500);
        frame.add(layeredPane);

        //Se tienen tambióne palabras claves para cada lay como DEFAULT_LAYER
        layeredPane.add(label1, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(label1, null,Integer.valueOf(0));
        layeredPane.add(label2, null,Integer.valueOf(2));
        layeredPane.add(label3, null,Integer.valueOf(1));
        // ------ Layered pane settings -------

        frame.setVisible(true);
    }
}
