import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Traduccion extends JFrame implements ActionListener{
    
    Container contenedor;
    JLabel etiqueta;
    JTextField campo1, campo2;
    JButton boton, boton2;

    JTextField campoSpa, campoEng, campoFra;    
    JButton botonIngresar;

    public Traduccion(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        etiqueta = new JLabel("Inserta palabra en español");
        contenedor.add(etiqueta);

        campo1 = new JTextField(10);
        contenedor.add(campo1);

        boton = new JButton("Traducción a ingles");
        boton.addActionListener(this);
        contenedor.add(boton);

        boton2 = new JButton("Traducción a frances");
        boton2.addActionListener(this);
        contenedor.add(boton2);

        campo2 = new JTextField(20
        );
        campo2.setEditable(false);
        contenedor.add(campo2);

        campoSpa = new JTextField(10);
        contenedor.add(campoSpa);
        campoEng = new JTextField(10);
        contenedor.add(campoEng);
        campoFra = new JTextField(10);
        contenedor.add(campoFra);

        botonIngresar = new JButton("Ingresar palabra");
        botonIngresar.addActionListener(this);
        contenedor.add(botonIngresar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,350);
        setVisible(true);
    }

    public static void main(String[] args) {
        Traduccion tr = new Traduccion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonIngresar){
            String palabraSpa = campoSpa.getText();
            String palabraEng = campoEng.getText();
            String palabraFra = campoFra.getText();
            String nuevaTraduccion = palabraSpa + "#" + palabraEng + "#" + palabraFra;
            Archivo archivo = new Archivo();
            archivo.insertarPalabra(nuevaTraduccion);
        }
        else{
            String idioma = "";
            if(e.getSource()==boton){
                idioma = "ingles";
            }else if(e.getSource()==boton2){
                idioma = "frances";
            }
            Archivo archivo = new Archivo();
            String palabraEspanol = campo1.getText();
            String palabraTraducica = archivo.buscarTraduccion(palabraEspanol, idioma);
            campo2.setText(palabraTraducica);
        }
        
    }

}
