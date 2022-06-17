import java.util.Scanner;

public class MensajesService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Quien es el Autor?");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        try{
            MensajesDAO.crearMensajeDB(registro);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void listarMensajes(){
        try{
            MensajesDAO.leerMensajesDB();
        }catch (Exception e){
            System.out.println("Error al leer mensajes: " + e);
        }
    }

    public static void borrarMensaje(){

    }

    public static void editarMensaje(){

    }
}
