public class Stack<T> {
    Node<T> top;
    public Stack(){
        this.top = null;
    }

    public Stack(T topValue){
        this.top = new Node<T>(topValue);
    }
    public void push(Node<T> newNode){
        Node<T> temp = this.top;
        this.top = newNode;
        this.top.setNext(temp);
    }
    public void push(T newValue){
        Node<T> temp = this.top;
        this.top = new Node<T>(newValue);
        this.top.setNext(temp);
    }
    public T pop(){
        if (this.top == null){
            Integer a= -1;
            return (T)a;
        }
        Node<T> temp = this.top;
        this.top = this.top.getNode();
        return temp.getValue();
    }
}
