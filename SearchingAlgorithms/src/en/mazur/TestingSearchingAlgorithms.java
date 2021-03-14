package pl.mazur;

import java.util.Arrays;
import java.util.Random;

public class TestingSearchingAlgorithms {
    
    public static boolean findInArray(int[] arr, int searched){ // Searching in unsorted arrays
        //Variable
        int i = 0; //index
        boolean result = false;
        
        for (i = 0; i < arr.length - 1 && result == false; i++){ // Simply iterating through the array's elements until the searched element is found
            if (arr[i] == searched) result = true;
        }
        
        return result;
    }
    
    public static int findInSortedArray(int[] arr, int searched){ // Searching in sorted arrays (binary search)
        //Variables 
        int i = 0; //starting index
        int j = arr.length - 1; //end index
        int k = -1; //auxiliary index
        
        if (searched >= arr[i] && searched <= arr[j]){ // Checking if the value fits between the min and max value in the array
            do { //beginning of do...while, predicate: (j - i <= 1)
                k = (int)((j - i)/2) + i; //each iteration starts with updating the auxiliary index;
                
                // checking if the searched value is one of the outermost values
                if (arr[i] == searched) k = i;
                if (arr[j] == searched) k = j;
                
                if (arr[k] == searched) j = i = 0; // if the searched value is found at one of the outermost indices, the exit from the loop must be ensured
                else { // here the starting or the end index are changed, depending on the arr[k] value
                    if (arr[k] > searched) j = k;
                    if (arr[k] < searched) i = k;
                    if (j - i <= 1) k = -1;// auxiliary index is set on -1
                }//koniec else
                
            } while (j - i > 1 && arr[k] != searched);// end do ... while
        } //end if
        
        return k;
    }
    
    public static long averageTime(long[] arr){ // calculating the average of values in the array
        //Variables
        long sum = 0;
        long result = 0;
        int i = 0; // iterator
                
        for(i = 0; i < arr.length; i++){ 
            sum += arr[i];
        }
        
        result = (long) sum/arr.length;
        
        return result;
        
    }
    
    public static void main(String[] args) { 
        // Variables
        int[] array = new int[0]; 
        int searched = 0;
        Random generator = new Random();
        int i = 0; //iterator to fill an array
        int j = 1; //iterator to increase the size of an array
        int k = 0; //iterator for the number of measurements 
        int howManyMeasurements = 10;
        long timeStart = 0;
        long timeStop = 0;
        long[] timesArrayUnsorted = new long[0];
        long[] timesArrayBinary = new long [0];
        
        
        System.out.println("Mes.\tUnsrt.\tBin."); // table head
        
        for (j = 1; j <= 20; j++){
            for(k = 0; k < howManyMeasurements; k++){
                timesArrayUnsorted = new long[howManyMeasurements];
                timesArrayBinary = new long[howManyMeasurements];
                
                array = new int[j*(int)1.0e5];
                searched = generator.nextInt(j*(int)1.0e5);
                i = 0;

                // Filling the array with random numbers
                for (i = 0; i < array.length - 1; i++){ 
                    array[i] = generator.nextInt(j*(int)1.0e5);
                } // end for
                
                timeStart = System.nanoTime(); // measuring the first method
                findInArray(array, searched);
                timeStop = System.nanoTime(); // end of measurement
                timesArrayUnsorted[k] = timeStop - timeStart;

                Arrays.sort(array);
                
                timeStart = System.nanoTime(); // measuring the second method
                findInSortedArray(array, searched);
                timeStop = System.nanoTime(); // end of measurement
                timesArrayBinary[k] = timeStop - timeStart;
            }
            System.out.println(j*(int)1.0e5 + "\t" + averageTime(timesArrayUnsorted) + "\t" + averageTime(timesArrayBinary)); // printing the results
        }
    }
    
}
