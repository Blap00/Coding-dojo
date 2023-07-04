package mapaDeHashmatique;

import java.util.HashMap;

public class Hashmatique {
    public static void main(String[] args) {
        // Crear el tracklist HashMap
        HashMap<String, String> trackList = new HashMap<>();

        // Agregar canciones al tracklist
        trackList.put("Canción original", "Letra de la canción: Como funcionaran los HASHMAP?"); // Agregar la canción original con su letra
        trackList.put("Canción unica", "Letra de la canción: No lo averiguo al 100 aún"); // Agregar una canción única con su letra
        trackList.put("Canción Especial", "Letra de la canción: Pero estoy seguro que voy cerca"); // Agregar una canción especial con su letra
        trackList.put("Canción Tengo hambre", "Letra de la canción: Pero tengo demasiado sueño:c"); // Agregar una canción de "Tengo hambre" con su letra

        // Extraer una canción por su título
        String tituloCancion = "Canción unica"; // Definir el título de la canción que se desea extraer
        String letraCancion = trackList.get(tituloCancion); // Obtener la letra de la canción del tracklist utilizando el título
        System.out.println("Letra de la canción \"" + tituloCancion + "\": " + letraCancion); // Imprimir la letra de la canción

        // Imprimir todos los nombres de las pistas y las letras
        System.out.println("Tracklist:");
        for (String titulo : trackList.keySet()) { // Iterar a través de las claves del tracklist
            String letra = trackList.get(titulo); // Obtener la letra de la canción utilizando el título como clave
            System.out.println(titulo + ": " + letra); // Imprimir el título de la canción y su letra
        }
    }
}
	