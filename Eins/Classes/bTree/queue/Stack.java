package bTree.queue;

import bTree.Node;

public class Stack<T> {
    public Node<T> top;
    public Stack(){
        this.top = null;
    }

    public Stack(Node<T> topValue){
        this.top = topValue;
    }
    public void push(Node<T> node){
        if (this.top == null){
            this.top = node;
        }else{
            Node<T> temp = this.top;
            this.top = node;
            this.top.setNext(temp);
        } 
    }
    public void push(T newValue){
        //RedBlackTree.Node<T> temp = this.top;
        push(new Node<T>(newValue));
        //this.top.setNext(temp);
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