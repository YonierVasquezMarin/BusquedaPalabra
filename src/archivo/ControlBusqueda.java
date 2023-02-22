package archivo;

import interaccion.InteraccionUsuario;

import java.util.ArrayList;

public class ControlBusqueda {
    public void buscarPalabraEnCarpeta() {
        InteraccionUsuario interaccionUsuario = new InteraccionUsuario();

        String ruta = interaccionUsuario.solicitarTexto("Ingrese la ruta de la carpeta: ");
        String palabraABuscar = interaccionUsuario.solicitarTexto("Ingrese la palabra a buscar: ");

        Carpeta carpeta = new Carpeta(ruta);
        ArrayList<ResultadoCoincidencia> resultados = carpeta.buscarPalabraEnArchivos(palabraABuscar);

        if (resultados == null) {
            return;
        }

        if (resultados.size() == 0) {
            interaccionUsuario.mostrarTexto("No se encontraron archivos de texto en la carpeta.");
            return;
        }

        for (ResultadoCoincidencia resultado : resultados) {
            interaccionUsuario.mostrarTexto(resultado.toString());
        }

        int cantidadArchivosCoincidentes = 0;
        for (ResultadoCoincidencia resultado : resultados) {
            cantidadArchivosCoincidentes += resultado.getCantidadCoincidencias();
        }

        if (cantidadArchivosCoincidentes > 0) {
            interaccionUsuario.mostrarTexto("Total: " + cantidadArchivosCoincidentes + " veces");
        }
    }
}
