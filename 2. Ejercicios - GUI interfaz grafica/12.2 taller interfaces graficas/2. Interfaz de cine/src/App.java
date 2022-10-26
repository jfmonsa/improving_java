import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class App extends JFrame implements ActionListener{

    Container contenedor;
        //Elementos del formulario
    JComboBox combo1,combo2,combo3;
    JTextField campo1;
    JTextField campo2;
    JButton boton1;

    //Datos del combobox
    String []Dimensiones= {"2D", "3D", "4D"};
    String []Peliculas={"Taxi driver", "Bophal a prayer for the rain", "La chinoise", "La estrategia del caracol", "Golpe de estadio"};
    String []Horarios={"2:30","5:30","7:10","9:30","10:30","11:30"};

    //
    int final_price=0;
    public App() {
        super("Boleteria cinemax");
        contenedor = getContentPane();
        

        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);

        JLabel etiqueta1 = new JLabel("Bienvenido a la boleteria. ¿Qué le gustaría adquirir?");
        contenedor.add(etiqueta1);

        combo1 = new JComboBox<>(Peliculas);
        //combo1.addItemListener(this);
        contenedor.add(combo1);

        combo2 = new JComboBox<>(Dimensiones);
        //combo2.addItemListener(this);
        contenedor.add(combo2);

        combo3 = new JComboBox<>(Horarios);
        //combo3.addItemListener(this);
        contenedor.add(combo3);

        JLabel etiqueta2 = new JLabel("Cantidad?:");
        contenedor.add(etiqueta2);

        campo1 = new JTextField(5);        
        contenedor.add(campo1);

        JLabel etiqueta3 = new JLabel("Ingrese su nombre: ");
        contenedor.add(etiqueta3);

        campo2 = new JTextField(10);        
        contenedor.add(campo2);

        boton1 = new JButton("Aceptar");
        boton1.addActionListener(this);
        contenedor.add(boton1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setVisible(true);
    }


    public static void main(String[] args) throws Exception {
        new App(); //Mostrar la ventana
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Dependiendo de que dimension elija se pone un precio u otro
        switch(combo2.getSelectedIndex()){
            case 0: final_price = Integer.parseInt(campo1.getText()) * 12000;break;
            case 1: final_price = Integer.parseInt(campo1.getText()) * 24000;break;
            case 2: final_price = Integer.parseInt(campo1.getText()) * 37600;break;
        }
        JOptionPane.showMessageDialog(contenedor,"Gracias " + campo2.getText() + ", su valor a pagar es de: " + final_price);
        //Limpiando los campos al finalizar
        campo1.setText("");
        campo2.setText("");

    }
}