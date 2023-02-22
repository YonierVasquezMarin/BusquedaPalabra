package archivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
    private String nombreConExtension;
    private String ruta;

    public Archivo(String nombreConExtension, String ruta) {
        this.nombreConExtension = nombreConExtension;
        this.ruta = ruta;
    }

    public ResultadoCoincidencia obtenerCoincidenciasPalabra(String palabraABuscar) {
        String rutaCompleta = ruta + '\\'+ nombreConExtension;

        try {
            File archivo = new File(rutaCompleta);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int contador = 0;
            while((linea=br.readLine())!=null) {
                // separar el texto en palabras
                String[] palabras = linea.split(" ");

                // Retirar signos de puntuacion
                ArrayList<String> palabrasSinSignos = new ArrayList<>();
                for (String palabra : palabras) {
                    String palabraSinSignos = palabra.replaceAll("[^a-zA-Záéíóú]", "");
                    palabrasSinSignos.add(palabraSinSignos);
                }

                for (String palabra : palabrasSinSignos) {
                    if (palabra.equals(palabraABuscar)) {
                        contador++;
                    }
                }
            }
            br.close();
            return new ResultadoCoincidencia(this.nombreConExtension, contador);
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
            return null;
        }
    }
}
