package pl.mazur;

import java.util.Random;

/**
 *
 * @author ptkma
 */
public class RBT<T extends Comparable> {
    private Node<T> root;
    
    public RBT() {}; // Constructor
    
    private void addFirst(T newValue) {
        root = new Node<>(newValue);
    }
    
    public void add(T newValue) {
        if (root == null) addFirst(newValue);
        else root.add(newValue);
    }
    
    public void viewPreOrder() {
        root.preorder();
    }
    
    public void viewInOrder() {
        root.inorder();
    }
    
    public void viewPostOrder() {
        root.postorder();
    }
    
    public boolean find(T searched) {
        boolean result;
        
        result = searched.compareTo(root.value) == 0; // Checking if the root is not the searched value
        
        if (result == false) result = root.find(searched);
        
        return result;
    }
    
    public boolean delete(T deleted) {
        boolean result = false;
        
        if (deleted.compareTo(root.value) == 0) { // Checking if the root is not the value to be deleted, if it isn't then we have 4 cases:
            if (root.left == null && root.right == null) root = null; // 1. root is the only element
            else if (root.left != null && root.right == null) root = root.left; // 2. root has onlt left sub-tree
            else if (root.left == null && root.right != null) root = root.right; // 3. root has onlt right sub-tree
            else root.value = root.deleteLast();// 4. root has both sub-trees
            result = root.delete(deleted);
        }
        return result;
    }
    
    public void destroy() {
        root.destroy();
        root = null;
    }
}
