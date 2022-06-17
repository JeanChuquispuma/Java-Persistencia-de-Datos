import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Connection connection;
    private static Conexion instancia;
    private static String url;
    private static String usuario;
    private static String password;

    public static Connection getConnection() {
        url = "jdbc:mysql://localhost:3306/mensajes_app";
        usuario = "root";
        password = "123456";

        try{
            connection = DriverManager.getConnection(url,usuario, password);
        }catch (Exception e){
            System.out.println("Error al Conectar! : " + e);
        }
        return connection;
    }

    public void cerrarConexion() throws SQLException {
        try{
            connection.close();
        }catch (Exception e){
            connection.close();
        }finally {
            connection.close();
        }
    }

    public static Conexion getInstance(){
        if (instancia == null){
            instancia = new Conexion();
        }
        return instancia;
    }

}
