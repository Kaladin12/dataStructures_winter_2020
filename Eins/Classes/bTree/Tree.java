package bTree;
import java.util.ArrayList;
import bTree.queue.*;

public class Tree<T> {
    Node<T> root;
    int degree;
    Stack<T> daStack =new Stack<T>() ;
    boolean isRootEmpty;
    public Tree(){}
    public Tree(int degree ){
        this.root = null;
        this.degree = degree;
        this.isRootEmpty = true;
    }

    public void callInsert(T value){
        Node<T> temp = new Node<T>(this.degree);
        //this.daStack = new Stack<Node<T>>(temp);
        this.insert(value, this.root);
    }

    public void insert(T value, Node<T> node){
        if (this.root==null){
            this.root = new Node<T>(this.degree);
            this.root.setValue(value, 0);
            this.isRootEmpty = false;
            this.daStack.pop();
            this.daStack.push(this.root);
        }
        else{
            this.daStack.push(node);
            if (node.hasChildren()){
                int i=0;
                while (i<node.keys.size() && node.callComparable(i, value)<0){
                    i++;
                }
                Node<T> child = node.getChild(i);
                this.insert(value, child);
                return;
                /*for (int i = 0; i < node.keys.size(); i++) {
                    if (node.callComparable(i, value)<0 && node.keys.size()>=i+1){
                        break;
                    }
                }
                for (Node<T> child : node.getChildren()) {
                    System.out.println(child.callComparable(0,value)); 
                    // 
                    
                    //if (child.callComparable(0, value)<=0 && child.callComparable(child.keys.size()-1, value)>=0){
                    //    
                    //}
                    

                } */
            }
            insertV(node, value);
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
           this.partitionNode(node, this.findPosOfPart(node));
        }
       // System.out.println();
    }

    public int findPosOfPart(Node<T> node){
        //System.out.println((this.degree+1)+"  "+(int) (this.degree+1)/2 );
        return (int) (this.degree)/2;  
    }

    public void partitionNode(Node<T> node, int posOfPart){ 
        if (node==this.root){
            T temp = node.getValue(posOfPart);
            Node<T> left = new Node<T>(this.degree), right = new Node<T>(this.degree);
            for (int i = 0; i < posOfPart; i++) {
                left.setValue(node.getValue(i), i);
            }
            int j = node.keys.size() - posOfPart-1, k=0;//, i = node.keys.size()-posOfPart;
            for (int i = j; i < node.keys.size(); i++) {
                right.setValue(node.getValue(i), k);
                k++;
            }
            this.root = new Node<T>(this.degree);
            this.root.setValue(temp, 0);
            this.root.children = new ArrayList<Node<T>>(0);//(this.degree+1);
            ArrayList<Node<T>> children = node.getChildren();
            this.root.setChild(left, 0);
            this.root.setChild(right, 1);
            k = 0;
            if (children!=null){
                this.root.children.get(0).children = new ArrayList<Node<T>>(0);
                this.root.children.get(1).children = new ArrayList<Node<T>>(0);
                for (int i = 0; i < children.size(); i++) {
                    if (i<=posOfPart){
                        this.root.children.get(0).setChild(children.get(i) , i);
                    }
                    else{
                        this.root.children.get(1).setChild(children.get(i),k ); k++;
                    }
                }
            }
            if (this.root.keys.size()>this.degree){
                this.partitionNode(this.root, this.findPosOfPart(this.root));
                //this.partitionNode(node, this.findPosOfPart(node));
            };
        }
        else  {
            T temp = node.getValue(posOfPart);
            Node<T> left = new Node<T>(this.degree), right = new Node<T>(this.degree);
            //ArrayList<Node<T>> futureChildren = new ArrayList<Node<T>>(this.degree+1);
            for (int i = 0; i < posOfPart; i++) {
                left.setValue(node.getValue(i), i);
            }
            int j = node.keys.size() - posOfPart -1, k=0;//, i = node.keys.size()-posOfPart;
            for (int i = j; i < node.keys.size(); i++) {
                right.setValue(node.getValue(i), k);
                k++;
            }
            this.daStack.pop();
            Node<T> tempTop = this.daStack.top;
            int i=0;
            while (i<tempTop.keys.size() && tempTop.callComparable(i, temp)<0){
                i++;
            }
            tempTop.setValue(temp, i);
            ArrayList<Node<T>> children = tempTop.getChildren();
            tempTop.setChild(left, i);
            tempTop.setChild(right, i+1);
            if (children!=null){System.out.println();}
            if (tempTop.keys.size()>this.degree){
                this.partitionNode(tempTop, this.findPosOfPart(tempTop));
                //this.partitionNode(node, this.findPosOfPart(node));
            }
            //
        }
        /*else{
            T temp = node.getValue(posOfPart);
            Node<T> left = new Node<T>(this.degree), right = new Node<T>(this.degree);
            ArrayList<Node<T>> futureChildren =  node.getChildren();
            for (int i = 0; i < posOfPart; i++) {
                left.setValue(node.getValue(i), i);
            }
            int j = node.keys.size() - posOfPart + 1, k=0;//, i = node.keys.size()-posOfPart;
            for (int i = j; i < node.keys.size(); i++) {
                right.setValue(node.getValue(i), k);
                k++;
            }
            node = new Node<T>(this.degree);
            node.setValue(temp, 0);
            node.children = new ArrayList<Node<T>>(this.degree+1);
            node.setChild(left, 0);
            node.setChild(right, 1);
            Node<T> tempTop = this.daStack.top;
            this.daStack.pop();
            partitionNode(tempTop, posOfPart);
        } */
    }

}


    