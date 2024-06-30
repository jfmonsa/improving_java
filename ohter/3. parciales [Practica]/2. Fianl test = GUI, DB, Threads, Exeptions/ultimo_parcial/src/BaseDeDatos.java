import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos {
    Connection conexion=null;

    public BaseDeDatos(){
        //Conection with the DB
        try{
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/parcial_videojuegos_v2", 
                    "postgres", "univalle");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    public void insertar(String nombre_juegos, int num_alquilados, int num_comprados, int costo_alquilados, int costo_comprados, int costo_total){
        try {      
            Statement statement = conexion.createStatement();
            String consulta = "INSERT INTO public.factura_registros("+
                "nombre_juegos, num_alquilados, num_comprados, costo_alquilados, costo_comprados, costo_total)" +
                "VALUES (" +
                    "'"+nombre_juegos+"',"+
                    Integer.toString(num_alquilados)+","+
                    Integer.toString(num_comprados)+","+
                    Integer.toString(costo_alquilados)+","+
                    Integer.toString(costo_comprados)+","+
                    Integer.toString(costo_total)+
                ");";
                System.out.println(consulta);
            statement.executeUpdate(consulta);
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }
}
