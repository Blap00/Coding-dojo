package listaDeExcepciones;

import java.util.ArrayList;

public class ListaExcepcionMain {
    public static void main(String[] args) {
        // Crear el ArrayList con números y cadenas
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("Hola Mundo");
        myList.add(48);
        myList.add("Adios Mundo");

        // Crear una instancia de ListaExcepciones
        ListaExcepcion listaExcepciones = new ListaExcepcion();

        // Verificar la lista e imprimir los mensajes de error
        listaExcepciones.verificarLista(myList);
    }
}
