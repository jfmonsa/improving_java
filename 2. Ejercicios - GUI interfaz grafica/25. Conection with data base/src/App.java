import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener{

    Container contenedor;
    JButton boton1, boton2, boton3, boton4;
    JTextField campo1, campo2, campo3, campo4;
    JLabel etiqueta1, etiqueta2, etiqueta3, etiqueta4;

    public App(){
        contenedor = getContentPane();
        contenedor.setLayout(new FlowLayout());

        etiqueta1 = new JLabel("Codigo");
        contenedor.add(etiqueta1);
        campo1 = new JTextField(10);
        contenedor.add(campo1);

        etiqueta2 = new JLabel("Nombre");
        contenedor.add(etiqueta2);
        campo2 = new JTextField(10);
        contenedor.add(campo2);

        etiqueta3 = new JLabel("Edad");
        contenedor.add(etiqueta3);
        campo3 = new JTextField(10);
        contenedor.add(campo3);

        etiqueta4 = new JLabel("Como me cae");
        contenedor.add(etiqueta4);
        campo4 = new JTextField(10);
        contenedor.add(campo4);

        boton1 = new JButton("Insertar");
        boton1.addActionListener(this);
        contenedor.add(boton1);
        boton2 = new JButton("Actualizar");
        boton2.addActionListener(this);
        contenedor.add(boton2);
        boton3 = new JButton("Eliminar");
        boton3.addActionListener(this);
        contenedor.add(boton3);
        boton4 = new JButton("Consultar");
        boton4.addActionListener(this);
        contenedor.add(boton4);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200,500);
        setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        /*System.out.println("Hello, World!");
        BaseDeDatos base = new BaseDeDatos();
        base.Consultar();*/
        App app = new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == boton1){
            String codigo = campo1.getText();
            String nombre = campo2.getText();
            int edad = Integer.parseInt(campo3.getText());
            boolean comoMeCae = false;
            if(campo4.getText().equals("bien")){
                comoMeCae = true;
            }
            BaseDeDatos base =new BaseDeDatos();
            base.insertar(codigo, nombre, edad, comoMeCae);
        }
        if(e.getSource()==boton2){
            String codigo = campo1.getText();
            String nombre = campo2.getText();
            int edad = Integer.parseInt(campo3.getText());
            boolean comoMeCae = false;
            if(campo4.getText().equals("bien")){
                comoMeCae = true;
            }
            BaseDeDatos base =new BaseDeDatos();
            base.actualizar(codigo, nombre, edad, comoMeCae);
        }
        if(e.getSource()==boton3){
            String codigo = campo1.getText();
            BaseDeDatos base =new BaseDeDatos();
            base.eliminar(codigo);
        }
        if(e.getSource()==boton4){
            BaseDeDatos base =new BaseDeDatos();
            base.Consultar();
        }
        
    }
}
