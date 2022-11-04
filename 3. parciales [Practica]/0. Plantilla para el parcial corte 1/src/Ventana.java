/* Opcional 1, realizado por:
 * Juan Felipe Monsalve Vargas -1006493078
 */

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
    /*ArrayList<Libro> arr_libros_inventario = new ArrayList<Libro>();
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
    JButton btn_terminar, btn_agregar;
    //Tamaño customizado para los TextField, JButton y JComboBox
    Dimension input_dimension = new Dimension((int)Math.floor(ancho_ventana*0.9),35);

    //llenar un combo con array
    /*public void fillBookArray(){
        for(Libro lib: arr_libros_inventario){
            combo1.addItem(lib.getNombre());
        }
    }*/


    //Llenar combo con Enum[]
    /*
     * Materias mat[]  = Materias.values();
        for(Materias m: mat){
            panel_docentes_combo.addItem(m.name());
        }
     */
    // ---------- Variables globales gui ---------------- //



    Ventana(){
        //Titulo
        super("Intefaz libros");
        //--------- Form settings -------
        contenedor=getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);
        //Other settings
        setSize(ancho_ventana,largo_ventana);
        setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            //Si depronto hay JPanels
            //JPanel panel_ppal, panel_docentes, panel_administrativo;
        //--------- Form settings -------

        //---------- Form elements -------
        JLabel label1  = new JLabel("Comprar libros");
        label1.setFont(new Font("Segoe UI Black", 0, 24));
        contenedor.add(label1);
        
        JLabel label_combo1 = new JLabel("Seleccione el libro que desea agregar al carrito de compras");
        contenedor.add(label_combo1);

        combo1= new JComboBox<>();
        //fillBookArray();
        combo1.setSelectedItem(1);
        combo1.setPreferredSize(input_dimension);
        contenedor.add(combo1);

        JLabel label_tArea = new JLabel("Libros en el carrito de compras");
        contenedor.add(label_tArea);

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

        btn_agregar = new JButton("Agregar libro");
        btn_agregar.addActionListener(this);
        btn_agregar.setPreferredSize(new Dimension( (int)Math.floor(ancho_ventana*0.9),25));
        contenedor.add(btn_agregar);

        btn_terminar = new JButton("Terminar compra");
        btn_terminar.addActionListener(this);
        btn_terminar.setPreferredSize(new Dimension((int)Math.floor(ancho_ventana*0.9),25));
        contenedor.add(btn_terminar);
        //---------- Form elements -------

        //-------- Si hay JPaneles ---------
        /*
         * panel_ppal = new JPanel(layout);
            panel_ppal.setBackground(Color.CYAN);
            panel_ppal.setBounds(0,0,ancho_ventana,largo_ventana);
            this.add(panel_ppal);
         */
        //-------- Si hay JPaneles ---------

        //####################################################
        this.setVisible(true); 
        //#########################s###########################
}

    @Override
    public void itemStateChanged(ItemEvent e) {
        //toca agregar: elem.addItemListener(this)
        /*
         * if(e.getSource()==elm){
         *      //hacer_algo()
         * }
         */
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Adding elements
        /*
        if(e.getSource()==btn_agregar){
            .
            .
            .
            actualizarTabla();
        }
         */

        //Finalize
        /*
        if(e.getSource()==btn_terminar){
            //Validación
            if(arr_libros_compra.size()==0){
                JOptionPane.showMessageDialog(contenedor, "Por favor agregue al menos un libro, para finalizar la compra", "Error", JOptionPane.WARNING_MESSAGE);
            }else{
                finalPrice();
            }
        }
         */
    }

    //Métodos adicionales
    /*
     *     public String textoLibrosEnCarrito(){
        String cadena="";
        for(Libro lib: arr_libros_compra){
            cadena+="(+)"+lib.getNombre()+" by: "+lib.getAutor()+" | id: "+lib.getId()+"\n";
        }
        return cadena;
    }
    public void actualizarTabla(){
        textArea.setText(textoLibrosEnCarrito());
    }

    
    public void finalPrice(){
        int final_price=0;
        for(Libro lib: arr_libros_compra){
            final_price+=lib.getCosto();
        }
        JOptionPane.showMessageDialog(contenedor,
                                    "El precio total de la compra es: "+final_price+" \nLos libros son:\n"+textoLibrosEnCarrito(),
                                    "Compra exitosa :D",
                                    JOptionPane.INFORMATION_MESSAGE);
    }
     */
}