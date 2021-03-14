package pl.mazur;

import java.lang.reflect.Array;

/**
 *
 * @author ptkma
 */
public class SortingList<T extends Comparable> {
    private T value;
    private SortingList next;
    
    public SortingList() {}; // Constructor creates an empty list
    
    private SortingList(T newValue, SortingList oldList) { // Auxiliary constructor to add or add new elements
        value = newValue;
        next = oldList;
    }
    // constructor end
    
    public void print() {
        System.out.print(value + ", ");
        if (next != null) next.print();
    }
    
    private void insert(T newValue) { // Inserts a new element in the list. It copies the existing list, overwrites the old value and assignes the copied list as next
        SortingList ascendant = new SortingList(value, next);
        value = newValue;
        next = ascendant;
        ascendant = null;
    }
    
    public void add(T newValue) { // Adds a new element at the right place. It checks consecutive elements, and if a smaller or lares is encountered, inserts the new element at its place
                                     // If now smaller or larger is found, the new element is appended at the end
        if (value == null) value = newValue;
        else {
            if (newValue.compareTo(value) <= 0) this.insert(newValue);
            else if (next == null) next = new SortingList(newValue, null);
            else next.add(newValue);
        }
    }
    
    public void destroy() {
        if (next != null) next.destroy();
        value = null;
        next = null;
    }
    
    public T[] sortedArray() { 
        Class<?> arrClass = value.getClass();
        int size = 1;
        T[] arr;
        SortingList<T> ascendant = next;
        
        do{
            size++;
            ascendant = ascendant.next;
        }while(ascendant != null);
        
        arr = (T[]) Array.newInstance(arrClass, size);
        
        ascendant = this;
        for (int i = 0; i < size; i++){
            arr[i] = ascendant.value; 
            ascendant = ascendant.next;
        }
        
        return arr;
    }
    
}
