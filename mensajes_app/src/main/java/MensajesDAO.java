import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {

    static Conexion conectar = Conexion.getInstance();

    public static void crearMensajeDB(Mensajes mensaje){
        PreparedStatement ps = null;
        try(Connection conexion = conectar.getConnection()){
            String query="INSERT INTO `mensajes` (`mensaje`,`autor_mensaje`) VALUES (?,?)";
            ps=conexion.prepareStatement(query);
            ps.setString(1,mensaje.getMensaje());
            ps.setString(2,mensaje.getAutor_mensaje());
            ps.executeUpdate();
            System.out.println("Mensaje Creado!");
            conectar.cerrarConexion();
        }catch (Exception e){
            System.out.println("Error al crear el mensaje");
            System.out.println(e);
        }
    }

    public static void leerMensajesDB(){

        PreparedStatement ps= null;
        ResultSet rs=null;

        try(Connection conexion = conectar.getConnection()){
            String query = "SELECT * FROM mensajes";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha"));
                System.out.println();
            }
            conectar.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("No se pudieron recuperar mensajes:" + e);
        }
    }

    public static void borrarMensajeDB(int id_mensaje){
        try(Connection conexion = conectar.getConnection()){
            PreparedStatement ps = null;
            try{
                String query ="DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setInt(1,id_mensaje);
                int countRowsUpdated = ps.executeUpdate();
                if (countRowsUpdated != 0){
                    System.out.println(countRowsUpdated + " Datos han sido borrados exitosamente.");
                }else{
                    System.out.println("No se ha encontrado el dato");
                }
            }catch (Exception e){
                System.out.println(e);
                System.out.println("No se pudo borrar el mensaje");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static  void actualizarMensajeDB(Mensajes mensaje){

    }
}
