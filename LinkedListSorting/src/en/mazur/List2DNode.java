package pl.mazur;

/**
 *
 * @author ptkma
 */
public class List2DNode<T extends Comparable> {
    public T value;
    public List2DNode previous;
    public List2DNode next;
    
    public List2DNode(T newValue, List2DNode descendant, List2DNode ascendant) { // Konstruktor elementu listy
        value = newValue;
        previous = descendant;
        next = ascendant;
    } // koniec konstruktora
}
