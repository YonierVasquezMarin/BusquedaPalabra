package archivo;

public class ResultadoCoincidencia {
    private String nombreArchivo;
    private int cantidadCoincidencias;

    public ResultadoCoincidencia(String nombreArchivo, int cantidadCoincidencias) {
        this.nombreArchivo = nombreArchivo;
        this.cantidadCoincidencias = cantidadCoincidencias;
    }

    public int getCantidadCoincidencias() {
        return this.cantidadCoincidencias;
    }

    public String toString() {
        return this.nombreArchivo + ' ' + this.cantidadCoincidencias + ' ' + "veces";
    }
}
