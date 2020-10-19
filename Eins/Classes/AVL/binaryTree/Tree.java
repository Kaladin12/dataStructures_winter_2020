package AVL.binaryTree;
public class Tree<T> {
    Node<T> root;

    public Tree(){}

    public Tree(T root){
        this.root= new Node<T>(root);
    }

    public void insertRecursive(T value){
        if (this.root==null){
            this.root = new Node<T>(value);
        }
        else{
            this.root = insertRecursive(this.root, value);
        }
    }

    private Node<T> insertRecursive(Node<T> node, T value){
        if (node==null){
            node = new Node<T>(value);
            height(node);
            return node;
        }
        if (node.compareTo(value)>=0){
            node.setLeftSon(insertRecursive(node.getLeftSon(), value));
            setHeights(node);
        }
        if (node.compareTo(value)<0){
            node.setRightSon(insertRecursive(node.getRightSon(), value)); 
            setHeights(node);
        }       
        setHeights(node);
        //int difference = rebalance(node);
        if (rebalance(node)>0){
            if (node.getLeftSon().compareTo(value)>0){
                return rotateRight(node);
            }
            if (node.getLeftSon().compareTo(value)<0){
                node.setLeftSon(rotateLeft(node.getLeftSon()));
                return rotateRight(node);
            }
        }
        if (rebalance(node)<0){
            if (node.getRightSon().compareTo(value)<0){
                return rotateLeft(node);
            }
            if (node.getRightSon().compareTo(value)>0){
                node.setRightSon(rotateRight(node.getRightSon()));
                return rotateLeft(node);
            }
        }
        setHeights(node);
        return node;
    }

    public Node<T> rotateRight(Node<T> rootNode){
        Node<T> temp1 = rootNode.getLeftSon();
        Node<T> temp2 = temp1.getRightSon();
        temp1.setRightSon(rootNode);
        temp1.getRightSon().setLeftSon(temp2);
        rootNode = temp1;
        return temp1;
    }

    public Node<T> rotateLeft(Node<T> rootNode){
        Node<T> temp1 = rootNode.getRightSon();
        Node<T> temp2 = temp1.getLeftSon();
        temp1.setLeftSon(rootNode);
        temp1.getLeftSon().setRightSon(temp2);
        rootNode = temp1;
        return temp1;
    }

    public int rebalance(Node<T> node){
        if (node != null){
            int left, right;
            if (node.getLeftSon()==null) left = -1;
            else left = node.getLeftSon().getHehight();
            if (node.getRightSon()==null) right = -1;
            else right = node.getRightSon().getHehight();
            if (Math.abs(left-right)>1){
                return  left-right;
            }
        }
        return 0;
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

    public Node<T> search(Node<T> node, T value){
        while (node!=null && node.getValue()!=value){
            if (((Comparable<T>) node.getValue()).compareTo(value)>0) {
                node = node.getLeftSon();
            }
            else{
                node = node.getRightSon();
            }
        }
        if (node==null){
            return null;
        }
        return node;
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
            return node.getRightSon(); //null si no hay derecho y derecho si si lo hay
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
            height(node);
        }
        if (node.compareTo(value)<0){
            node.setRightSon(deleteNode(node.getRightSon(), value));
            height(node);
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
        height(node);
        return node;
    }
}
