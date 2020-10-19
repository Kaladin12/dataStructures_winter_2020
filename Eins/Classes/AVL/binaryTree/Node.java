package AVL.binaryTree;

public class Node<T> implements Comparable<T> {
    private T value ;
    private Integer height=-1;
    private Node<T> leftSon, rightSon;
    private Node<T> next;

    public Node(T value){
        this.value = value;
        this.leftSon = null;
        this.rightSon = null;
        this.height  = -1;
        this.next = null;
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node<T> getNode(){
        return this.next;
    }

    public T getValue(){
        return this.value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void setHeight(Integer level){
        this.height = level;
    }

    public Integer getHehight(){
        return this.height;
    }

    public void setRightSon(Node<T> rightSon){
        this.rightSon = rightSon;
    }

    public void setLeftSon(Node<T> leftSon){
        this.leftSon = leftSon;
    }

    public Node<T> getLeftSon(){
        return this.leftSon;
    }

    public Node<T> getRightSon(){
        return this.rightSon;
    }

    @Override
    public int compareTo(T value){
        try {
            Integer temp = Integer.parseInt(this.toString());
            Integer temp2 = Integer.parseInt(value.toString());
            return temp.compareTo(temp2);
        } catch (Exception e) {}
        String temp = this.toString();
        String temp2 = value.toString();
        return temp.compareTo(temp2);
    }

    public String toString(){
        return this.value.toString();
    }
}

