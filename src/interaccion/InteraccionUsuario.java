package interaccion;

public class InteraccionUsuario {

    public String solicitarTexto(String msgSolicitud) {
        System.out.print(msgSolicitud);
        return new java.util.Scanner(System.in).nextLine();
    }

    public void mostrarTexto(String msg) {
        System.out.println(msg);
    }
}
