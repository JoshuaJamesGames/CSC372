/*
LinkedList for CSC372 Portfolio Project
using Generic Type T

Sortable using a comparator (milesPerGallon)
*/

public class LinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    //No default Constructor

    //add a node
    public void add(T newNode){
        if (head == null){
            Node<T> firstNode = new Node<T>(newNode);
            head = firstNode;
            tail = firstNode;
        }else{
            Node<T> nextNode = new Node<T>(newNode);
            tail = nextNode;
            tail.setNext(nextNode);
        }
    }
    
    //getFirst

    //getLast

    //size

    //sort (with comparator)
}

class Node<T>{
    
    private T thisNode;
    private Node<T> nextNode;

    Node(T thisNode){
        this.thisNode = thisNode;
    }

    public void setNext(Node<T> nextNode){
        this.nextNode = nextNode;
    }
}


