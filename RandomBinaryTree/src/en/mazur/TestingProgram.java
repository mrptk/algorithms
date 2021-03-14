package pl.mazur;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ptkma
 */
public class TestingProgram {
    
    public static void zniszcz(ArrayList<Integer> tab) {
        tab.add(2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RBT<Integer> tree = new RBT<>();
        
        Random generator = new Random();
        
        int searched1 = 18; // root
        
        int searched2 = 17; // added at the end
        
        int searched3 = 45; // not added
        
        int searched4 = 69; // added inbetween
        
        tree.add(searched1);
        
        for (int i = 0; i < 10; i++) {
            tree.add((Integer) generator.nextInt(100));
            if (i == 5) tree.add(69);
        }
        
        tree.add(searched2);
        tree.add(searched2);
        
        System.out.println("PREORDER");
        tree.viewPreOrder();
        System.out.println("Looking for " + searched1 + ": " + tree.find(searched1));
        System.out.println("Looking for " + searched2 + ": " + tree.find(searched2));
        System.out.println("Looking for " + searched3 + ": " + tree.find(searched3));
        System.out.println("Looking for " + searched4 + ": " + tree.find(searched4));
        
        System.out.println("INORDER");
        tree.viewInOrder();
        System.out.println("Looking for " + searched1 + ": " + tree.find(searched1));
        System.out.println("Looking for " + searched2 + ": " + tree.find(searched2));
        System.out.println("Looking for " + searched3 + ": " + tree.find(searched3));
        System.out.println("Looking for " + searched4 + ": " + tree.find(searched4));
        
        System.out.println("POSTORDER");
        tree.viewPostOrder();
        System.out.println("Looking for " + searched1 + ": " + tree.find(searched1));
        System.out.println("Looking for " + searched2 + ": " + tree.find(searched2));
        System.out.println("Looking for " + searched3 + ": " + tree.find(searched3));
        System.out.println("Looking for " + searched4 + ": " + tree.find(searched4));
        
        System.out.println("AFTER DELETION");
        tree.delete(searched1);
        tree.delete(searched2);
        tree.delete(searched4);
        tree.viewPostOrder();
        System.out.println("Looking for " + searched1 + ": " + tree.find(searched1));
        System.out.println("Looking for " + searched2 + ": " + tree.find(searched2));
        System.out.println("Looking for " + searched3 + ": " + tree.find(searched3));
        System.out.println("Looking for " + searched4 + ": " + tree.find(searched4));
        
        
        
        tree.destroy();
        
        try {
            tree.viewPreOrder();
        } catch (NullPointerException ex) {
            System.out.println("\nTREE IS DESTROYED");
        }
    }
    
}
