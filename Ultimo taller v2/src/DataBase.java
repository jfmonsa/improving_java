import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DataBase {
    private static Connection connection;
    private Board board;

    // ----------------------- Setters & getters -----------------------
    public void setConnection() {
        // Conection with the DB
        try {
            DataBase.connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/littleBoard",
                    "postgres", "123456789");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ----------------------- Setters & getters -----------------------

    public void select() {
        try {
            Statement statement = DataBase.connection.createStatement();
            String _query = "SELECT numberOfFigures, secondsToAppear, secondsToDisappear, typeOfFigures FROM public.littleBoardRegister;";
            ResultSet result = statement.executeQuery(_query);

            // while (result.next()) {
            // Wile loop isn't necesary because we have only one register in the table
            int numberOfFigures = result.getInt(1);
            int secondsToAppear = result.getInt(2);
            int secondsToDisappear = result.getInt(3);
            int typeOfFigures = result.getInt(1);
            board = new Board(numberOfFigures, secondsToAppear, secondsToDisappear, typeOfFigures);
            // }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertFiguresInDB(Boolean[][] matrix) {
        // If is the first configuration
        if (Board.getNumberOfBoardsCreated() < 1) {
            try {
                Statement statement = DataBase.connection.createStatement();

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j += 3) {
                        String query = "INSERT INTO public.littleBoardRegister(" +
                                "col1, col2, col3)" +
                                "VALUES (" + String.valueOf(matrix[i][j]) + ", " + String.valueOf(matrix[i][j + 1])
                                + ", "
                                + String.valueOf(matrix[i][j + 2]) + ");";
                        statement.executeUpdate(query);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
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