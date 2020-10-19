package binaryTree;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> ab = new Tree<Integer>();
        Random randy = new Random();
        Integer[] array = new Integer[]{56,30,70,22,40,60,95,11,3,16,65,63,67};
        //{25,20,36,10,22,5,12,1,8,15,30,40,28,38,48,45,50,500};
        //{12,5,15,3,7,13,17,1,9,14,20,8,11,18,21};
        //{7,3,11,1,5,9,13,4,6,8,12,14,73};
        //{10,6,20,4,8,15,21,11,16,22,14,17};
        //{30,60,45,15,7,22,75,17,27};
        //{50,48,30,70,65,90,20,32,31,35,15,25,67,98,66,94,99,69};
        
        /*
        
        int n = 0; 
        for (int i = 0; i < 15; i++) {
            n = randy.nextInt(100);
            ab.addNodeHere(n);
            System.out.println(n);
        }*/
        for (Integer s : array) {
            ab.addNodeHere(s);
        }
        //ab.BFS(ab.root);
        //System.out.println("");
        ab.deleteNode(ab.root, 3);
        
        //ab.inOrderPredecesor(16, ab.root);
        //ab.printByLevels(ab.root);
        //ab.setHeights(ab.root);
        System.out.println();
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
