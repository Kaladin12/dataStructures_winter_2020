package sortedQueue;

public class NodeComp<T> implements Comparable<NodeComp<T>> {
    private T value ;
    private NodeComp<T> next;

    public NodeComp(T value){
        this.value = value;
        this.next = null;
    }
    public NodeComp(T value, NodeComp<T> next){
        this(value);
        this.next = next;
    }

    public T getValue(){
        return this.value;
    }

    public void setNext(NodeComp<T> next){
        this.next = next;
    }

    public NodeComp<T> getNode(){
        return this.next;
    }

    @Override
    public int compareTo(NodeComp<T> nodo){
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
