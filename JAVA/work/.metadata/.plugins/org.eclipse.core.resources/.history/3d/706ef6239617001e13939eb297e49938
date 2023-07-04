package mapaDeHashmatique;

import java.util.HashMap;
import java.util.Map;

public class Hashmatique {
    public static void main(String[] args) {
        // Crear el tracklist HashMap
        Map<String, String> trackList = new HashMap<>();

        // Agregar canciones al tracklist
        trackList.put("Habra que probar!", "Letra de la canción uno porque si!");
        trackList.put("funcionara?", "Letra de la canción tengo sueño!");
        trackList.put("Como se usa esto?", "Letra de la canción tambien hambre");
        trackList.put("Canciones", "Letra de la canción larga");

        // Extraer una canción por su título
        String tituloCancion = "funcionara?";
        String letraCancion = trackList.get(tituloCancion);
        System.out.println("Letra de la canción \"" + tituloCancion + "\": " + letraCancion);

        // Imprimir todos los nombres de las pistas y las letras
        System.out.println("Tracklist:");
        for (Map.Entry<String, String> entry : trackList.entrySet()) {
            String titulo = entry.getKey();
            String letra = entry.getValue();
            System.out.println(titulo + ": " + letra);
        }
    }
}