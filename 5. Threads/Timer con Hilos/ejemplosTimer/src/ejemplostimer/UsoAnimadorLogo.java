package ejemplostimer;



import javax.swing.*;
import java.awt.*;

public class UsoAnimadorLogo extends JFrame
{
   private Container contenedor;
   private Animacion animacion;
   	
   	
   public UsoAnimadorLogo()
   {
   	contenedor = getContentPane();
        //contenedor.setLayout(new FlowLayout());
   	animacion = new Animacion();   
   	contenedor.add(animacion);        
        setBackground(Color.white);   	
        
   	setSize(100,100);
   	setVisible(true);
   	
   }
	
	
   public static void main( String args[] )
   {
      UsoAnimadorLogo aplicacion = new UsoAnimadorLogo();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }
   
}
