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

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
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
        try {
            Statement statement = DataBase.connection.createStatement();
            String query = "";
            // If is the first configuration
            if (Board.getNumberOfBoardsCreated() < 1) {
                query = "INSERT INTO public.littleBoardRegister(" +
                        "numberOfFigures, secondsToAppear, secondsToDisappear, typeOfFigures)" +
                        "VALUES ("
                        + String.valueOf(board.getNumberOfFigures()) + ", "
                        + String.valueOf(board.getSecondsToAppear()) + ", " +
                        String.valueOf(board.getSecondsToDisappear()) + ", " +
                        String.valueOf(board.getTypeOfFigures()) +
                        ");";

            }
            // If there is already a configuration
            else {
                query = "UPDATE public.estudiantes " +
                        "SET " +
                        "numberOfFigures=" + String.valueOf(board.getNumberOfFigures()) + "," +
                        "secondsToAppear=" + String.valueOf(board.getSecondsToAppear()) + "," +
                        "secondsToDisappear=" + String.valueOf(board.getSecondsToDisappear()) + "," +
                        "typeOfFigures =" + String.valueOf(board.getTypeOfFigures())
                        + ";";
            }
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}