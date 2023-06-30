package listaDeExcepciones;

import java.util.ArrayList;

public class ListaExcepcion {
	public void verificarLista(ArrayList<Object> lista) {
		// Intentar hacer cast a cada elemento e imprimir los mensajes de error
		for (int i = 0; i < lista.size(); i++) {
			try {
				int castedValue = (int) lista.get(i);
				System.out.println("El valor en el índice " + i + " es: " + castedValue);
			} catch (ClassCastException e) {
				System.out.println("Error en el índice " + i + ". El valor del objeto es: " + lista.get(i));
			}
		}
	}
}
