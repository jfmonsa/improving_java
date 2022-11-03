import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Ventana extends JFrame implements ActionListener, ItemListener{
    // ---------- Global vars ---------------- //
    //Array lists
    ArrayList<Pelicula> movies_available = new ArrayList<>();
    ArrayList<Pelicula> movies_selected = new ArrayList<>();
    //Objetos
    Pelicula p1 = new Pelicula("«El padrino» (1972)",
                                "Pelicula de Rodolfo Hernandez capo de la mafia en Nueva York",
                                4.5,
                                Pelicula.Topic.Accion);

    Pelicula p2 = new Pelicula("El mago de Oz (1939) El mago de Oz (1939)",
                                "Pelicula de un mango de Oz",
                                6.5,
                                Pelicula.Topic.Drama);
    Pelicula p3 = new Pelicula(" Ciudadano Kane (1941) Ciudadano Kane",
                                "Pelicula del ciudadano Kane",
                                2.5,
                                Pelicula.Topic.Drama);
    Pelicula p4 = new Pelicula(" Cadena perpetua (1994) Cadena Perpetua",
                                "Un hombre inocente es sentenciado a ver esta pelicula",
                                2.5,
                                Pelicula.Topic.Drama);
    Pelicula p5 = new Pelicula("Pulp Fiction (1994)",
                                "La vida de pambele se enreda con dos sicarios y su esposa",
                                3.23,
                                Pelicula.Topic.Accion);
    Pelicula p6 = new Pelicula("Casablanca (1942) Casablanca (1942)",
                                "En cordoba el dueño bar ayuda a escapar a unos campesionos de las malvadas AUC",
                                4.5,
                                Pelicula.Topic.Accion);
    Pelicula p7 = new Pelicula("El padrino: Parte II (1974) El padrino: Parte II (1974)",
                                "Pelicula de Rodolfo Hernandez capo de la mafia en Nueva York (II)",
                                1.75,
                                Pelicula.Topic.Accion);
    Pelicula p8 = new Pelicula("E.T., el extraterrestre (1982)",
                                "Extraterreste nace en Boyacá y se vuelve ciclista",
                                2.1,
                                Pelicula.Topic.Drama);
    Pelicula p9 = new Pelicula("«El padrino» (1972)",
                                "Pelicula de Rodolfo Hernandez capo de la mafia en Nueva York",
                                4.5,
                                Pelicula.Topic.Accion);
    Pelicula p10 = new Pelicula("La ciudad perdida",
                                "Una persona se pierde en el cartucho",
                                4.5,
                                Pelicula.Topic.Accion);
    Pelicula p11 = new Pelicula("La Estrategia del caracol",
                                "Ahí tiene su H#$t4 casa pintada",
                                2.2,
                                Pelicula.Topic.Drama);

    // ---------- Variables globales gui ---------------- //
    Container contenedor=getContentPane();
    int ancho_ventana =400;
    int largo_ventana =450;
    JComboBox<String> combo1;
    JTextArea textArea;
    JButton agregar_btn, terminar_btn;
    JPanel pp= new JPanel(), panel_factura=new JPanel();
    //Tamaño customizado para los TextField, JButton y JComboBox
    Dimension input_dimension = new Dimension((int)Math.floor(ancho_ventana*0.9),35);


    Ventana(){
        //Titulo
        super("Interfaz de cine");
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
        panel_factura.setBounds(0,0,ancho_ventana,largo_ventana);
        pp.setLayout(layout);
        panel_factura.setLayout(layout);
        contenedor.add(pp);
        contenedor.add(panel_factura);
        pp.setVisible(true);

        //---------- Panel principal -------
        JLabel label1  = new JLabel("Alquilar peliculas");
        label1.setFont(new Font("Segoe UI Black", 0, 24));
        pp.add(label1);
        
        JLabel label_combo1 = new JLabel("Seleccione una pelicula");
        pp.add(label_combo1);

            //------------------- llenar inventario ----
            movies_available.add(p1);
            movies_available.add(p2);
            movies_available.add(p3);
            movies_available.add(p4);
            movies_available.add(p5);
            movies_available.add(p6);
            movies_available.add(p7);
            movies_available.add(p8);
            movies_available.add(p9);
            movies_available.add(p10);
            movies_available.add(p11);
            //------------------- llenar inventario ----

            //---------------------- llenar combo -----
            combo1= new JComboBox<>();
            for(Pelicula m: movies_available)combo1.addItem(m.getName());
            combo1.setSelectedItem(1);
            combo1.setPreferredSize(input_dimension);
            pp.add(combo1);
            //---------------------- llenar combo -----
        
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

        agregar_btn = new JButton("Agregar Pelicula");
        agregar_btn.addActionListener(this);
        agregar_btn.setPreferredSize(new Dimension((int)Math.floor(ancho_ventana*0.9),25));
        pp.add(agregar_btn);

        terminar_btn = new JButton("Terminar y facturar");
        terminar_btn.addActionListener(this);
        terminar_btn.setPreferredSize(new Dimension((int)Math.floor(ancho_ventana*0.9),25));
        pp.add(terminar_btn);
        //---------- Panel principal -------

        // --------- eliminar empleados -------   

        
        // --------- eliminar empleados -------
        
        //---------- Form elements -------
        //####################################################
        this.setVisible(true); 
        //#########################s###########################
}
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==terminar_btn){
           pp.setVisible(false);
           panel_factura.setVisible(true);
       }
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
    }
    //Métodos adicionales
/*
 * public String empleadosContratados(){
        String cadena="";
        for(Empleado emp: arr_empleados_vinculados){
            cadena+="(+)"+emp.getNombre()+" id: "+emp.getCedula()+" | Rango: "+emp.getRango()+" | Salario: "+emp.getSalario()+"\n";
        }
        return cadena;
    }
    public void actualizarTabla(){
        textArea.setText(empleadosContratados());
    }
    
 */

}