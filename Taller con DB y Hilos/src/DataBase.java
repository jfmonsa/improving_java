import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class DataBase {
    private Connection connection;

    // ----------------------- Setters & getters -----------------------
    public void setConnection(Connection connection) {
        // Conection with the DB
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/littleBoard",
                    "postgres", "123456789");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    // ----------------------- Setters & getters -----------------------

    public void select() {
        try {
            Statement statement = connection.createStatement();
            String _query = "SELECT col1, col2, col3 FROM public.littleBoardRegister;";
            ResultSet result = statement.executeQuery(_query);
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("col1");
            tableModel.addColumn("col2");
            tableModel.addColumn("col3");

            while (result.next()) {
                Boolean _col1 = result.getBoolean(1);
                Boolean _col2 = result.getBoolean(2);
                Boolean _col3 = result.getBoolean(3);

                Object[] row = new Object[3];
                row[0] = _col1;
                row[1] = _col2;
                row[2] = _col3;
                tableModel.addRow(row);
            }

            JTable table = new JTable(tableModel);
            JScrollPane scroll = new JScrollPane(table);
            JOptionPane.showMessageDialog(null, scroll);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertFiguresInDB(Boolean[][] matrix) {
        try {
            Statement statement = connection.createStatement();

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j += 3) {
                    String query = "INSERT INTO public.littleBoardRegister(" +
                            "col1, col2, col3)" +
                            "VALUES (" + String.valueOf(matrix[i][j]) + ", " + String.valueOf(matrix[i][j + 1]) + ", "
                            + String.valueOf(matrix[i][j + 2]) + ");";
                    statement.executeUpdate(query);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
/*
 * public void actualizar(String codigo, String nombre,
 * int edad, boolean comoMeCae){
 * try {
 * Statement statement = conexion.createStatement();
 * String consulta = "UPDATE public.estudiantes " +
 * "SET nombre='"+nombre+"', edad="+edad+", como_me_cae="+comoMeCae +
 * " WHERE codigo='"+codigo+"'";
 * System.out.println(consulta);
 * statement.executeUpdate(consulta);
 * 
 * } catch (SQLException e) {
 * // TODO Auto-generated catch block
 * e.printStackTrace();
 * }
 * 
 * }
 */