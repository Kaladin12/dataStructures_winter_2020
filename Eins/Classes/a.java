/*public class a<T> {
    Node<T> top;
    public a(){
        this.top = null;
    }

    public a(T topValue){
        this.top = new Node<T>(topValue);
        this.top.setNext(this.top);
    }


    public void queueInOrder(Node<T> newNode){
        if (this.top!=null){
            Node<T> temp =  this.top;
            while (temp.getNode()!=this.top){
                temp = temp.getNode();
            }
            newNode.setNext(this.top);
            temp.setNext(newNode);
        }
    }

    public void queueInOrder(T newvalue){
        if (this.top!=null){
            Node<T> temp =  this.top;
            while (temp.getNode()!=this.top){
                temp = temp.getNode();
            }
            Node<T> newNode = new Node<T>(newvalue);
            newNode.setNext(this.top);
            temp.setNext(newNode);
        }
    }

    public T pop(){
        if (this.top == null){
            Integer a= -1;
            return (T)a;
        }
        T value = this.top.getValue();
        Node<T> temp = this.top.getNode();
        //System.out.println(this.top.getNode().getValue());
        while (temp.getNode() != this.top){
            temp = temp.getNode();
        }
        this.top = this.top.getNode();
        temp.setNext(this.top);
        return value;
    }

    public int size(){
        int size = 0;
        Node<T> temp =  this.top;
        if (this.top!=null){
            size+=1;
            while (temp.getNode()!=null){
                size+=1;
                temp = temp.getNode();
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

    public T Peek(int elements){
        Node<T> temp = this.top;
        for (int i = 0; i < elements; i++) {
            temp = temp.getNode();
        }
        return temp.getValue();
    }
}
class a {
    
}*/
