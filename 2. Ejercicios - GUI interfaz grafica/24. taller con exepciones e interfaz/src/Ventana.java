import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Locale;
//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener{
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
    Pelicula p9 = new Pelicula("The Avergers",
                                "Movie of Avergers in china town",
                                2.5,
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
    final Container contenedor;
    int ancho_ventana =400;
    int largo_ventana =450;
    JComboBox<String> combo1;
    JTextArea textArea;
    JButton agregar_btn, terminar_btn;
    JPanel pp= new JPanel(), panel_factura=new JPanel();
    //Tamaño customizado para los TextField, JButton y JComboBox
    Dimension input_dimension = new Dimension((int)Math.floor(ancho_ventana*0.9),35);
    JScrollPane scroll;
    //------------ invoice
    JScrollPane scroll2;
    JTextArea textArea2;


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
        JLabel label1  = new JLabel("      Alquilar peliculas     ");
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
        
        textArea = new JTextArea(12,31);
        /*textArea.setPreferredSize(
            new Dimension(
                (int) Math.floor(input_dimension.getWidth())-20 , 
                (int) Math.floor(input_dimension.getHeight()*6)
                )
            );*/
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        pp.add(textArea);
        scroll=new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pp.add(scroll);

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
        if(e.getSource()==agregar_btn){
            //Search movie in the invetory
            for (Pelicula m : movies_available) {
                if(m.getName()==combo1.getSelectedItem()){
                    movies_selected.add(m);
                    break;
                }
            }
            printMoviesInCart();
        }
        
        if(e.getSource()==terminar_btn){
           pp.setVisible(false);
           genInvoice();
           panel_factura.setVisible(true);
       }
    }

    //Aditional methods
    public String returnMoviesInCart(){
            String str="";
            for(Pelicula m: movies_selected){
                str+="(+->)"+m.getName()+" Duracion: "+m.getLength()+" | Descripcion: "+m.getDescription()+" | Genero: "+m.getTopic()+"\n\n";
            }
            return str;
        }
    public void printMoviesInCart(){
        textArea.setText(returnMoviesInCart());
    }
    public int totalCost(){
        return movies_selected.size()*Pelicula.price;
    }
    public double totalLenght(){
        double l=0.0;
            for(Pelicula m: movies_selected){
                l+=m.getLength();
            }
            return l;
    }
    public void genInvoice(){
        JLabel invo_label1  = new JLabel("      Factura     ");
        invo_label1.setFont(new Font("Segoe UI Black", 0, 24));
        panel_factura.add(invo_label1);

        JLabel invo_label2  = new JLabel("Estas fueron las peliculas seleccionadas");
        panel_factura.add(invo_label2);

        //............... List of movies
        textArea2 = new JTextArea(returnMoviesInCart(),12,31);
        textArea2.setEditable(false);
        textArea2.setFocusable(false);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        panel_factura.add(textArea2);
        scroll2=new JScrollPane(textArea2);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_factura.add(scroll2);
        printMoviesInCart();
         
        JLabel invo_label3  = new JLabel("Datos finales");
        panel_factura.add(invo_label3);
        JLabel invo_label4  = new JLabel("Precio por cada pelicula: $1000");
        panel_factura.add(invo_label4);
        JLabel invo_label5  = new JLabel("Precio total peliculas alquiladas: $"+totalCost());
        panel_factura.add(invo_label5);
        JLabel invo_label6  = new JLabel("Duración total peliculas alquiladas: "+totalLenght()+"h");
        panel_factura.add(invo_label6);

    }
    public void exceptions(){
        try{
            if(movies_selected.size()<1){
                throw new Excepciones("Debes seleccionar al menos una pelicula")
            }
        }finally{

        }
    }
}