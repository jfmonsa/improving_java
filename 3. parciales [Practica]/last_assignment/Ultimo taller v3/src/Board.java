import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JFrame {
    // Options
    private static int opc_1; // for numberOffigures
    private static int opc_2; // for seconds to Appear the figures
    private static int opc_3; // for seconds to Dissapear
    private static int opc_4; // for type of figures

    // ----------------------- Gui settings --------------------------
    Container container;
    // --- board settings -----
    private int board_gap = 5;
    private int board_n_rows = 3;
    private int board_n_cols = 3;
    private int original_board_size = 402;
    private int pnael_board_width = original_board_size + board_gap * 2 + board_gap * (board_n_cols - 1);
    private int pnael_board_height = original_board_size + board_gap * 2 + board_gap * (board_n_rows - 1);
    private JPanel panel_board;
    // --- board settings -----

    // --- board settings -----
    private JPanel panel_options;
    private int options_height = 200;
    // --- board settings -----

    // --- windows settings -----
    private static String title = "Board 3x3";
    private int win_width = pnael_board_width;
    private int win_height = pnael_board_height + options_height;
    // --- windows settings -----
    // ----------------------- Gui settings --------------------------
    // ------------------------ Panel Board --------------------------

    // ------------------------ Constructor ---------------------------
    Board() {
        // --------------- window settings ---------------------
        super(title);
        container = getContentPane();
        this.setLayout(new FlowLayout());
        this.setSize(win_width, win_height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setBackground(Color.black);
        // --------------- window settings ---------------------

        // --------------- board panel ---------------------
        panel_board = new JPanel(new GridLayout(board_n_rows, board_n_cols, board_gap, board_gap));
        panel_board.setBorder(BorderFactory.createEmptyBorder(board_gap, board_gap, board_gap, board_gap));
        panel_board.setBackground(Color.PINK);
        panel_board.setVisible(true);
        this.add(panel_board);

        // ================ Inner panel for the figures ==================
        JPanel inner_panel_figure = null; // This panel stores the figures;
        int inner_figure_size = original_board_size / 3;
        System.out.println(inner_figure_size);
        Dimension d = new Dimension(inner_figure_size, inner_figure_size);
        for (int i = 0; i < 9; i++) {
            inner_panel_figure = new JPanel(new FlowLayout(FlowLayout.CENTER));
            inner_panel_figure.setSize(d);
            // ---- Color -----
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            inner_panel_figure.setBackground(new Color(r, g, b));
            // --- Color
            // inner_panel_figure.setSize(d);
            inner_panel_figure.setVisible(true);
            panel_board.add(inner_panel_figure);
            // inner_panel_figure.rePaint(this.getGraphics());
            JButton n = new JButton("Hola1");
            n.setBounds(2, 2, inner_figure_size - 4, inner_figure_size - 4);
            inner_panel_figure.add(n);
        }
        // ================ Inner panel for the figures ==================
        // --------------- board panel ---------------------

        // --------------- options panel ---------------------
        panel_options = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel_options.setBounds(0, 0, win_width, options_height);
        panel_options.setBackground(Color.red);
        panel_options.setVisible(true);
        this.add(panel_options);
        // --------------- options panel ---------------------

        // ##################
        this.setVisible(true);
    }

    public void rePaint(Graphics g) {
        g.drawPolygon(new int[] { 10, 20, 30 }, new int[] { 100, 20, 100 }, 3);
    }

}
