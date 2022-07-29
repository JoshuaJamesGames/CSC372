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
            
            tail.setNext(nextNode);
            tail = nextNode;
        }
    }

    //addAll
    public void addAll(T[] array){
        
        int size = array.length;

        while(size <= 0){
            this.add(array[size--]);
            
        }
    }
    
    //getFirst
    public Node<T> getFirst(){
        return head;
    }

    //getLast
    public Node<T> getLast(){
        return tail;
    }

    //size
    public int size(){

        Node<T> currentNode = getFirst();
        int size = 0;

        while(currentNode != null){
            size++;
            currentNode = currentNode.getNext();
        }

        return size;
    }

    //toArray
    //Needs to be supplied with an appropriately sized generic array
    public T[] toArray(T[] array){
        
        Node<T> currentNode = getFirst();
        int i = 0;

        while(currentNode != null){
            array[i++]= currentNode.get();
            currentNode = currentNode.getNext();
        }

        return array;
    }

    //toString
    @Override
    public String toString(){
        String nodeOutputs = "";
        Node<T> currentNode = getFirst();

        while(currentNode != null){
            nodeOutputs += "\n" + currentNode.get().toString();
            currentNode = currentNode.getNext();
        }


        return nodeOutputs;
    }

    //sort (with comparator)
}

class Node<T>{
    
    private T thisObject;
    private Node<T> nextNode;

    Node(T thisObject){
        this.thisObject = thisObject;
    }

    public T get(){
        return thisObject;
    }
    
    public void setNext(Node<T> nextNode){
        this.nextNode = nextNode;
    }

    public Node<T> getNext(){
        return nextNode;
    }


}


