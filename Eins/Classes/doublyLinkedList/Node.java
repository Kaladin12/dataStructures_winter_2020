package doublyLinkedList;

public class Node<T> implements Comparable<Node<T>> {
    private T value;
    private Node<T> next, previous;

    public Node(T value){
        this.value = value;
        this.next = null;
        this.previous = null;
    }
    public Node(T value, Node<T> next){
        this(value);
        this.next = next;
    }

    public T getValue(){
        return this.value;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node<T> getNext(){
        return this.next;
    }

    public void setPrev(Node<T> prev){
        this.previous = prev;
    }

    public Node<T> getPrev(){
        return this.previous;
    }

    @Override
    public int compareTo(Node<T> nodo){
        //System.out.println(this.value.getClass().getSimpleName().getClass().toString());
        try {
            Integer temp = Integer.parseInt(this.toString());
            Integer temp2 = Integer.parseInt(nodo.getValue().toString());
            return temp.compareTo(temp2);
        } catch (Exception e) {
            
        }
        String temp = this.toString();
        String temp2 = nodo.getValue().toString();
        return temp.compareTo(temp2);
        
        //System.out.println("First: "+temp+", Second: "+temp2);
    }

    public String toString(){
        return this.value.toString();
    }

    
}
