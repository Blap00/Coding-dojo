package com.CodingDojo.ListaSimpleEnlazada;
//Crear una clase ListTestes como la anterior.
public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(3);//AÑADE EL DATO
        sll.add(4);//AÑADE EL DATO
        sll.add(10);//AÑADE EL DATO
        sll.add(5);//AÑADE EL DATO
        sll.add(15);//AÑADE EL DATO
        sll.add(2);//AÑADE EL DATO
        sll.remove();//REMUEVE EL ULTIMO DATO
        sll.remove();//REMUEVE EL ULTIMO DATO
        sll.printValues(); //IMPRIMIRA LOS VALORES ACTUALES EN EL NODO DE SLL
//        Implementar un método find(int) que retornará el primer nodo con el valor dado en los parámetros.
        sll.head.find(10); //ENCUENTRA E IMPRIME EL VALOR
//        Implementar un método removeAt(int) que removerá un nodo después de n nodos, donde n es el parámetro. 
//        Por ejemplo, si n es 0 removerá el primer nodo, si n es 1 removerá el segundo nodo. Similar a los arrays.
        sll.head.removeAt(2);//ELIMINARA EL VALOR EN LA POSICION DESEADA
        System.out.println("________-------------_________");
        sll.printValues();//IMPRIMIRA LOS VALORES ACTUALES EN EL NODO DE SLL
    }
}
