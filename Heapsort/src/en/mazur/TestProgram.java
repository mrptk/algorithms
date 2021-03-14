package pl.mazur;

import java.util.Random;

/**
 *
 * @author ptkma
 */
public class TestProgram {
    /**
     * @param args the command line arguments
     */
    public static void swap(int[] tab, int i1, int i2) {
        int auxiliary;
        
        auxiliary = tab[i1];
        tab[i1] = tab[i2];
        tab[i2] = auxiliary;
    } // koniec swap
    
    public static void move(int[] arr, int index) {
        int remainderOf2; // I need to now that to refer to the ascendant
        remainderOf2 = index % 2;
        
        if (remainderOf2 > 0) { // If swapped is uneven
            if (arr[(index - 1)/2] > arr[index]) { // Checking if ascendant is bigger than its descendant
                swap(arr, (index - 1)/2, index); // If so - swapping
                if ((index - 1)/2 > 0) move(arr, (index - 1)/2); // Checking the ascendant of the ascendant
            }
        } else { // If the swapped is even
            if (arr[(index - 2)/2] > arr[index]) {
                swap(arr, (index - 2)/2, index);
                if ((index - 2)/2 > 0) move(arr, (index - 2)/2);
            }
        }
    }
    
    public static void heapify(int[] arr, int endIndex) {
        int left; // Left descendant index
        int right; // Right descendant index
                
        for (int i = 0; 2 * i <= endIndex; i++) { 
            left = 2*i + 1;
            right = 2*i + 2;
            
            if (left <= endIndex && arr[left] < arr[i]) move(arr, left); 
            if (right <= endIndex && arr[right] < arr[i]) move(arr, right);
        } // end for
        
    } // end heapify(int[])
    
    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i);
            swap(arr, i, 0);
        }
    }
    
    public static long average(long[] arr) {
        long sum = 0;
        
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        
        return sum / arr.length;
    }
    
    public static void main(String[] args) {
        
        int factor = 10000; // Will reapeat 10 times
        int[] arr; // Tablica
        long[] times = new long[10]; // times for average
        Random generator = new Random();
        long timeStart;
        long timeStop;
        
        for (int i = 1; i <= 10; i++) { 
            int N = factor * i; 
            
            for (int j = 0; j < times.length; j++) { 
                arr = new int[N]; 
                for (int k = 0; k < arr.length; k++) arr[k] = generator.nextInt(N); 
                timeStart = System.nanoTime();
                sort(arr);
                timeStop = System.nanoTime();
                times[j] = timeStop - timeStart;
            }
            System.out.println("Average time for " + N + "-element array: " + average(times));
            
        } // end for      
        
    } //end main
    
} //end class
