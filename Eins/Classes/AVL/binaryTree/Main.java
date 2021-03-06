package AVL.binaryTree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> ab = new Tree<Integer>();
        Random randy = new Random();
        Integer[] array = new Integer[]{10,20,30,40,50,47,85,2,34};      //{12,5,15,3,7,13,17,1,9,14,20,8,11,18,21};
        //{7,3,11,1,5,9,13,4,6,8,12,14,73};
        //{10,6,20,4,8,15,21,11,16,22,14,17};
        //{30,60,45,15,7,22,75,17,27};
        //{50,48,30,70,65,90,20,32,31,35,15,25,67,98,66,94,99,69};
        for (Integer e : array) {
            ab.insertRecursive(e);
            System.out.println();
        } 
        //ab.setHeights(ab.root);
        ab.preOrder();

        
        /*
        int n = 0; 
        for (int i = 0; i < 15; i++) {
            n = randy.nextInt(100);
            ab.insertRecursive(n);
            System.out.println(n);
        }  */
        System.out.println(); 
    }
}
