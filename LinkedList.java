/* 
 * Katie Bernard
 * 10/3/2022
 */
import java.util.Iterator;    // defines the Iterator interface
import java.util.ArrayList;   
import java.util.Collections; // contains a shuffle function
public class LinkedList<T> implements Iterable<T>{

    private class Node{
        T data;
        Node next;
        
        public Node(T data){
            this.data = data;
            next = null;
        }

        public Node(T data, Node next){
            this.data = data;
            this.next = next;
        }

        public T getData(){
            return data;
        }

        public Node getNext(){
            return next;
        }

        public void setNext(Node newNext){
            next = newNext;
        }
    }

    int size; //# objects in list
    Node head; //first thing in list

    public LinkedList(){
        size = 0;
        head = null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{ return false;}
    }    

    public void clear(){
        head = null;
        size = 0;
    }

    //Implementing iterator
    private class LLIterator implements Iterator<T>{
        Node nextNode;
        public LLIterator(Node head){
            //The constructor for LLIterator given the head
            nextNode = head;
        }
        public boolean hasNext(){
            //returns true if there are still values to traverse (if the current node reference is not null)
            if(nextNode == null){
                return false;
            } else{return true;}
        }
        public T next(){
            Node nextTemp = nextNode;
            nextNode = nextNode.getNext();
            return nextTemp.getData();
        }
        public void remove(){

        }
            
        }
    
    // Return a new LLIterator pointing to the head of the list
    public Iterator<T> iterator() {
        return new LLIterator( this.head );
        }

    public ArrayList<T> toArrayList(){
        ArrayList<T> myArray = new ArrayList<T>();
        Node walker = head;
        for(int i = 0; i< size - 1; i++){
            walker = walker.getNext();
            myArray.add(walker.getData());
        }
        return myArray;


        }


    //This will remove from the front
    public T remove(){
        //change head to the second guy in the list. The first guy might still be there, but we can never access it
        T toReturn = head.getData();
        head = head.getNext();
        size --;
        return toReturn;
    }

    public T remove(int index){
        Node walker = head;
        for(int i = 0; i< index - 1; i++){
            walker = walker.getNext();
        } // after this for loop finishes, walker is sittng at position index -1
        Node next = walker.getNext();
        walker.setNext(next.getNext());
        return next.getData();
    }

    public T get(int index){
        Node walker = head;
        for(int i = 0; i< index - 1; i++){
            walker = walker.getNext();
        }
        Node next = walker.getNext();
        return next.getData();
    }

    public void add(T item){
        Node newNode = new Node(item);

        newNode.setNext(head);

        head = newNode;

        size++;
    }

    public void add(int index, T item){
        if(index == 0){
            add(item);
            return;
        }
        Node walker = head;
        for(int i = 0; i< index - 1; i++){
            walker = walker.getNext();
        } // after this for loop finishes, walker is sittng at position index -1

        Node newNode = new Node(item);

        newNode.setNext(walker.getNext());
        walker.setNext(newNode);

        size++;
    }

    public boolean contains( Object o){
        Node walker = head;
        boolean toReturn = false;
        for(int i = 0; i<size; i++){
            walker = walker.getNext();
            if(walker == null){
                toReturn = true;
            }
        }
        return toReturn;

    }

    public boolean equals(Object o){
        if (!(o instanceof LinkedList)){
            return false;
        }
        // If I have reached this line, o must be a LinkedList
        LinkedList oAsALinkedList = (LinkedList) o;
        // Now I have a reference to something Java knows is a LinkedList!
        boolean toReturn = true;
        for(int i = 0; i<size; i++){
            if(get(i) != oAsALinkedList.get(i)){
                return false;
            }
        }
        return toReturn;
    }
}