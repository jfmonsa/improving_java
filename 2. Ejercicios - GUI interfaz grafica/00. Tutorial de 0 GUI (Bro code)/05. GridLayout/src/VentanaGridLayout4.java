import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * GridLayout  -> places components in a grid of cells. 
                Each component takes all the available space within its cell, 
                and each cell is the same size. 
 */
public class VentanaGridLayout {
    VentanaGridLayout(){
        JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLayout(new GridLayout(3,3,2,2));

        frame.add(new JButton("1"));
		frame.add(new JButton("2"));
		frame.add(new JButton("3"));
		frame.add(new JButton("4"));
		frame.add(new JButton("5"));
		frame.add(new JButton("6"));
		frame.add(new JButton("7"));
		frame.add(new JButton("8"));
		frame.add(new JButton("9"));

        frame.setVisible(true);
    }
}