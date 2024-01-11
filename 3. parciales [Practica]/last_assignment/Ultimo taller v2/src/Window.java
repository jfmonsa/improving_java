import javax.swing.*;
import java.awt.*;
// Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Delay the figures
import javax.swing.Timer;

public class Window extends DataBase implements ActionListener {

    JFrame frame = new JFrame("Board with figures");
    // ------ gui general variables--------
    int win_width = 400;
    int win_height = 400;
    Thread thread;

    JButton btn_saveConfigs;
    // Custom size for TextField, JButton y JComboBox
    Dimension input_dimension = new Dimension((int) Math.floor(win_width * 0.9), 25);
    Dimension btn_dimesion = new Dimension((int) Math.floor(win_width * 0.9), 30);
    // ------ gui general variables--------

    // ------ gui config_panel's variables--------
    JPanel config_panel;
    JLabel cp_title, cp_l1, cp_l2, cp_l3, cp_l4;
    JComboBox<String> cp_opt1, cp_opt2, cp_opt3, cp_opt4;
    // ------ gui config_panel's variables--------

    // ------ gui board's variables--------
    JPanel board_panel;
    JPanel board_panel_figures;
    JButton btn_exitBoard;
    Board board = getBoard();
    Boolean[][] matrixBoard = Board.getMatrixBoard();
    // ------ gui board's variables--------

