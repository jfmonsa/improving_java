import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener {
    // ------------------ gui global -------------
    ArrayList<Empleado> arr_empleados = new ArrayList<Empleado>();
    // ------------------ gui global -------------

    // ------------------ gui global vars -------------
    // Container this;
    // ----- panel_ppal
    int ancho_ventana = 400, largo_ventana = 450, textField_ancho = 20;
    JTextField cedula_txtf, nombre_txtf;
    JTextArea textArea;
    JRadioButton rbtn1, rbtn2;
    ButtonGroup btngroup1;
    JButton continuar_btn;
    JPanel panel_ppal, panel_docentes, panel_administrativo;
    // ----- panel_ppal

    // ----- panel_docentes
    JComboBox<String> panel_docentes_combo;
    JButton panel_docentes_agregar_btn, panel_docentes_cancelar_btn;
    Dimension docentes_field = new Dimension((int) Math.floor(ancho_ventana * 0.9), 35);
    // ----- panel_docentes

    // ----- panel_administrativo
    // ----- panel_administrativo
    // ------------------ gui global vars -------------
    Window() {
        // ------------ Frame settings --------------------
        super("Interfaz empleados universidad");
        // this=getContentPane();
        FlowLayout layout = new FlowLayout();
        // this.setLayout(null);
        // Other settings
        this.setSize(ancho_ventana, largo_ventana);
        this.setBackground(Color.LIGHT_GRAY);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font title_font = new Font("Segoe UI Black", 0, 24);
        // ------------ Frame settings --------------------

        // ------------ Form --------------------------
        panel_ppal = new JPanel(layout);
        panel_ppal.setBackground(Color.CYAN);
        panel_ppal.setBounds(0, 0, ancho_ventana, largo_ventana);
        this.add(panel_ppal);

        JLabel label1 = new JLabel("Administrar empleados");
        label1.setFont(title_font);
        panel_ppal.add(label1);

        JLabel label2 = new JLabel("Numero de cedula:");
        panel_ppal.add(label2);
        cedula_txtf = new JTextField();
        cedula_txtf.setPreferredSize(new Dimension((int) Math.floor(ancho_ventana * 0.5), 25)); // Le damos ancho y alto
                                                                                                // en lugar de solo
                                                                                                // darle el número de
                                                                                                // columnas
        panel_ppal.add(cedula_txtf);

        JLabel label3 = new JLabel("Nombre completo:");
        panel_ppal.add(label3);
        nombre_txtf = new JTextField();
        nombre_txtf.setPreferredSize(new Dimension((int) Math.floor(ancho_ventana * 0.5), 25)); // Le damos ancho y alto
                                                                                                // en lugar de solo
                                                                                                // darle el número de
                                                                                                // columnas
        panel_ppal.add(nombre_txtf);

        JLabel label4 = new JLabel("Seleccione el tipo de empleado");
        panel_ppal.add(label4);
        rbtn1 = new JRadioButton("Docente", true);
        rbtn2 = new JRadioButton("Administrativo");
        btngroup1 = new ButtonGroup();
        btngroup1.add(rbtn1);
        btngroup1.add(rbtn2);
        panel_ppal.add(rbtn1);
        panel_ppal.add(rbtn2);

        JLabel label5 = new JLabel("Lista de empleados: \n");
        panel_ppal.add(label5);
        textArea = new JTextArea(/* "\n\n\n\t\tNO DATA" *//* 5,30 */);
        textArea.setPreferredSize(new Dimension((int) Math.floor(ancho_ventana * 0.9), 175));
        textArea.setBounds(200, 280, 100, 40);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.green);
        panel_ppal.add(textArea);
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panel_ppal.add(scroll);

        continuar_btn = new JButton("Continuar ...");
        continuar_btn.addActionListener(this);
        continuar_btn.setPreferredSize(new Dimension((int) Math.floor(ancho_ventana * 0.9), 25));
        panel_ppal.add(continuar_btn);
        // ------------ Form --------------------------

        // ------------ Esto siempre al final xd --------------------
        this.setVisible(true);
        // ------------ Esto siempre al final xd --------------------

        // -------- Panel docentes --------------------------
        panel_docentes = new JPanel();
        panel_docentes.setBounds(0, 0, ancho_ventana, largo_ventana);
        panel_docentes.setBackground(Color.GREEN);
        panel_docentes.setVisible(false);
        this.add(panel_docentes);

        JLabel panel_docentes_l1 = new JLabel("Agregar un docente");
        panel_docentes_l1.setFont(title_font);
        panel_docentes.add(panel_docentes_l1);

        JLabel panel_docentes_l2 = new JLabel("Seleccione la materia que da el docente");
        panel_docentes.add(panel_docentes_l2);
        panel_docentes_combo = new JComboBox<>();
        panel_docentes_combo.setPreferredSize(docentes_field);
        fillCombo1();
        panel_docentes_combo.setSelectedIndex(1);
        panel_docentes.add(panel_docentes_combo);

        panel_docentes_agregar_btn = new JButton("Agregar");
        panel_docentes_agregar_btn.setPreferredSize(docentes_field);
        panel_docentes_agregar_btn.addActionListener(this);
        panel_docentes.add(panel_docentes_agregar_btn);

        panel_docentes_cancelar_btn = new JButton("Cancelar");
        panel_docentes_cancelar_btn.setPreferredSize(docentes_field);
        panel_docentes_cancelar_btn.addActionListener(this);
        panel_docentes.add(panel_docentes_cancelar_btn);
        // -------- Panel docentes --------------------------
        // -------- Panel Administrativos --------------------
        panel_administrativo = new JPanel();
        panel_administrativo.setBounds(0, 0, ancho_ventana, largo_ventana);
        panel_administrativo.setBackground(Color.GREEN);
        panel_administrativo.setVisible(false);
        this.add(panel_administrativo);

        JLabel panel_administrativo_l1 = new JLabel("Agregar personal admin");
        panel_administrativo_l1.setFont(title_font);
        panel_administrativo.add(panel_administrativo_l1);
        // -------- Panel Administrativos --------------------
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == continuar_btn && nombre_txtf.getText() != "" && cedula_txtf.getText() != "") {
            panel_ppal.setVisible(false);

            // Continuar para docentes
            if (rbtn1.isSelected()) {
                panel_docentes.setVisible(true);

                // Boton cancelar
                if (e.getSource() == panel_docentes_cancelar_btn) {
                    panel_docentes.setVisible(false);
                    panel_ppal.setVisible(true);
                }

                // Boton registrar
                if (e.getSource() == panel_docentes_agregar_btn) {
                    Docente docente = new Docente(nombre_txtf.getText(), cedula_txtf.getText(), null, ancho_ventana,
                            null);
                    arr_empleados.add(docente);
                    actualizarTabla();
                }
            }
            // Continuar para administrativo
            else {
                panel_administrativo.setVisible(true);
            }
        }
        // Cuando no ingresa nombre o cedula
        else if (e.getSource() == continuar_btn && (nombre_txtf.getText() == "" || cedula_txtf.getText() == "")) {
            JOptionPane.showMessageDialog(panel_ppal, "No ingreso cedula o nombre del empleado", "Error",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void fillCombo1() {
        Materias mat[] = Materias.values();
        for (Materias m : mat) {
            panel_docentes_combo.addItem(m.name());
        }
    }

    public void actualizarTabla() {
        String cadena = "";
        for (Empleado e : arr_empleados) {
            // Verificar que el objeto pertenezca a la clase
            cadena += "->" + e.toString() + "\n";
        }
        textArea.setText(cadena);
    }
}
