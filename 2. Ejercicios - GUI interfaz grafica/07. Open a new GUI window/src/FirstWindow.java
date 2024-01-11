import java.awt.event.*;
import javax.swing.*;

/*
 * 
 */

public class FirstWindow  implements ActionListener{
    JFrame frame = new JFrame();
    JButton myButton = new JButton("New Window");

    FirstWindow(){
        myButton.setBounds(100,160,200,40);
        myButton.setFocusable(false);
        myButton.addActionListener(this);  
        frame.add(myButton);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==myButton) {
            frame.dispose();
            new NewWindow();  //Opening the new window
    }
}
}
