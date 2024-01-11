package ejemplostimer;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

public class ProgressBarDemo extends JFrame {

    private JProgressBar barra;
    private Timer temporizador;
    private JButton boton;
    private JLabel etiqueta;
    private int valor;
    private final int MAX=10;
    private Container contenedor;

    public ProgressBarDemo() 
    {  	
        super("ProgressBarDemo");       
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        boton = new JButton("Iniciar proceso");
        ManejoActionEvent manejador = new ManejoActionEvent();
        boton.addActionListener(manejador);

        barra = new JProgressBar(0, MAX);
        barra.setValue(0);
        
        etiqueta = new JLabel();
        JPanel panel = new JPanel();
        panel.add(boton);
        panel.add(barra);
           
        contenedor.add(panel);
        contenedor.add(etiqueta);   
        
        temporizador = new Timer(1000, manejador );
        setSize( 300, 120 );
        setVisible( true );
 
    }

    class ManejoActionEvent implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
        	
         if (evento.getSource()==boton){
          temporizador.start();
          boton.setEnabled(false);
        }
        	 
         barra.setValue(valor);
         etiqueta.setText(String.valueOf((int)((100*valor)/MAX)) + "%" );
                     
         valor++;
            
         if (valor>MAX) 
         {
            Toolkit.getDefaultToolkit().beep();
            temporizador.stop();
            JOptionPane.showMessageDialog(null, "Terminó el proceso");
            boton.setEnabled(true);
            valor=0;
            barra.setValue(barra.getMinimum());
          }
            
        }
    }

  
    public static void main(String[] args) 
    {
      ProgressBarDemo aplicacion = new ProgressBarDemo();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
     
    }
}
