public class linkedList<T> {
    Node<T> top, tail;
    public linkedList(){
        this.tail = null;
        this.top = null;
    }

    public linkedList(T value){
        this();
        this.top = new Node<T>(value);
    }

    public void pushBack(Node<T> newNode){
        if (this.top == null){
            this.top = newNode;
            this.tail = this.top;
        }
        else{
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
    }

    public void pushBack(T newValue){
        if (this.top == null){
            this.top = new Node<T>(newValue);
            this.tail = this.top;

        }
        else if (this.tail == null){
            this.tail= new Node<T>(newValue);
            this.top.setNext(this.tail);
        }
        else{
            Node<T> temp = new Node<T>(newValue);
            this.tail.setNext(temp);
            this.tail = temp;
        }
    }

    public void pushFront(T newValue){
        if (this.top == null){
            this.top = new Node<T>(newValue);
        }
        else{
            Node<T> newNode = new Node<T>(newValue);
            if (this.tail ==  null){
                this.tail = this.top;
            }
            newNode.setNext(this.top);
            this.top = newNode;
        }
    }

    public T keyTop(){
        if (this.top !=null){
            return this.top.getValue();
        }
        else{
            Integer a = -0;
            return (T)a;
        }
    }

    public T keyBack(){
        if (this.tail != null){
            return this.tail.getValue();
        }
        else{
            Integer a = -0;
            return (T)a;
        }
    }

    public T popBack(){
        if (this.top == null){
            Integer a = -0;
            return (T)a;
        }
        if (this.top == this.tail){
            T value = this.top.getValue();
            this.top = this.tail = null;
            return value;
        }
        Node<T> temp = this.top;
        while (temp.getNode() != this.tail) {
            temp =  temp.getNode();
        }
        Node<T> temp2 = this.tail;
        this.tail = temp;
        return temp2.getValue();
        
    }

    public T popFront(){
        if (this.top == null){
            Integer a = -0;
            return (T)a;
        }
        if (this.top == this.tail){
            T value = this.top.getValue();
            this.top = this.tail = null;
            return value;
        }
        T value = this.top.getValue();
        this.top = this.top.getNode();
        return value;

    }

    public Boolean find(T value){
        //System.out.println(this.top.getValue());
        Node<T> temp = this.top;
        while(temp.getValue()!=null){
            if (temp.getValue()==value){
                return true;
            }
            if (this.tail == temp){
                break;
            }
            temp = temp.getNode();
        }
        return false;
    }

    public void erase(){
        this.top = this.tail = null;
    }

    public Boolean empty(){
        if (this.top == null){
            return true;
        }
        return false;
    }

    public void addBefore(Integer node, T value){
        if (this.top == null){
            this.top = new Node<T>(value);
        }
        if (node==0){
            Node<T> temp = new Node<T>(value);
            temp.setNext(this.top);
            this.top = temp;
            System.out.println(this.top.getValue()+" "+ this.top.getNode().getValue());
        }
        Integer c = 0;
        Node<T> temp = this.top;
        while(c+1<node){
            c++;
            temp = temp.getNode();
        }
        Node<T> temp2 = temp.getNode();
        temp.setNext(new Node<T>(value));
        temp.getNode().setNext(temp2);
    }
}
