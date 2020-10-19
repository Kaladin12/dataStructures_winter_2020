package doublyLinkedList;

public class Queue<T> {
    Node<T> top;
    public Queue(){
        this.top = null;
    }

    public Queue(T topValue){
        this.top = new Node<T>(topValue);
        this.top.setNext(this.top);
        this.top.setPrev(this.top);
    }

    public void push(Node<T> newNode){
        if (this.top!=null){
            Node<T> temp =  this.top;
            while (temp.getNext()!=this.top){
                temp = temp.getNext();
            }
            newNode.setNext(this.top);
            this.top.setPrev(newNode);
            newNode.setPrev(temp);
            temp.setNext(newNode);
        }
        else{
            this.top = newNode;
            this.top.setNext(this.top);
            this.top.setPrev(this.top);
        }
    }

    public void push(T newvalue){
        this.push(new Node<T>(newvalue));
    }

    public T pop(){
        if (this.top == null || this.top.getNext() == this.top){
            this.top = null;
            Integer a= -1;
            return (T)a;
        }
        T value = this.top.getValue();
        Node<T> temp = this.top.getPrev();
        this.top = this.top.getNext();
        temp.setNext(this.top);
        this.top.setPrev(temp);
        return value;
    }

    public int size(){
        int size = 0;
        if (this.top!=null){
            Node<T> temp =  this.top.getNext();
            size+=1;
            if (this.top!=temp){
                while (temp!=this.top){
                    size+=1;
                    temp = temp.getNext();
                }
            }
        }
        return size;
    }

    public Boolean empty(){
        if (this.top!=null){
            return false;
        }
        return true;
    }

    public T front(){
        if (this.top != null){
            return this.top.getValue();
        }
        Integer a = -1;
        return (T) a;
    }

    public T peek(int elements){
        Node<T> temp = this.top;
        for (int i = 0; i < elements; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }
}
