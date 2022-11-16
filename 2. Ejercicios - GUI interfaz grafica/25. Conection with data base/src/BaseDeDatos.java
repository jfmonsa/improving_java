import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BaseDeDatos {
    
    Connection conexion=null;


    public BaseDeDatos(){
        //Conection with the DB
        try{
            conexion = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/interactiva", 
                    "root", "123456789");
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void Consultar(){
        try {
            Statement statement = conexion.createStatement();
            String consulta = "SELECT codigo, nombre, edad, como_me_cae FROM public.estudiante ";
            ResultSet resultado = statement.executeQuery(consulta);
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("Codigo");
            modelo.addColumn("Nombre");
            modelo.addColumn("Edad");
            modelo.addColumn("Me cae bien?");
            
            while(resultado.next()){
                String codigo = resultado.getString(1);
                String nombre = resultado.getString(2);
                int edad = resultado.getInt(3);
                boolean como_me_cae = resultado.getBoolean(4);
                Object [] fila = new Object [4];
                fila[0] = codigo;
                fila[1] = nombre;
                fila[2] = edad;
                fila[3] = como_me_cae;
                modelo.addRow(fila);
                System.out.println(edad);
            }
            JTable tabla = new JTable(modelo);
            JScrollPane barra = new JScrollPane(tabla);
            JOptionPane.showMessageDialog(null,barra);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void insertar(String codigo, String nombre,
    int edad, boolean comoMeCae){
        try {      
            Statement statement = conexion.createStatement();
            String consulta = "INSERT INTO public.estudiante("+
                "nombre, edad, como_me_cae, codigo)" +
                "VALUES ('"+nombre+"', "+edad+", "+comoMeCae+", '"+codigo+"');";
            statement.executeUpdate(consulta);
                    
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }

    public void actualizar(String codigo, String nombre,
    int edad, boolean comoMeCae){
        try {
            Statement statement = conexion.createStatement();
            String consulta = "UPDATE public.estudiante " +
            "SET nombre='"+nombre+"', edad="+edad+", como_me_cae="+comoMeCae +
            " WHERE codigo='"+codigo+"'";
            System.out.println(consulta);
            statement.executeUpdate(consulta);
                    
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }

    public void eliminar(String codigo){
        try {
            Statement statement = conexion.createStatement();
            String consulta = "DELETE FROM public.estudiante " +
            "WHERE codigo='"+codigo+"'";
            System.out.println(consulta);
            statement.executeUpdate(consulta);
                    
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
    }

}
