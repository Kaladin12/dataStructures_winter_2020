package bTree;

import java.util.ArrayList;

public class Node<T> implements Comparable<T> {
    private T value ; 
    private int deg;
    ArrayList<T> keys;
    ArrayList<Node<T>> children;
    private Integer height;
    private Boolean isLeaf;

    private Node<T> next;

    public Node(int deg){
        this.deg = deg;
        this.height  = -1;
        this.keys = new ArrayList<T>(0);
        this.isLeaf = false;
        this.children = null;//new ArrayList<Node<T>>(value+1);
    }

    public Node(T value){
        this.value = value;
    }

    public Boolean hasChildren(){
        return this.children==null ? false : true;
    }

    public void setChild(Node<T> child, int pos){
        if (this.children!=null &&  pos==this.children.size()){
            ArrayList<Node<T>> temp = this.children;
            this.children = new ArrayList<Node<T>>(pos);
            for (int i = 0; i < temp.size(); i++) {
                this.children.add(i, temp.get(i));
            }
            this.children.add(pos,child);
        }
        else{
            //System.out.println(child.keys.size()+"  "+this.deg);
            if (child.keys.size()<=this.deg)
             {
                for (int i = 0; i < this.children.size();i++) {
                    if (this.children.get(i).keys.size()>this.deg){
                        this.children.remove(i);
                    }
                }
                this.children.add(pos,child);
             }
        }
    }

    public Node<T> getChild(int pos){
        return this.children.get(pos);
    }

    public ArrayList<Node<T>> getChildren(){
        return this.children;
    }

    public void deleteValue(int npos){
        this.keys.remove(npos);
    }

    public T getValue(){
        return this.value;
    }

    public T getValue(int n){
        return this.keys.get(n);
    }

    public void setValue(T value, int pos){ //pushea a keys
        if (pos==this.keys.size()){
            ArrayList<T> temp = this.keys;
            this.keys = new ArrayList<T>(pos);
            for (int i = 0; i < temp.size(); i++) {
                this.keys.add(i, temp.get(i));
            }
            this.keys.add(pos,value);
        }
        else{
            if (this.keys.size()+1>this.deg){
                /*ArrayList<T> temp = this.keys;
                this.keys = new ArrayList<T>(this.keys.size()+1);
                for (int i = 0; i <= temp.size(); i++) {
                    if (i==pos){  this.keys.add(i,value); }
                    else{
                        if (this.keys.size()!=0 &&  this.keys.get(pos)!=null){
                            if (pos==0) {this.keys.add(i, temp.get(i-pos-1));}
                            else {this.keys.add(i, temp.get(i-pos));}
                        }
                        else{
                            this.keys.add(i, temp.get(i));
                        }
                    }
                } */
                this.keys.set(pos, value);
            }
            else{
                this.keys.add(pos, value);
            }
            
        }
        
    }

    public void replaceValue(T value, int pos){
        this.keys.set(pos, value);
    }

    public void setHeight(Integer level){
        this.height = level;
    }

    public Integer getHehight(){
        return this.height;
    }
    
    public void setLeafState(Boolean is){
        this.isLeaf = is;
    }

    public Boolean getLeaftState(){
        return this.isLeaf;
    }

    public int callComparable(int n, T value){
        Node<T> temp = new Node<T>(this.keys.get(n));
        //System.out.println(temp.getValue()+" "+value+" "+temp.compareTo(value) );
        return temp.compareTo(value);
    }

    @Override
    public int compareTo(T value){
        try {
            Integer temp = Integer.parseInt(this.toString());
            Integer temp2 = Integer.parseInt(value.toString());
            return temp-temp2;
        } catch (Exception e) {}
        String temp = this.toString();
        String temp2 = value.toString();
        return temp.compareTo(temp2);
    }

    public String toString()
    {
        return this.value.toString();
    }

    public void setNext(Node<T> next){
        this.next = next;
    }

    public Node<T> getNode(){
        return this.next;
    }
}

