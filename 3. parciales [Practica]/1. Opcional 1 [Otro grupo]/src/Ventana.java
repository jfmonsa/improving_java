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
    ArrayList<Libro> arr_libros_inventario = new ArrayList<Libro>();
    ArrayList<Libro> arr_libros_compra = new ArrayList<Libro>();

    LibroClasico l1 = new LibroClasico("El capital tomo 1", "Karl Marx", 125000, "1850 dc");
    LibroClasico l2 = new LibroClasico("El capital tomo 2", "Karl Marx", 145000, "1850 dc");
    LibroColombiano l3 =  new LibroColombiano("Cien años de soledad", "Gabo", 55000, LibroColombiano.RegionDelLibro.Caribe);
    LibroColombiano l4 =  new LibroColombiano("La violencia en Colombia tomo 1", "German Guzman Campos tomo 1", 123000, LibroColombiano.RegionDelLibro.Bogota);
    LibroColombiano l5 =  new LibroColombiano("La violencia en Colombia tomo 2", "German Guzman Campos tomo 1", 88000, LibroColombiano.RegionDelLibro.Bogota);
    // ---------- Global vars ---------------- //

    // ---------- Global gui vars ---------------- //
    Container contenedor;
    //JPanel contenedor;
    int ancho_ventana =400;
    int largo_ventana =450;
    JComboBox<String> combo1;
    JTextArea textArea;
    JButton btn_terminar, btn_agregar;
    Dimension input_dimension = new Dimension((int)Math.floor(ancho_ventana*0.9),35);

    public void fillBookArray(){
        for(Libro lib: arr_libros_inventario){
            combo1.addItem(lib.getNombre());
        }
    }
    // ---------- Global gui vars ---------------- //
    
    Ventana(){
        super("Intefaz libros");
        //adding items to combo
        arr_libros_inventario.add(l1);
        arr_libros_inventario.add(l2);
        arr_libros_inventario.add(l3);
        arr_libros_inventario.add(l4);
        arr_libros_inventario.add(l5);
        //adding items to combo
        //--------- Form settings -------
        contenedor=getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);
        //Other settings
        setSize(ancho_ventana,largo_ventana);
        setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //--------- Form settings -------

        //---------- Form elements -------
        JLabel label1  = new JLabel("Comprar libros");
        label1.setFont(new Font("Segoe UI Black", 0, 24));
        contenedor.add(label1);

        
        JLabel label_combo1 = new JLabel("Seleccione el libro que desea agregar al carrito de compras");
        contenedor.add(label_combo1);

        combo1= new JComboBox<>();
        fillBookArray();
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

        //####################################################
        this.setVisible(true); 
            //this always goes to the end, otherwise it doesn't work
        //#########################s###########################
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Adding books
        if(e.getSource()==btn_agregar){
            //--------- adding books -------
            String seleccionado = (String)combo1.getSelectedItem();
            System.out.println(seleccionado);
            if(l1.getNombre()==seleccionado){
                arr_libros_compra.add(l1);
            }
            else if(l2.getNombre()==seleccionado){
                arr_libros_compra.add(l2);
            }
            else if(l3.getNombre()==seleccionado){
                arr_libros_compra.add(l3);
            }
            else if(l4.getNombre()==seleccionado){
                arr_libros_compra.add(l4);
            }
            else if(l5.getNombre()==seleccionado){
                arr_libros_compra.add(l5);
            }
        actualizarTabla();
        }
        //--------- adding books -------

        //Terminando la compra
        if(e.getSource()==btn_terminar){
            //Validación
            if(arr_libros_compra.size()==0){
                JOptionPane.showMessageDialog(contenedor, "Por favor agregue al menos un libro, para finalizar la compra", "Error", JOptionPane.WARNING_MESSAGE);
            }else{
                finalPrice();
            }
        }
        //Terminando la compra
        
    }

    public String textoLibrosEnCarrito(){
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
}
