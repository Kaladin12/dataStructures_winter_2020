package bTree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Tree<Integer> ab = new Tree<Integer>(3);
        Tree<Integer> myTree = new Tree<Integer>(3);
        Random randy = new Random();
        Integer[] array = new Integer[]{56,30,70,22,40,60,95,11,3,16,65,63,67};

        myTree.callInsert(12);
        myTree.callInsert(3);
        myTree.callInsert(-6);
        //myTree.callInsert(1);
        System.out.println();
        
        
        /*        
        int n = 0; 
        for (int i = 0; i < 15; i++) {
            n = randy.nextInt(100);
            ab.addNodeHere(n);
            System.out.println(n);
        }*/
        //ab.BFS(ab.root);
        //System.out.println("");
        //ab.deleteNode(ab.root, 3);
        
        //ab.inOrderPredecesor(16, ab.root);
        //ab.printByLevels(ab.root);
        //ab.setHeights(ab.root);
        //ab.inOrder();
        //System.out.println(ab.height(ab.root));
        //System.out.println(ab.heightOfNode(500,ab.root,0));
        //System.out.println(ab.getHeight(ab.root, 1000));
        /*System.out.println("\n");
        ab.preOrder();
        System.out.println("\n");
        ab.postOrder();
        System.out.println("\n"); */
       
    }
}
