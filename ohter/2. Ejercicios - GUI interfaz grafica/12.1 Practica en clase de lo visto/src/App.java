import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;  

public class App extends JFrame implements ActionListener, ItemListener{

    Container contenedor;

    JButton boton1;
    JButton boton2;
    JButton boton3;
    JButton boton4;
    JButton boton5;
    JTextField campo1;
    JTextArea area;
    JCheckBox check1;
    JCheckBox check2;
    JCheckBox check3;
    JRadioButton radio1, radio2, radio3;
    ButtonGroup grupoBotones;
    String colores [] = {"rojo", "azul", "amarillo", "blanco"};
    String equipos [] = {"mechita", "casi", "millos", "junior"};
    JComboBox combo;
    JList lista;

    public App(){
        super("Prueba 1");
        contenedor = getContentPane();

        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);


        
        JLabel etiqueta1 = new JLabel("hola muchachos");
        contenedor.add(etiqueta1);

        JLabel etiqueta2 = new JLabel("7:37 AM");
        contenedor.add(etiqueta2);

        JLabel etiqueta3 = new JLabel();
        Icon icono = new ImageIcon("terminator.jpg");
        etiqueta3.setIcon(icono);
        contenedor.add(etiqueta3);

        campo1 = new JTextField(10);        
        contenedor.add(campo1);

        boton1 = new JButton("Aceptar");
        boton1.addActionListener(this);
        contenedor.add(boton1);

        boton2 = new JButton("Cancelar");
        boton2.addActionListener(this);
        contenedor.add(boton2);

        boton3 = new JButton("Asignar nombre");
        boton3.addActionListener(this);
        contenedor.add(boton3);

        boton4 = new JButton("Revisar estado civil");
        boton4.addActionListener(this);
        contenedor.add(boton4);

        boton5 = new JButton("Color?");
        boton5.addActionListener(this);
        contenedor.add(boton5);

        area = new JTextArea(5,10);
        JScrollPane scroll = new JScrollPane(area);
        contenedor.add(scroll);

        check1 = new JCheckBox("Soltero");
        contenedor.add(check1);
        check2 = new JCheckBox("Casado");
        contenedor.add(check2);
        check3 = new JCheckBox("Casado que vive como soltero");
        contenedor.add(check3);

        grupoBotones = new ButtonGroup();
        radio1 = new JRadioButton("Soltero");
        grupoBotones.add(radio1);
        contenedor.add(radio1);
        radio2 = new JRadioButton("Casado");
        grupoBotones.add(radio2);
        contenedor.add(radio2);
        radio3 = new JRadioButton("Casado que vive como soltero");
        grupoBotones.add(radio3);
        contenedor.add(radio3);

        
        combo = new JComboBox<>(colores);
        combo.addItemListener(this);
        contenedor.add(combo);

        lista = new JList<>(equipos);
        contenedor.add(lista);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        //JOptionPane.showMessageDialog(contenedor, "buenas");;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
            String resultado = campo1.getText();
            JOptionPane.showMessageDialog(null, "Hola " + resultado);
        }else if(e.getSource()==boton2){
            campo1.setText("");            
        }else if(e.getSource()==boton3){
            campo1.setText("Ya casi es descanso");            
        }else if(e.getSource()==boton4){
            String resultado = "";
            if(check1.isSelected()){
                resultado += check1.getText();
            }else if(check2.isSelected()){
                resultado += check2.getText();
            }else if(check3.isSelected()){
                resultado += check3.getText();
            }
            JOptionPane.showMessageDialog(null, "El estado civil es" + resultado);
        }
        else if(e.getSource()==boton5){
            /*String colorSeleccionado = colores[combo.getSelectedIndex()];
            JOptionPane.showMessageDialog(null, "El color es:" + colorSeleccionado);*/
            String colorSeleccionado = (String) combo.getSelectedItem();
            JOptionPane.showMessageDialog(null, "El color es:" + colorSeleccionado);

            List seleccionados = lista.getSelectedValuesList();
            for (Object seleccionado : seleccionados){
                System.out.println(seleccionado);
            }

        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        //System.out.println(e.getItem());
        //System.out.println(e.getStateChange());
        //System.out.println("El color seleccionado es " + combo.getSelectedItem());
        if(e.getStateChange() == 1){
            System.out.println("El color seleccionado es " + e.getItem());
        }
        
    }
}
