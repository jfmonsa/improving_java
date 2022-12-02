
//Layout
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
//Gui
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//Timer
import javax.swing.Timer;

public class Ventana extends JFrame implements ActionListener {
    // ---------- Global vars ---------------- //
    // Array lists
    ArrayList<VideoJuego> games_available = new ArrayList<>();
    // Almacenar juegos alquilados / comparados
    ArrayList<VideoJuego> games_alq = new ArrayList<>();
    ArrayList<VideoJuego> games_comp = new ArrayList<>();
    // Objetos
    VideoJuego v1 = new VideoJuego("GTA San Andreas", VideoJuego.Genero.Accion);
    VideoJuego v2 = new VideoJuego("GTA Vice city", VideoJuego.Genero.Accion);
    VideoJuego v3 = new VideoJuego("Call 2: Duty Zombis", VideoJuego.Genero.Shooter);
    VideoJuego v4 = new VideoJuego("Call 2: Modo historia", VideoJuego.Genero.Plataformas);
    VideoJuego v5 = new VideoJuego("Plantas vs Zombis I", VideoJuego.Genero.Plataformas);
    VideoJuego v6 = new VideoJuego("Plantas vs Zombis II", VideoJuego.Genero.Plataformas);
    VideoJuego v7 = new VideoJuego("Subway Surfers", VideoJuego.Genero.Plataformas);
    VideoJuego v8 = new VideoJuego("Un videojuego más I", VideoJuego.Genero.Plataformas);
    VideoJuego v9 = new VideoJuego("Red Fear America", VideoJuego.Genero.Shooter);
    VideoJuego v10 = new VideoJuego("USA criminal war", VideoJuego.Genero.Accion);
    VideoJuego v11 = new VideoJuego("Resistence in Vietnam", VideoJuego.Genero.Accion);

    // ---------- Variables globales gui ---------------- //
    final Container contenedor;
    static String windowTitle = "Interfaz videojuegos";
    JLabel label_combo1;
    static String timer = "";
    int ancho_ventana = 400;
    int largo_ventana = 550;
    JComboBox<String> combo1;
    JTextArea textArea;
    JButton agregar_btn, terminar_btn;
    JPanel pp = new JPanel(), panel_factura = new JPanel();
    // Tamaño customizado para los TextField, JButton y JComboBox
    Dimension input_dimension = new Dimension((int) Math.floor(ancho_ventana * 0.9), 35);
    JScrollPane scroll;
    JRadioButton comprar_rbtn;
    JRadioButton alquilar_rbtn;
    // ------------ invoice
    JScrollPane scroll2;
    JTextArea textArea2;

    // ======================= Data Base and Timers ==========================
    private class Factura extends BaseDeDatos {

        public Factura(String nombre_juegos, int num_alquilados, int num_comprados, int costo_alquilados,
                int costo_comprados, int costo_total) {

            insertar(nombre_juegos, num_alquilados, num_comprados, costo_alquilados, costo_comprados, costo_total);
        }
    }

    private class CustomTimer {
        Timer tempo;
        Manejador manejador;
        int contadorSegundos = 0;
        int contadorMinutos = 0;
        int contadorHoras = 0;

        CustomTimer() {
            label_combo1 = new JLabel("0");
            manejador = new Manejador();
            tempo = new Timer(1000, manejador);
            tempo.start();
        }

        public void stopIn30Secs() {
            if (contadorSegundos == 30) {

                comprar_rbtn.setEnabled(false);
                alquilar_rbtn.setEnabled(false);
                agregar_btn.setEnabled(false);
                terminar_btn.setEnabled(false);
                combo1.setEnabled(false);
                JOptionPane.showMessageDialog(contenedor,
                        "Han pasado 30 segundos y no has agregado nada, ya no puedes :D", "Upss",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private class Manejador implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent ae) {
                contadorSegundos++;
                if (contadorSegundos == 60) {
                    contadorMinutos++;
                    contadorSegundos = 0;
                    if (contadorMinutos == 60) {
                        contadorHoras++;
                        contadorMinutos = 0;
                    }
                }
                timer = contadorHoras + ":" + contadorMinutos + ":" + contadorSegundos;
                label_combo1.setText("Seleccione un videojuego + (" + timer + ")");
                stopIn30Secs();
            }
        }

    }
    // ==================== Data Base and Timers ============================

