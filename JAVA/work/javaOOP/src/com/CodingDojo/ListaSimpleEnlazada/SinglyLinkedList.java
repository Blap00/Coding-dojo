package com.CodingDojo.ListaSimpleEnlazada;

public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
    	//Crear un método constructor para establecer head en null para los objetos de su SinglyLinkedList
        this.head = null;
    }
    //Los metodos de la SLL van aqui. Al principio, les mostraremos cómo agregar nodos a la lista.
    public void add(int value) {
        Node newNode = new Node(value); //Declara el valor "Value" como nuevo nodo
        if(head == null) { //Si la cabezera es NULL
            head = newNode; //La cabezera tendra el valor del nuevo nodo
        } else {
            Node runner = head; //Declara un node runner como Head
            while(runner.next != null) { //Si el siguiente valor de runner es distinto a NULL
                runner = runner.next; //Declaro el nodo runner como el siguiente valor
            }
            runner.next = newNode; //El siguiente valor de runner se establece como "newNode"
        }
    }    
//    Crear un método remove() que removerá un nodo del final de su lista.
    public void remove() {
        if (head.next == null) { //Si el siguiente valor de HEAD es igual a NULL
            head = null; //Se establece como NULL igual (No hace nada)
        } else {
            Node runner = head; //Declara el valor RUNNER como la cabezera
            while (runner.next != null) { //Mientras que el siguiente valor de runner sea distinto a null
                runner = runner.next; //se establece el valor como el siguiente valor
            }
            runner.next = null; //se restablece el siguiente valor de runner como null
        }
    }
//    Crear un método printValues() que mostrará en pantalla todos los valores de cada 
// 	  nodo de la lista en el mismo orden que fue creada.
    public void printValues() {
    	if(head != null) { //SI HEAD ES DISTINTO A NULL
    		Node runner = head; //ESTABLECE EL VALOR DE NODE RUNNER COMO HEAD
    		while(runner.next!=null) {//MIENTRAS EL SIGUIENTE VALOR DE RUNNER SEA DISTINTO A NULL
    			System.out.println(runner.value+" "); //IMPRIME EL VALOR ACTUAL DE RUNNER
    			runner = runner.next;//DECLARA RUNNER CON SU SIGUIENTE VALOR
    		}
    		runner.next= null; //ESTABLECE RUNNER.next COMO NULL
    	}
    }
}
