/*
LinkedList for CSC372 Portfolio Project
using Generic Type T so it may function with any object

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

    //addAll - also takes a generic array
    public void addAll(T[] array){
        
        int size = 0;

        while(size < array.length){
            this.add(array[size++]);
            
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

    //clear
    public void clear(){
        this.head = null;
        this.tail = null;
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

    //toString for easy printing - relies toString override within the object
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
  
}

//Nodes of generic type compose the linked list
//Each node links to the next - typically noncontiguous
//This is a singly linked list that only connects forward
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


