package binaryTree;

import java.util.ArrayList;

public class Tree<T> {
    Node<T> root;

    public Tree(){}

    public Tree(T root){
        this.root= new Node<T>(root);
    }


    public void addNodeHere(Node<T> newNode){
        if (this.root==null){
            this.root = newNode;
        }
        else{
            Node<T> temp = this.root;
            while (true){
                if (((Comparable<T>) temp.getValue()).compareTo(newNode.getValue())<0) {
                    if (temp.getRightSon()!=null){
                        temp = temp.getRightSon();
                    }
                    else{
                        temp.setRightSon(newNode);
                        break;
                    }
                }
                else{
                    if (temp.getLeftSon()!=null){
                        temp = temp.getLeftSon();
                    }
                    else{
                        temp.setLeftSon(newNode);
                        break;
                    }
                }
            }
        }
        setHeights(this.root);
    }

    public void setHeights(Node<T> node){
        if (node != null){
            setHeights(node.getLeftSon());
            height(node);
            setHeights(node.getRightSon());
        }
    }
    
    public void height(Node<T> node){
       if (node!=null){
            int left=0, right=0;
            if (node.getLeftSon()==null) left = -1;
            else left = node.getLeftSon().getHehight();
            if (node.getRightSon()==null) right = -1;
            else right = node.getRightSon().getHehight();
            node.setHeight(Math.max(left, right)+1);
       }
    }

    public void addNodeHere(T newNode){
        this.addNodeHere(new Node<T>(newNode));
    }

    public void BFS(Node<T> node){
        Queue<T> myQueue = new Queue<T>();
        int currentLevel = 0;
        if  (node != null){
            myQueue.push(node);
            Node<T> temp = node;
            while(!myQueue.empty()){
                if (temp.getLeftSon()!=null){
                    myQueue.push(temp.getLeftSon());
                }
                if (temp.getRightSon()!=null){
                    myQueue.push(temp.getRightSon());
                }
                Node<T> popped = myQueue.pop();
                if (heightOfNode(popped.getValue(), this.root, 0)==currentLevel){
                    currentLevel++;
                    System.out.println("Nivel: "+currentLevel);
                }
                System.out.println(popped.getValue());
                temp = temp.getNode();
            }
        }
    }

    public void BFS(){
        if (this.root!=null){
            Queue<T> myQueue = new Queue<T>();
            myQueue.push(this.root);
            this.BFSRecursive(myQueue);
        }
    }

    private void BFSRecursive(Queue<T> myQueue){
            if (myQueue.empty()==true){
                return;
            }
            Node<T> temp = myQueue.front();
            System.out.print(temp.getValue()+" ");
            myQueue.pop();
            if (temp.getLeftSon()!=null){
                myQueue.push(temp.getLeftSon());
            }
            if (temp.getRightSon()!=null){
                myQueue.push(temp.getRightSon());
            }
            this.BFSRecursive(myQueue);
    }

    public void inOrder(){
        this.ordered(this.root);
    }

    public void ordered(Node<T> node){
        if (node != null){
            ordered(node.getLeftSon());
            System.out.println(node.getValue());
            ordered(node.getRightSon());
        }
    }

    public void preOrder(){
        this.preOrdered(this.root);
    }

    public void preOrdered(Node<T> node){
        if (node != null){
            System.out.println(node.getValue());
            this.preOrdered(node.getLeftSon());
            this.preOrdered(node.getRightSon());
        }
    }

    public void postOrder(){
        this.postOrdered(this.root);
    }

    public void postOrdered(Node<T> node){
        if (node != null){
            this.postOrdered(node.getLeftSon());
            this.postOrdered(node.getRightSon());
            System.out.println(node.getValue());
        }
    }

    public void callSearch(T value){
        this.search(this.root, value);
    }

    public boolean search(Node<T> node, T value){
        while (node!=null && node.getValue()!=value){
            if (((Comparable<T>) node.getValue()).compareTo(value)>0) {
                node = node.getLeftSon();
            }
            else{
                node = node.getRightSon();
            }
        }
        if (node==null){
            return false;
        }
        return true;
    }

    public int heightOfTree(Node<T> node){
        if (node==null){
            return 0;
        }
        else{
            int heightLeft = heightOfTree(node.getLeftSon());
            int heightRight = heightOfTree(node.getRightSon());
            if (heightLeft>heightRight) {
                return heightLeft+1;
            }
            else{
                return heightRight+1;
            }
        }
    }

    public int heightOfNode(T valueOfNode, Node<T> node, int height){
        if (node==null){
            return 0;
        }
        if (node.compareTo(valueOfNode)==0){
            return height;
        }
        int lvl = heightOfNode(valueOfNode, node.getLeftSon(), height+1);
        if (lvl!=0){
            return lvl;
        }
        return heightOfNode(valueOfNode, node.getRightSon(), height+1);
    }

    public Node<T> findSuccessor(Node<T> node){
        if (node.getLeftSon()==null){
            return node;
        }
        node = findSuccessor(node.getLeftSon());
        return node;
    }

    public Node<T> deleteSuccessor(Node<T> node){
        if (node.getLeftSon() == null){
            return node.getRightSon();
        }
        node.setLeftSon(deleteSuccessor(node.getLeftSon()));
        return node;
    }

    public Node<T> deleteNode(Node<T> node, T value){
        if (node == null){
            return null;
        }
        if (node.compareTo(value)>0){
            node.setLeftSon(deleteNode(node.getLeftSon(), value));
            System.out.println("");
        }
        if (node.compareTo(value)<0){
            node.setRightSon(deleteNode(node.getRightSon(), value));
            System.out.println("");
        }
        if (node.compareTo(value)==0){
            if (node.getRightSon()==null){
                return node.getLeftSon();
            }
            if (node.getLeftSon()==null){
                return node.getRightSon();
            }
            Node<T> temp = node;
            if (node == this.root){
                this.root = findSuccessor(temp.getRightSon());
                this.root.setRightSon(deleteSuccessor(temp.getRightSon()));
                this.root.setLeftSon(temp.getLeftSon());
            }
            else{
                node = findSuccessor(temp.getRightSon());
                node.setRightSon(deleteSuccessor(temp.getRightSon()));//no puede haber mas a la izquierda, porque ese sería el menor que estaría en node
                node.setLeftSon(temp.getLeftSon());
            }
        }
        setHeights(this.root);
        return node;
    }
}
