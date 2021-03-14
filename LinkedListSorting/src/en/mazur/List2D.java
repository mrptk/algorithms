package pl.mazur;

/**
 *
 * @author ptkma
 */
public class List2D<T extends Comparable> {
    private List2DNode present; // Presently viewed element
    private List2DNode head; 
    private List2DNode tail; 
    
    public List2D() {} // constructor creating an empty list
    
    private void addFirstElement(T newValue) { // Auxiliary function if the list is empty
        present = new List2DNode<T>(newValue, null, null);
        head = present;
        tail = present;
    }
    
    public void add(T newValue) {
        if (present == null) addFirstElement(newValue); // When the list is empty
        else {
            List2DNode<T> nowy = new List2DNode<>(newValue, null, head);
            head.previous = nowy;
            head = head.previous;
            nowy = null;
        }
    }
    
    public void append(T newValue) {
        if (present == null) addFirstElement(newValue); // When the list is empty.
        else {
            List2DNode<T> newElement = new List2DNode<>(newValue, tail, null);
            tail.next = newElement;
            tail = tail.next;
            newElement = null;
        }
    }
    
    public List2DNode previous() { // Goes left by 1 element and returns the element. Null-Pointer Exception should be handled here
        present = present.previous;
        return present;
    }
    
    public List2DNode next() { // Goes right by 1 element and returns the element. Null-Pointer Exception should be handled here
        present = present.next;
        return present;
    }
    
    public void goToBeginning() { present = head; }
    
    public void goToEnd() { present = tail; }
    
    public void destroy() {
        destroy(head);
        head = null;
        present = null;
        tail = null;
    }
    
    private void destroy(List2DNode<T> element) {
        if(element.next != null) destroy(element.next);
        element.next = null;
        element.value = null;
        element.previous = null;
    }
    
    public void print() {
        List2DNode<T> ascendant = head;
        
        do {
            System.out.println(ascendant.value + ", ");
            ascendant = ascendant.next;
        } while (ascendant != null);
    }
}
