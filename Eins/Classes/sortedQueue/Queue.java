package sortedQueue;

public class Queue<T> {
    NodeComp<T> top;
    public Queue(){
        this.top = null;
    }

    public Queue(T topValue){
        this.top = new NodeComp<T>(topValue);
        this.top.setNext(this.top);
    }

    public void compara(){
        System.out.println(this.top.compareTo(this.top.getNode()));
    }

    public void queueInOrder(NodeComp<T> newNode){
        if (this.top!=null){
            NodeComp<T> temp =  this.top;
            if (temp.getNode()==this.top){ //Si el top apunta hacia sí mismo 
                if (this.top.compareTo(newNode)>0){
                    this.top.setNext(newNode);
                    newNode.setNext(this.top);
                    this.top = newNode;
                }
                else{
                    this.top.setNext(newNode);
                    newNode.setNext(this.top);
                }
            }
            else{
                while (temp.getNode()!=this.top){ //Hay mas elementos en la queue
                    if (temp.compareTo(newNode)>0){ //temp es mayor a newNode
                        NodeComp<T> newTemp = this.top;
                        while (newTemp.getNode()!=temp){
                            newTemp = newTemp.getNode();
                        }
                        newNode.setNext(temp);
                        newTemp.setNext(newNode);
                        if (temp == this.top){
                            this.top = newNode;
                        }
                        break;
                    }
                    else if (temp.compareTo(newNode)<0){ //temp es menor a newNode
                        NodeComp<T> nodeTemp = this.top;
                        while(temp.compareTo(newNode)<0 && temp.getNode()!=this.top ){
                            nodeTemp = temp;
                            temp = temp.getNode();
                            
                        }
                        if (temp.getNode()==this.top && temp.compareTo(newNode)<0){
                            newNode.setNext(this.top);
                            temp.setNext(newNode);
                        }
                        else{
                            newNode.setNext(temp);
                            nodeTemp.setNext(newNode);
                        }
                        break;
                    }
                    temp = temp.getNode();
                }
            }
        }
        else{
            this.top = newNode;
            this.top.setNext(this.top);
        }
    }

    public void queueInOrder(T newvalue){
        this.queueInOrder(new NodeComp<T>(newvalue));
    }

    public T pop(){
        if (this.top == null || this.top.getNode() == this.top){
            this.top = null;
            Integer a= -1;
            return (T)a;
        }
        T value = this.top.getValue();
        NodeComp<T> temp = this.top.getNode();
        while (temp.getNode() != this.top){
            temp = temp.getNode();
        }
        this.top = this.top.getNode();
        temp.setNext(this.top);
        return value;
    }

    public int size(){
        int size = 0;
        if (this.top!=null){
            NodeComp<T> temp =  this.top.getNode();
            size+=1;
            if (this.top!=temp){
                while (temp!=this.top){
                    size+=1;
                    temp = temp.getNode();
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

    public T Peek(int elements){
        NodeComp<T> temp = this.top;
        for (int i = 0; i < elements; i++) {
            temp = temp.getNode();
        }
        return temp.getValue();
    }
}
/*if (temp.compareTo(newNode)<0 && temp.getNode().compareTo(newNode)>0){ //Hay uno mayor y uno menor, el newNode v entre ellos
                    newNode.setNext(temp.getNode());
                    temp.setNext(newNode);
                    break;
                }
                else  */