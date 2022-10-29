/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.pkg3;

/**
 *
 * @author usuario
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener{
    // ---------- Global vars ---------------- //
    //Array lists
    ArrayList<Empleado> arr_empleados_vinculados = new ArrayList<Empleado>();
    /*
    ArrayList<Libro> arr_libros_compra = new ArrayList<Libro>();
    */

    //Constructors
    /*
     * 
    LibroClasico l1 = new LibroClasico("El capital tomo 1", "Karl Marx", 125000, "1850 dc");
     */
    // ---------- Global vars ---------------- //

    // ---------- Variables globales gui ---------------- //
    Container contenedor=getContentPane();
    int ancho_ventana =400;
    int largo_ventana =450;
    JComboBox<String> combo1;
    JTextArea textArea;
    JButton agregar_empleados_btn, eliminar_empleados_btn;
    JPanel pp, panel_agregar, panel_eliminar;
    JTextField nombre, cedula, salario;
    //Tamaño customizado para los TextField, JButton y JComboBox
    Dimension input_dimension = new Dimension((int)Math.floor(ancho_ventana*0.9),35);
    //------- Panel agregar
    JButton p_agregar_btn;



    Ventana(){
        //Titulo
        super("Interfaz empresa seguridad");
        //--------- Form settings -------
        contenedor=getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(null);
        //Other settings
        setSize(ancho_ventana,largo_ventana);
        setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //--------- Form settings -------
        pp.setBounds(0,0,ancho_ventana,largo_ventana);
        panel_eliminar.setBounds(0,0,ancho_ventana,largo_ventana);
        panel_agregar.setBounds(0,0,ancho_ventana,largo_ventana);
        pp.setLayout(layout);
        panel_eliminar.setLayout(layout);
        panel_agregar.setLayout(layout);
        contenedor.add(pp);
        contenedor.add(panel_eliminar);
        contenedor.add(panel_agregar);
        pp.setVisible(true);

        //---------- Panel principal -------
        JLabel label1  = new JLabel("Panel de control empleados");
        label1.setFont(new Font("Segoe UI Black", 0, 24));
        pp.add(label1);
        
        JLabel label_combo1 = new JLabel("Seleccione una opcion agregar || eliminar");
        pp.add(label_combo1);

        agregar_empleados_btn = new JButton("Agregar Empleado");
        agregar_empleados_btn.addActionListener(this);
        agregar_empleados_btn.setPreferredSize(new Dimension( (int)Math.floor(ancho_ventana*0.9),25));
        pp.add(agregar_empleados_btn);

        eliminar_empleados_btn = new JButton("Eliminar empleado");
        eliminar_empleados_btn.addActionListener(this);
        eliminar_empleados_btn.setPreferredSize(new Dimension((int)Math.floor(ancho_ventana*0.9),25));
        pp.add(eliminar_empleados_btn);
        //---------- Panel principal -------

        // --------- eliminar empleados -------
        JLabel label11  = new JLabel("Agregar empleados");
        label11.setFont(new Font("Segoe UI Black", 0, 24));
        panel_agregar.add(label11);

        JLabel label_combo11 = new JLabel("Seleccione el rango");
        panel_agregar.add(label_combo11);

        combo1= new JComboBox<>();
        //Llenando el combos
        Empleado.Rango empleados[] = Empleado.Rango.values();
        for(Empleado.Rango rang: empleados){
            combo1.addItem(rang.name());
        }
        combo1.setSelectedItem(1);
        combo1.setPreferredSize(input_dimension);
        panel_agregar.add(combo1);

        JLabel label_combo21 = new JLabel("Escriba el nombre");
        panel_agregar.add(label_combo21);
        nombre = new JTextField();
        nombre.setPreferredSize(input_dimension);
        panel_agregar.add(nombre);

        JLabel label_combo31 = new JLabel("Escriba la cedula");
        contenedor.add(label_combo31);
        cedula = new JTextField();
        cedula.setPreferredSize(input_dimension);
        panel_agregar.add(cedula);

        JLabel label_combo41 = new JLabel("Ingrese el salario");
        contenedor.add(label_combo41);
        salario = new JTextField();
        salario.setPreferredSize(input_dimension);
        panel_agregar.add(salario);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension((int)Math.floor(ancho_ventana*0.9),175));
        textArea.setBounds(200,280,100,40);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        contenedor.add(textArea);
        JScrollPane scroll=new JScrollPane(textArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        contenedor.add(scroll);

        p_agregar_btn = new JButton("Agregar empleados");
        p_agregar_btn.addActionListener(this);
        p_agregar_btn.setPreferredSize(new Dimension((int)Math.floor(ancho_ventana*0.9),25));
        panel_agregar.add(p_agregar_btn);
        // --------- eliminar empleados -------
        
        //---------- Form elements -------
        //####################################################
        this.setVisible(true); 
        //#########################s###########################
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==agregar_empleados_btn){
            pp.setVisible(false);
            panel_agregar.setVisible(true);

            if(e.getSource()==p_agregar_btn){
               Empleado emp = new Empleado(nombre.getText(), cedula.getText(), (String) combo1.getSelectedItem(), salario.getText());
               arr_empleados_vinculados.add(emp);
               actualizarTabla();
            }
       }
    }

    //Métodos adicionales

public String empleadosContratados(){
        String cadena="";
        for(Empleado emp: arr_empleados_vinculados){
            cadena+="(+)"+emp.getNombre()+" id: "+emp.getCedula()+" | Rango: "+emp.getRango()+" | Salario: "+emp.getSalario()+"\n";
        }
        return cadena;
    }
    public void actualizarTabla(){
        textArea.setText(empleadosContratados());
    }
}