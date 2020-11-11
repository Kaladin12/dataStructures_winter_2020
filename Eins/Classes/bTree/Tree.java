package bTree;
import java.util.ArrayList;
import bTree.queue.*;

public class Tree<T> {
    Node<T> root;
    int degree;
    Stack<Node<T>> stackoooooo =new Stack<Node<T>>() ;
    boolean isRootEmpty;
    public Tree(){}
    public Tree(int degree ){
        this.root = null;
        this.degree = degree;
        this.isRootEmpty = true;
    }

    public void callInsert(T value){
        Node<T> temp = new Node<T>(0);
        //this.stackoooooo = new Stack<Node<T>>(temp);
        this.insert(value, this.root);
    }

    public void insert(T value, Node<T> node){

        if (this.root==null){
            this.root = new Node<T>(this.degree);
            this.root.setValue(value, 0);
            this.isRootEmpty = false;
            //this.stackoooooo.pop();
            //this.stackoooooo.push(this.root);
            //System.out.println();
        }
        else{
            //this.stackoooooo.push(this.root);
            if (node.hasChildren()){
                for (Node<T> child : node.getChildren()) { 
                    if (child.callComparable(0, value)<=0 && child.callComparable(child.keys.size()-1, value)>=0){
                        this.insert(value, child);
                        break;
                    }
                }
            }
            else{
                insertV(node, value);
            }
        }
    }

    public void insertV(Node<T> node,T value){
        int keysInNode = node.keys.size()-1;
        node.setValue(node.getValue(keysInNode), keysInNode+1);
        while (keysInNode>=0 && node.callComparable(keysInNode, value)>0){
            node.replaceValue(node.getValue(keysInNode), keysInNode+1);
            //System.out.println(node.callComparable(keysInNode, value)+"  "+ keysInNode);
            keysInNode--;
        }
        node.replaceValue(value, keysInNode+1);
        if (node.keys.size()>this.degree){
           //System.out.println(node.keys.size()); 
           //System.out.println(this.findPosOfPart(node));
           this.partitionNode(node, this.findPosOfPart(node));
        }
        System.out.println();
    }

    public int findPosOfPart(Node<T> node){
        return (int) (this.degree+1)/2;  
    }

    public void partitionNode(Node<T> node, int posOfPart){ 
        if (node==this.root){
            T temp = node.getValue(posOfPart);
            Node<T> left = new Node<T>(this.degree), right = new Node<T>(this.degree);
            for (int i = 0; i < posOfPart; i++) {
                left.setValue(node.getValue(i), i);
            }
            int j = node.keys.size() - posOfPart + 1, k=0;//, i = node.keys.size()-posOfPart;
            for (int i = j; i < node.keys.size(); i++) {
                right.setValue(node.getValue(i), k);
                k++;
            }
            this.root = new Node<T>(this.degree);
            this.root.setValue(temp, 0);
            this.root.children = new ArrayList<Node<T>>(this.degree+1);
            this.root.setChild(left, 0);
            this.root.setChild(right, 1);
        }
        else{

        }
    }
}


    