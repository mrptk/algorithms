package pl.mazur;

import java.lang.reflect.Array;

/**
 *
 * @author ptkma
 */
public class SortingList2D<T extends Comparable> {
    private List2DNode<T> present; // presetly viewed element, a navigator, so to speak
    private List2DNode<T> head; // This is where we start counting the elements from, here, the reference to the tail is not needed
    
    public SortingList2D() {}; // Empty constructor
    
    private void addFirstElement(T newValue) { // Auxiliary function creating the first element
        present = new List2DNode<T>(newValue, null, null);
        head = present;
    }
    
    public void add(T newValue) { // Main function adding elements
        if (present == null) addFirstElement(newValue); 
        else{
            if (newValue.compareTo(present.value) >= 0) goRight(newValue); // If a given element is bigger than the viewed one, we go right
            else goLeft(newValue);                                             // otherwise we go left
        }
    }
    
    private void goRight(T newValue) {
        if (newValue.compareTo(present.value) == 0) addAtRight(newValue); // Going right, we check if the new element isn't equal to the one we are viewing
        else if (newValue.compareTo(present.value) > 0) {                       // if so, we add it at the right side
            if (present.next == null) addAtRight(newValue);                // if not, we go right
            else {                                                                  // if we reach the end, we append the element there
                present = present.next;                                           // if we encounter a larger element, we are adding the new element at the left side
                goRight(newValue);
            }
        } else addAtLeft(newValue);
    }
    
    private void goLeft(T newValue) {
        if (newValue.compareTo(present.value) == 0) addAtLeft(newValue); // Just void goRight(T) but we change the greater than signs to less than and change the directions
        else if (newValue.compareTo(present.value) < 0) {
            if (present.previous == null) addAtLeft(newValue);
            else {
                present = present.previous;
                goLeft(newValue);
            }
        } else addAtRight(newValue);
    }
    
    private void addAtLeft(T newValue) {
        if (present.previous != null) {
            List2DNode<T> auxiliary = new List2DNode<>(newValue, present.previous, present);
            present.previous.next = auxiliary;
            present.previous = auxiliary;
            auxiliary = null;
        }
        else {
            present.previous = new List2DNode<>(newValue, null, present);
            head = present.previous;
        }
    }
    
    private void addAtRight(T newValue) {
        if (present.next != null) {
            List2DNode<T> auxiliary = new List2DNode<>(newValue, present, present.next);
            present.next.previous = auxiliary;
            present.next = auxiliary;
            auxiliary = null;
        }
        else {
            present.next = new List2DNode<>(newValue, present, null);
        }
    }
    
    public void print() {
        List2DNode<T> ascendant = head;
        
        do {
            System.out.println(ascendant.value + ", ");
            ascendant = ascendant.next;
        } while (ascendant != null);
    }
    
    public void destroy(){
        destroy(head);
        head = null;
        present = null;
    }
    
    private void destroy(List2DNode<T> element){
        if(element.next != null) destroy(element.next);
        element.next = null;
        element.value = null;
        element.previous = null;
    }
    
    public T[] sortedArray() {
        Class<?> arrClass = present.value.getClass();
        int size = 0;
        T[] arr;
        List2DNode<T> ascendant = head;
        
        do{
            size++;
            ascendant = ascendant.next;
        }while(ascendant != null);
        
        arr = (T[]) Array.newInstance(arrClass, size);
        
        ascendant = head;
        for (int i = 0; i < size; i++){
            arr[i] = ascendant.value; 
            ascendant = ascendant.next;
        }
        
        return arr;
    }
}