    // ---------- Constructor---------------
    Window() {
        // --------- Form settings -------
        frame.setSize(win_width, win_height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color bg_color = Color.WHITE;
        // --------- Form settings -------

        // -------- Config panel ----------
        // -- Settings --
        config_panel = new JPanel(); // menu
        config_panel.setBounds(0, 0, win_width, win_height);
        config_panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        config_panel.setBackground(bg_color);
        // ----
        frame.add(config_panel);
        config_panel.setVisible(true);
        // -- Settings --

        // -- form elements --
        cp_title = new JLabel("Configurar tu tablero");
        cp_title.setFont(new Font("Segoe UI Black", 0, 24));
        config_panel.add(cp_title);

        // #1
        cp_l1 = new JLabel("Selecciona el número de figuras");
        config_panel.add(cp_l1);
        // -- combo --
        String[] s1 = { "2 figuras", "4 figuras", "9 figuras" };
        cp_opt1 = new JComboBox<String>(s1);
        cp_opt1.setPreferredSize(input_dimension);
        cp_opt1.setSelectedIndex(0);
        config_panel.add(cp_opt1);
        // -- combo --

        // #2
        cp_l2 = new JLabel("Indica cuantos segundos esperan las figuras para aparecer");
        config_panel.add(cp_l2);
        // -- combo --
        String[] s2 = { " tiempo aleatorio entre 0 y 5 segundos", "tiempo aleatorio entre 5 y 10 segundos",
                "5 segundos" };
        cp_opt2 = new JComboBox<String>(s2);
        cp_opt2.setPreferredSize(input_dimension);
        cp_opt2.setSelectedIndex(0);
        config_panel.add(cp_opt2);
        // -- combo -

        // #3
        cp_l3 = new JLabel("Indica cuantos segundos esperan las figuras para desaparecer");
        config_panel.add(cp_l3);
        // -- combo --
        String[] s3 = { " tiempo aleatorio entre 0 y 5 segundos", "tiempo aleatorio entre 5 y 10 segundos",
                "5 segundos" };
        cp_opt3 = new JComboBox<String>(s3);
        cp_opt3.setPreferredSize(input_dimension);
        cp_opt3.setSelectedIndex(0);
        config_panel.add(cp_opt3);
        // -- combo -

        // #4
        cp_l4 = new JLabel("Indica cuantos segundos esperan las figuras para desaparecer");
        config_panel.add(cp_l4);
        // -- combo --
        String[] s4 = { " tiempo aleatorio entre 0 y 5 segundos", "tiempo aleatorio entre 5 y 10 segundos",
                "5 segundos" };
        cp_opt4 = new JComboBox<String>(s4);
        cp_opt4.setPreferredSize(input_dimension);
        cp_opt4.setSelectedIndex(0);
        config_panel.add(cp_opt4);
        // -- combo -
        btn_saveConfigs = new JButton("Guardar configuraciones y mostrar tablero");
        btn_saveConfigs.addActionListener(this);
        btn_saveConfigs.setPreferredSize(btn_dimesion);
        btn_saveConfigs.setBackground(Color.GREEN);
        config_panel.add(btn_saveConfigs);
        // -- form elements --
        // -------- Config panel ----------

        // -------- Board panel ----------

        board_panel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // this panel displays the board
        board_panel.setBackground(bg_color);
        frame.add(board_panel);
        // --- Inner board's pannels
        // -- Figure shower
        board_panel_figures = new JPanel(new GridLayout(3, 3, 2, 2));
        board_panel_figures.setBackground(Color.CYAN);
        board_panel_figures.setVisible(true);
        board_panel.add(board_panel_figures);

        // -- Figure shower
        // -- exit button panel
        JPanel board_panel_exitbtn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        board_panel_exitbtn.setBackground(bg_color);
        board_panel_exitbtn.setVisible(true);
        board_panel.add(board_panel_exitbtn);

        btn_exitBoard = new JButton("Volver y modificar las configuraciones");
        btn_exitBoard.addActionListener(this);
        btn_exitBoard.setPreferredSize(btn_dimesion);
        btn_exitBoard.setBackground(Color.GREEN);
        board_panel_exitbtn.add(btn_exitBoard);
        // -- exit button panel
        // --- Inner board's pannels
        // -------- Board panel ----------

        // ----------------------------------
        frame.setVisible(true);
    }
    // ---------- Constructor---------------

    @Override
    public void actionPerformed(ActionEvent e) {
        // Show the board
        if (e.getSource() == btn_saveConfigs) {
            config_panel.setVisible(false);
            board_panel.setVisible(true);
            // rePaint();

        }
        /*
         * import javax.swing.*;
         * import java.awt.*;
         * 
         * public class Main {
         * public static void main(String[] args) {
         * JFrame frame = new JFrame();
         * frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         * frame.setVisible(true);
         * frame.setSize(600, 400);
         * 
         * JPanel panel = new JPanel() {
         * 
         * @Override
         * public void paintComponent(Graphics g) {
         * super.paintComponent(g);
         * g.setColor(Color.BLUE);
         * g.fillRect(0, 0, 100, 100);
         * }
         * };
         * frame.add(panel);
         * 
         * // Graphics g = panel.getGraphics();
         * // g.setColor(Color.BLUE);
         * // g.fillRect(0, 0, 100, 100);
         * 
         * frame.validate(); // because you added panel after setVisible was called
         * frame.repaint(); // because you added panel after setVisible was called
         * }
         * }
         */

        //
        // Hide the board and return to configs
        if (e.getSource() == btn_exitBoard) {
            board_panel.setVisible(false);
            config_panel.setVisible(true);
            thread.stop();

        }
    }

    public void delayFigures(int opc) {
        /*
         * This method delay the figure appears
         * Example of a rando int in a range
         * int rand = (int)(Math.random() * (max - min + 1)) + min;
         */
        try {
            switch (opc) {
                case 1: // 0 a 5
                    Thread.sleep((long) (1000 * ((Math.random() * 6) + 1)));
                    break;
                case 2: // 5 a 10
                    Thread.sleep((long) (1000 * ((Math.random() * 6) + 5)));
                    break;
                case 3: // 5
                    Thread.sleep(5 * 1000);
                    break;
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void rePaint(Graphics g) {
        for (int i = 0; i < matrixBoard.length; i++) {
            for (int j = 0; j < matrixBoard[i].length; j++) {
                // If board matrix is set true in element i,j
                if (matrixBoard[i][j]) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.white);
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        Window win = new Window();
    }
}