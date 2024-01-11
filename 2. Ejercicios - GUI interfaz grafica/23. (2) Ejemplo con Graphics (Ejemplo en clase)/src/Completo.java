import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Completo extends JFrame implements ActionListener{

    Container contenedor;
    JPanel panel = new JPanel();
    
    public Completo(){        
        contenedor = getContentPane();
        /*contenedor.setLayout(new BorderLayout(20,20));
        JButton boton1 = new JButton("aceptar");
        contenedor.add(boton1, BorderLayout.SOUTH);
        JButton boton2 = new JButton("cancelar");
        contenedor.add(boton2, BorderLayout.SOUTH);*/
        
        
        /* Ejemplo2
        contenedor.setLayout(new GridLayout(2,2,20,20));
        JButton boton1 = new JButton("Boton1");
        contenedor.add(boton1);
        JButton boton2 = new JButton("Boton2");
        contenedor.add(boton2);
        JButton boton3 = new JButton("Boton3");
        contenedor.add(boton3);
        JButton boton4 = new JButton("Boton4");
        contenedor.add(boton4);*/
        
        contenedor.setLayout(new BorderLayout());
        
        panel.setLayout(new GridLayout(1,3));
        JLabel etiqueta1 = new JLabel("");
        panel.add(etiqueta1);
        JButton boton1 = new JButton("Boton1");
        panel.add(boton1);
        JLabel etiqueta2 = new JLabel("");
        panel.add(etiqueta2);
        
        
        JButton boton2 = new JButton("Mostrar/Ocultar");
        boton2.addActionListener(this);
        contenedor.add(boton2, BorderLayout.EAST);
        
        contenedor.add(panel, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        Completo c = new Completo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(panel.isVisible()){
            panel.setVisible(false);
        }else{
            panel.setVisible(true);
        }
        
    }
    
}
