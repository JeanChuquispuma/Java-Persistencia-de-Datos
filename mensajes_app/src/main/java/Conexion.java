import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection connection;
    public static Connection get_connection(){
        if (connection == null) {
            try{
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","123456");
            }catch (SQLException e){
                System.out.println(e);
            }
        }
        return connection;
    }
}
