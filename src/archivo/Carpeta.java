package archivo;

import interaccion.InteraccionUsuario;

import java.io.File;
import java.util.ArrayList;

public class Carpeta {
    private String ruta;
    private ArrayList<Archivo> archivos;

    public Carpeta(String ruta) {
        this.ruta = ruta;
        this.archivos = this.cargarArchivos();
    }

    private ArrayList<Archivo> cargarArchivos() {
        File carpeta = new File(this.ruta);
        String[] listado = carpeta.list();
        if (listado == null) {
            new InteraccionUsuario().mostrarTexto("No existe el directorio especificado");
            return null;
        }
        if (listado.length == 0) {
            new InteraccionUsuario().mostrarTexto("No hay elementos dentro de la carpeta actual");
            return null;
        }

        ArrayList<Archivo> archivos = new ArrayList<>();
        for (String nombreArchivo : listado) {
            String extensionArchivo = nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1);

            boolean extensionValida = false;
            for (ExtensionesDeArchivoPermitidas extension : ExtensionesDeArchivoPermitidas.values()) {
                if (extensionArchivo.equals(extension.toString())) {
                    extensionValida = true;
                    break;
                }
            }

            if (extensionValida) {
                archivos.add(new Archivo(nombreArchivo, this.ruta));
            }
        }
        return archivos;
    }

    public ArrayList<ResultadoCoincidencia> buscarPalabraEnArchivos(String palabraABuscar) {
        ArrayList<ResultadoCoincidencia> resultados = null;
        if (this.archivos == null) {
            return resultados;
        }

        resultados = new ArrayList<>();
        for (Archivo archivo : this.archivos) {
            resultados.add(archivo.obtenerCoincidenciasPalabra(palabraABuscar));
        }
        return resultados;
    }
}
