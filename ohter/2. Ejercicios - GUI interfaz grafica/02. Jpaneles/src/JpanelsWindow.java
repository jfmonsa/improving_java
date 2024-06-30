import javax.swing.*;
import java.awt.*;

public class JpanelsWindow extends JFrame{
    Container contenedor2=getContentPane();

    /*
     * En este ejmplo vamos a estar creando Jpaneles, los paneles son una especie de 'ventanas'
     * pero que se pueden modificar, podemso crear varias, en general son una ayuda a la hora de
     * tener más libertad para modificar nuestra interfaza a nuestro gusto xd
     */
    public JpanelsWindow(){
        //Propiedades que aplican al JFRAME
        super("UwU probbando la vuelta esta de JPaneles");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(750,750);
        this.setVisible(true);
        this.setBackground(Color.LIGHT_GRAY);

               
        //Comienza la magia xd JPanels
        JPanel panel = new JPanel();
        panel.setBackground(Color.red);
        panel.setBounds(0,0,250,250);
        contenedor2.add(panel);
        

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setBounds(250,0,250,250);
        contenedor2.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.setBounds(500,0,250,250);
        contenedor2.add(panel3);

        /*
         * Ahora notese que los JPanels funcionan como contaniers
         * nosotros les podemso agregar elementos para que los contengan ellos
         */
        JLabel label = new JLabel();
        label.setText("Hi bro");
        label.setForeground(Color.WHITE);
        panel.add(label); //Le agregamos el label al primer panel (de color rojo)
        label.setVerticalAlignment(JLabel.TOP);

        /*
         * Ademas a cada JPanel le podemos dar un layout independiete, solo imagina lo
         * que significa en terminos de libertad para diseñar la interfaz <3
         */
        //Ej: dandole layout al panel verde
        panel3.setLayout(new BorderLayout()); //le damos layout border

        /*
         * Podemos quitar el layout manager y ponerle coordenadas arbitrarias dentro
         * del container
         */
        JLabel l2 = new JLabel("hOLA soi nuevo");
        l2.setForeground(Color.WHITE);
        panel2.setLayout(null);
        l2.setBounds(0,0,75,75); //coordenadas asignadas al label l2 dentro de ese JPanel
        panel2.add(l2);

        /*
         * Truquito: como los JPAnels funcionan como si fueran contenedores, entonces los podemos desaparecer o aparecer
         * segun nos convega. Ej: if tal cosa -> (entonces) JPanel.setVisible(false);
         */


    }
}
