import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;

//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.ImageIcon;

public class Ventana1 extends JFrame{
    //JFrame frame is a GUI window to add components to
        //sintaxis: 
        //  JFrame frame = new JFrame("Test Frame"); Crear ventana
        //  frame.getContentPane().add(new JButton("OK")); añadir componentes

        //Container es otra forma de crear una ventana
        //    Container container = getContentPane();
        //    container.add(New JButton("OK"));

        /*
        JFrame frame
        container = frame.getContentPane(); con esta accedemos al container (PArte gris del frame)
        frame.getContentPane().add(new JButton("OK"));

        Si estamos creando una ventana de una clase la cual estamos heredado de JFrame entonces
        podemso abreviar así:
        frame.getContentPane().add(new JButton("OK"));
         */
 
    Container contenedor = getContentPane();

    public Ventana1(){
        super("Titulo xd");
        setTitle("Window title goes here :'D"); 
        //podemos poner las funciones así como sin nada o podemos utilizar ej: this.setTitle("titulito xd") cuando nos refiramso al JFrame
        setSize(500,500);
        setVisible(true);

        //layout
        //this.setLayout(null); //Cuando utilizamos null debemos setear los bounds para cada elemento
        //ej labelNombre.setBounds(0,0,width,height)


        //icono
        //ImageIcon image = new imageIcon("ruta.jpg") ejemplo de logo para la ventana
        //setIconImage(image.getImage());

        //Color de fondo
        //contenedor.setBackground(Color.green);
        //contenedor.setBackground(new Color(123,50,250));  //also you can work with hexadecimal color like: new Color(0x123456)

        //Close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Formulario
        JLabel l1 = new JLabel();
        l1.setText("Hey bruh you even code?"); 
        //Puedes agregar texto al label de esta manera o puedes parsarselo directamente como argumento en new JLabel();
        //l1.setIcon(image); podemos ponerle imagenes a el texto xd
        l1.setHorizontalTextPosition(JLabel.LEFT);
        //La opción anterior nos sirve para posicionar el texto del respecto al contenedor, la constantes son: TOP, CENTER, BOTTOM, LEFT, RIGHT
        l1.setForeground(Color.DARK_GRAY); //podemos darle color al texto así
        //setFont(new Font("MV Boli", Font.PLAIN.20)) //Le podemos asignar fuente tambien xd no funciona rey xd;
        //solo funciona para JFrame
        //l1.setIconTextGap(50); estable una seaparcion de n pixeles respecto al texto
        l1.setVerticalAlignment(JLabel.CENTER); //Alinea l1 al centro verticalmente
        l1.setHorizontalAlignment(JLabel.CENTER); //Alinea l1 al centro horizonatlmente
        contenedor.add(l1);

        //el tamaño por default de la ventana se ajusta a los componentes
        //this.pack(); //recuerda que se puede colocar solo pack() toca borar setSize()
    }
}