    Ventana() {
        // Titulo
        super(windowTitle);
        // --------- Form settings -------
        contenedor = getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(null);
        // Other settings
        setSize(ancho_ventana, largo_ventana);
        setBackground(Color.LIGHT_GRAY);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --------- Form settings -------
        pp.setBounds(0, 0, ancho_ventana, largo_ventana);
        panel_factura.setBounds(0, 0, ancho_ventana, largo_ventana);
        pp.setLayout(layout);
        panel_factura.setLayout(layout);
        contenedor.add(pp);
        contenedor.add(panel_factura);
        pp.setVisible(true);

        // ---------- Panel principal -------
        JLabel label1 = new JLabel("            Videojuegos           ");
        label1.setFont(new Font("Segoe UI Black", 0, 24));
        pp.add(label1);

        new CustomTimer(); // TODO: invoking the timer
        pp.add(label_combo1);

        // ------------------- llenar inventario ----
        games_available.add(v1);
        games_available.add(v2);
        games_available.add(v3);
        games_available.add(v4);
        games_available.add(v5);
        games_available.add(v6);
        games_available.add(v7);
        games_available.add(v8);
        games_available.add(v9);
        games_available.add(v10);
        games_available.add(v11);
        // ------------------- llenar inventario ----

        // ---------------------- llenar combo -----
        combo1 = new JComboBox<>();
        for (VideoJuego v : games_available)
            combo1.addItem(v.getNombre());
        combo1.setSelectedItem(0);
        combo1.setPreferredSize(input_dimension);
        pp.add(combo1);
        // ---------------------- llenar combo -----

        JLabel label2 = new JLabel("     Seleccione si desea comprar o alquilar:   ");
        pp.add(label2);
        comprar_rbtn = new JRadioButton("Comprar: ($" + VideoJuego.getCostoComprar() + " x juego)");
        alquilar_rbtn = new JRadioButton("Alquilar: ($" + VideoJuego.getCostoAlquilar() + " x juego)");
        ButtonGroup group = new ButtonGroup();
        group.add(comprar_rbtn);
        group.add(alquilar_rbtn);
        pp.add(comprar_rbtn);
        pp.add(alquilar_rbtn);

        textArea = new JTextArea(12, 31);

        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        pp.add(textArea);
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pp.add(scroll);

        agregar_btn = new JButton("Agregar Videojuego");
        agregar_btn.addActionListener(this);
        agregar_btn.setPreferredSize(new Dimension((int) Math.floor(ancho_ventana * 0.9), 25));
        pp.add(agregar_btn);

        terminar_btn = new JButton("Terminar y facturar");
        terminar_btn.addActionListener(this);
        terminar_btn.setPreferredSize(new Dimension((int) Math.floor(ancho_ventana * 0.9), 25));
        pp.add(terminar_btn);
        // ---------- Panel principal -------

        // ---------- Form elements -------
        // ####################################################
        this.setVisible(true);
        // #########################s###########################
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregar_btn) {
            // Search movie in the invetory
            for (VideoJuego v : games_available) {
                if (v.getNombre() == combo1.getSelectedItem()) {
                    if (comprar_rbtn.isSelected()) {
                        games_comp.add(v);
                        break;
                    } else if (alquilar_rbtn.isSelected()) {
                        games_alq.add(v);
                        break;
                    }
                }
            }
            printGamesInCart();
        }

