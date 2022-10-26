import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.FlowLayout;

public class App extends JFrame implements ActionListener {

    Container contenedor;

    Producto obj;

    // Vector para guardar los productos
    ArrayList<Producto> productos = new ArrayList<Producto>();

    JScrollPane scroll_descripcion, scrollPane;
    JLabel texto1, texto_nombre, texto_precio, texto_num_inventario, texto_descripcion;
    JButton agregarMenu, consultarMenu, enviar, volver, modificar;
    JTextField nombre, precio, num_inventario;
    JTextArea descripcion;
    JTable tabla;
    String sNombre, sPrecio, sNum_inventario, sDescripcion;

    // Arrays para la tabla
    String[] columnas = { "Nombre", "Precio", "# en inventario", "Descripción" };
    String[][] datosTabla;

    public App() {
        super("Tienda");

        contenedor = getContentPane();
        FlowLayout layout = new FlowLayout();
        contenedor.setLayout(layout);

        // Botón AGREGAR (menú)
        agregarMenu = new JButton("Agregar producto");
        agregarMenu.addActionListener(this);
        contenedor.add(agregarMenu);

        // Botón CONSULTAR (menú)
        consultarMenu = new JButton("Consultar productos");
        consultarMenu.addActionListener(this);
        contenedor.add(consultarMenu);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setVisible(true);

        texto1 = new JLabel("Ingrese el nuevo producto:");
        contenedor.add(texto1);

        // Campo de texto para NOMBRE
        texto_nombre = new JLabel("Nombre: ");
        contenedor.add(texto_nombre);

        nombre = new JTextField(15);
        contenedor.add(nombre);

        // Campo de texto para PRECIO
        texto_precio = new JLabel("Precio: ");
        contenedor.add(texto_precio);

        precio = new JTextField(5);
        contenedor.add(precio);

        // Campo de texto para NUMERO EN INVENTARIO
        texto_num_inventario = new JLabel("# Inventario: ");
        contenedor.add(texto_num_inventario);

        num_inventario = new JTextField(3);
        contenedor.add(num_inventario);

        // Area de texto para DESCRIPCION
        texto_descripcion = new JLabel("Descripción: ");
        contenedor.add(texto_descripcion);

        descripcion = new JTextArea(5, 20);
        scroll_descripcion = new JScrollPane(descripcion);
        contenedor.add(scroll_descripcion);

        // Botón ENVIAR
        enviar = new JButton("Enviar");
        enviar.addActionListener(this);
        contenedor.add(enviar);

        // Botón VOLVER
        volver = new JButton("Volver");
        volver.addActionListener(this);
        contenedor.add(volver);

        // Botón MODIFICAR
        modificar = new JButton("Modificar # inventario");
        modificar.addActionListener(this);
        contenedor.add(modificar);

        // Inicialización JScrollPane TABLA
        scrollPane = new JScrollPane(tabla);

        mostrar_menuPrincipal();
    }

    public static void main(String[] args) throws Exception {
        App app = new App();

    }

    public void mostrar_menuPrincipal() {
        texto1.setVisible(false);
        enviar.setVisible(false);
        nombre.setVisible(false);
        precio.setVisible(false);
        num_inventario.setVisible(false);
        scroll_descripcion.setVisible(false);
        texto_nombre.setVisible(false);
        texto_precio.setVisible(false);
        texto_num_inventario.setVisible(false);
        texto_descripcion.setVisible(false);
        volver.setVisible(false);
        scrollPane.setVisible(false);
        modificar.setVisible(false);

        agregarMenu.setVisible(true);
        consultarMenu.setVisible(true);
    }

    public void mostrar_consultarMenu() {

        // Para actualizar el array con la cantidad de productos que hayan

        String[][] datosTabla = new String[productos.size()][4]; // Crea el array 2D con el tamaño necesario
        for (int i = 0; i <= productos.size() - 1; i++) {
            obj = productos.get(i);
            for (int j = 0; j < 4; j++) {
                // Asigna los valores del obj al array
                if (j == 0)
                    datosTabla[i][j] = obj.getNombre();
                else if (j == 1)
                    datosTabla[i][j] = obj.getPrecio();
                else if (j == 2)
                    datosTabla[i][j] = obj.getNum_inventario();
                else if (j == 3)
                    datosTabla[i][j] = obj.getDescripcion();
            }
        }

        tabla = new JTable(datosTabla, columnas);
        scrollPane = new JScrollPane(tabla);
        tabla.setFillsViewportHeight(true); // Para usar la altura total de la ventana
        tabla.setEnabled(false); // Para desactivar la interacción con la tabla
        contenedor.add(scrollPane);

        scrollPane.setVisible(true);
        volver.setVisible(true);

        agregarMenu.setVisible(false);
        consultarMenu.setVisible(false);
    }

    public void mostrar_agregarMenu() {
        texto1.setVisible(true);
        enviar.setVisible(true);
        nombre.setVisible(true);
        precio.setVisible(true);
        num_inventario.setVisible(true);
        scroll_descripcion.setVisible(true);
        texto_nombre.setVisible(true);
        texto_precio.setVisible(true);
        texto_num_inventario.setVisible(true);
        texto_descripcion.setVisible(true);
        volver.setVisible(true);
        modificar.setVisible(true);

        agregarMenu.setVisible(false);
        consultarMenu.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enviar) {
            if (nombre.getText().isEmpty() || precio.getText().isEmpty() || num_inventario.getText().isEmpty()
                    || descripcion.getText().isEmpty())
                JOptionPane.showMessageDialog(contenedor, "Uno o más campos están vacíos.");
            else
                productos.add(new Producto(nombre.getText(), precio.getText(),
                        num_inventario.getText(), descripcion.getText()));
        } else if (e.getSource() == agregarMenu) {
            mostrar_agregarMenu();
        } else if (e.getSource() == volver) {
            mostrar_menuPrincipal();
        } else if (e.getSource() == consultarMenu && !productos.isEmpty()) {
            mostrar_consultarMenu();
            for (int i = 0; i < productos.size(); i++) {
                obj = productos.get(i);
            }
        } else if (e.getSource() == modificar) {

            if (!productos.isEmpty()) {

                // Busca el producto
                for (int i = 0; i < productos.size(); i++) {
                    obj = productos.get(i);

                    if (obj.getNombre().equals(nombre.getText())) {
                        obj.setNum_inventario(num_inventario.getText());
                        productos.set(i, obj);
                        JOptionPane.showMessageDialog(contenedor, nombre.getText() + " actualizado con éxito.");
                        break;
                    } else
                        JOptionPane.showMessageDialog(contenedor,
                                "El producto ''" + nombre.getText() + "'' no existe.");
                }
            } else
                JOptionPane.showMessageDialog(contenedor, "No existe ningún producto aún.");
        }
    }
}
