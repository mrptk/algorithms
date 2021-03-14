package pl.mazur;

import java.util.Random;

/**
 *
 * @author ptkma
 */
public class Node<T extends Comparable> {
    public T value;
    public Node<T> left;
    public Node<T> right; 
    
    public Node(T value) {
        this.value = value;
        left = null;
        right = null;
        
    }
    
    public void add(T newValue) {
        Random generator = new Random();
        double p = generator.nextDouble();
        
        if (p <= 0.5) {
            if (left == null) left = new Node(newValue);
            else left.add(newValue);
        }
        else {
            if (right == null) right = new Node(newValue);
            else right.add(newValue);
        }
    }
    
    public boolean find(T searched) {
        boolean result = false;
        
        if (left != null) {
            result = searched.compareTo(left.value) == 0;
            if (result == false) result = left.find(searched);
        }
        if (result == false && right != null) {
            result = searched.compareTo(right.value) == 0;
            if (result == false) result = right.find(searched);
        }
        
        return result;
    }
    
    public boolean delete(T deleted) {
        boolean finish;
        
        finish = false;
        
        // To avoid passing reference to the parent node, I am checking both descendants
        
        if (left != null) { // I start with the left element
            if (left.value.compareTo(deleted) == 0) { // If it is to be deleted, then we have 4 cases
                if (left.isLast()) left = null; // 1. case - left is the last element
                else if (left.left != null && left.right == null) left = left.left; // 2. case - left stores only left sub-tree
                else if (left.left == null && left.right != null) left = left.right; // 3. case - left stores only right sub-tree
                else left.value = left.deleteLast(); // 4. case - left stores both subtrees
                finish = true;
            }
            else finish = left.delete(deleted);
        } // end if
        if (right != null && finish == false) {
            if (right.value.compareTo(deleted) == 0) {
                if (right.isLast()) right = null;
                else if (right.left != null && right.right == null) right = right.left;
                else if (right.left == null && right.right != null) right = right.right;
                else right.value = right.deleteLast();
                finish = true;
            }
            else finish = right.delete(deleted);
        } // end if
        
        return finish;
    }
    
    public T deleteLast() { // Auxiliary method deleting the last element (with no sub-trees) and returning its value
        T last = null; // Returned value
        Random generator = new Random();
        double p = generator.nextDouble(); // Random value
        
        if (p <= 0.5) { // Randomly choosing the element to check
            if (left != null) { // First case - checking if left descendant is last, provided he exists
                if (left.isLast()) { // If left is last, we keep its value (to swap with the deleted element) and we delete it
                    last = left.value;
                    left = null;
                } 
                else {
                    last = left.deleteLast(); // If its not last, we keep on checking
                } // end if
            } 
            else if (last == null && right.isLast()) { // If left does not exist we check the right 
                last = right.value;
                right = null;
            } 
            else last = right.deleteLast(); // If right is not lest we keep on checking
            // end if
        } 
        else { // Same as before but starting with right
            if (right != null) {
                if (right.isLast()) {
                    last = right.value;
                    right = null;
                }
                else {
                    last = right.deleteLast();
                } //end if
            }
            else if (last == null && left.isLast()) {
                last = left.value;
                left = null;
            }
            else last = left.deleteLast();
            // end if
        } // end if
        
        return last;
    }
    
    private boolean isLast() { 
        return left == null && right == null;
    }    
        
    public void preorder() {
        System.out.println(value);
        if (left != null) left.preorder();
        if (right != null) right.preorder();
    }
    
    public void inorder() {
        if (left != null) left.preorder();
        System.out.println(value);
        if (right != null) right.preorder();
    }
    
    public void postorder() {
        if (left != null) left.preorder();
        if (right != null) right.preorder();
        System.out.println(value);
    }
    
    public void destroy(){
        if (left != null) left.destroy();
        if (right != null) right.destroy();
        value = null;
        left = null;
        right = null;
    }
    
}
