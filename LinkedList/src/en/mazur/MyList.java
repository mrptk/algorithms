package pl.mazur;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 * @author ptkma
 */
public class MyList <T extends Comparable>{
    private T value;
    private MyList next;
    
    public MyList(){
    } //constructor end
    
    private MyList(T newValue, MyList oldList){ // auxiliary constructor to add new elements
        value = newValue;
        next = oldList;
    } // constructor end
    
    public void add(T newValue){
        if (value == null) value = newValue;
        else {
            next = new MyList(value, next);
            value = newValue;
        }
    }
    
    public void append(T newValue){
        if (next == null) next = new MyList(newValue, null);
        else next.append(newValue);
    }
    
    public void print(){
        System.out.print(value + " ");
        if (next != null) next.print();
    }
    
    public void destroy(){
        if (next != null) next.destroy();
        value = null;
        next = null;
    }
    
    public void delete(T valueToDelete){ 
        if (value.compareTo(valueToDelete) == 0) {
            value = (T) next.value;
            next = next.next;
        }
        else next.delete(valueToDelete);
    }
    
    public boolean find(T searched) { 
        boolean result = false;
        
        if (value.compareTo(searched) == 0) result = true;
        else result = next.find(searched);
        
        return result;
    }
    
    public T[] toArray(){
        int size = 1;
        Class<?> arrayClass = value.getClass();
        MyList<T> nextElement = next;
        
        do{
            size++;
            nextElement = nextElement.next;
        }while(nextElement != null);
        
        T[] tab = (T[]) Array.newInstance(arrayClass, size);
        
        nextElement = this;
        for (int i = 0; i < size; i++){
            tab[i] = nextElement.value; 
            nextElement = nextElement.next;
        }
        
        return tab;
    }
    
    public void fromArray(T[] tab){ for (T element : tab) this.add(element); }
}