        if (e.getSource() == terminar_btn) {
            pp.setVisible(false);
            try {
                exceptions();
                panel_factura.setVisible(true);
            } catch (Excepciones e1) {
                e1.printStackTrace();
                pp.setVisible(true);
                panel_factura.setVisible(false);
            }

        }
    }

    // ================== Aditional methods ===================
    public String returnGamesInCart() {
        String str = "";
        for (VideoJuego v : games_alq) {
            str += v.toString();
        }
        for (VideoJuego v : games_comp) {
            str += v.toString();
        }
        return str;
    }

    public void printGamesInCart() {
        textArea.setText(returnGamesInCart());
    }

    public int totalCostComprados() {
        return games_comp.size() * VideoJuego.getCostoComprar();
    }

    public int totalCostAlquilados() {
        return games_alq.size() * VideoJuego.getCostoAlquilar();
    }

    public void genInvoice() throws Excepciones {
        JLabel invo_label1 = new JLabel("      Factura     ");
        invo_label1.setFont(new Font("Segoe UI Black", 0, 24));
        panel_factura.add(invo_label1);

        JLabel invo_label2 = new JLabel("Estos fueron los videojuegos seleccionados");
        panel_factura.add(invo_label2);

        // ............... List of movies
        textArea2 = new JTextArea(returnGamesInCart(), 12, 31);
        textArea2.setEditable(false);
        textArea2.setFocusable(false);
        textArea2.setLineWrap(true);
        textArea2.setWrapStyleWord(true);
        panel_factura.add(textArea2);
        scroll2 = new JScrollPane(textArea2);
        scroll2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panel_factura.add(scroll2);
        printGamesInCart();

        JLabel invo_label3 = new JLabel("Datos finales");
        panel_factura.add(invo_label3);
        JLabel invo_label4 = new JLabel("Precio por cada Videojuego comprado: $" + VideoJuego.getCostoComprar() + "");
        panel_factura.add(invo_label4);
        JLabel invo_label5 = new JLabel("Precio por cada Videojuego alquilado: $" + VideoJuego.getCostoAlquilar() + "");
        panel_factura.add(invo_label5);

        // Totales
        int total_cost_alq = totalCostAlquilados();
        int total_cost_comp = totalCostComprados();
        int total_cost = totalCostComprados() + totalCostAlquilados();

        JLabel invo_label6 = new JLabel("Precio total de juegos alquilados: $" + total_cost_alq);
        panel_factura.add(invo_label6);
        JLabel invo_label7 = new JLabel("Precio total de juegos comprados: $" + total_cost_comp);
        panel_factura.add(invo_label7);
        JLabel invo_label8 = new JLabel("Precio total por todo: $" + total_cost);
        panel_factura.add(invo_label8);

        // --------------- Creando el objeto cuyos datos se guardaran en la base de
        // datos ----------------
        // nombre_juegos
        String tmp_nombres = "";
        for (VideoJuego v : games_alq) {
            tmp_nombres += v.getNombre() + ",";
        }
        for (VideoJuego v : games_comp) {
            tmp_nombres += v.getNombre() + ",";
        }

        new Factura(tmp_nombres, games_alq.size(), games_comp.size(), total_cost_alq, total_cost_comp,
                total_cost);
        // --------------- Creando el objeto cuyos datos se guardaran en la base de
        // datos ----------------

    }

    /**
     * Si una persona compra más de 10 juegos, o si alquila más de 7, se le genera
     * una
     * excepción personalizada (no es valido usar algo genérico, debe hacerla y
     * lanzarla
     * usted mismo como aprendimos en clase)
     */
    public void exceptions() throws Excepciones {
        try {
            if (games_alq.size() > 7) {
                throw new Excepciones("Error: No puedes alquilar mas de 7 juegos por vez");
            }
            if (games_comp.size() > 10) {
                throw new Excepciones("Error: No puedes alquilar mas de 10 juegos por vez");
            } else {
                genInvoice();
            }
        } finally {

        }
    }
}