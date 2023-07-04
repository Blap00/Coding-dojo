package com.CodingDojo.ListaSimpleEnlazada;

public class Node {
	public int value;
	public Node next;

	public Node(int value) {
		//Establecer en el método constructor value con un número dado y next de tipo Nodo en null.
		this.value = value;
		this.next = null;
	}
	public void add(int value) {
		Node newNode = new Node(value);
		if (next == null) {
			next = newNode;
		} else {
			Node runner = next;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}
//	Implementar un método find(int) que retornará el primer nodo con el valor dado en los parámetros.
	public Node find(int value) {
		if (next == null) {
			return null;
		} else {
			Node runner = next;
			while (runner != null) {
				if (runner.value == value) {
					System.out.println("Encontrado el valor de; "+value);
					return runner;
				}
				runner = runner.next;
			}
			System.out.println("No se ha encontrado el valor de; "+value);
			return null;
		}
	}
//	Implementar un método removeAt(int) que removerá un nodo después de n nodos, donde n es el parámetro. 
//	Por ejemplo, si n es 0 removerá el primer nodo, si n es 1 removerá el segundo nodo. Similar a los arrays.
	public void removeAt(int index) {
		if (next == null || index < 0) {
		} else if (index == 0) {
			next = next.next;
		} else {
			Node runner = next;
			int count = 0;
			while (runner != null && count < index - 1) {
				runner = runner.next;
				count++;
			}
			if (runner != null && runner.next != null) {
				runner.next = runner.next.next;
			}
		}
	}

	
}
