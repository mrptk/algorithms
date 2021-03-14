package pl.mazur;

import java.util.Arrays;
import java.util.Random;

public class TestingProgram {
    
    public static long average(long[] arr){
        //Variables
        int i = 0; //iterator
        long result = 0;
        
        for (i = 0; i < arr.length; i++){
            result += arr[i];
        }
               
        return result/arr.length;
    }

    public static boolean unsortedSearch(int[] arr, int searched){ // A method to search though the arrays for comparison to RS
        //Deklaracja zmiennych
        int i = 0; //indeks
        boolean result = false;
        
        for (i = 0; i < arr.length - 1 && result == false; i++){ 
            if (arr[i] == searched) result = true;
        }
        
        return result;
    }
    
    public static void main(String[] args) { 
        // Deklaracja zmiennych
        int[] arr = new int[0];
        int noOfMeasurements = 10; 
        int noOfSizeIncrease = 50; // how many times the size of the array searched through is to be increased
        int i; //iterator
        int j; //iterator
        int k; //iterator
        int noOfCores = Runtime.getRuntime().availableProcessors(); 
        Random generator = new Random();
        int searched = generator.nextInt();
        long timeStart = 0;
        long timeStop = 0;
        long[] timeArrUnsorted = new long[noOfMeasurements];
        long[] timeArrRS = new long[noOfMeasurements];
        boolean resultUnsorted = false;
        boolean resultRS = false;
        
        
        
        System.out.println("Arr. size\tTime US\tTime RS\tResult US\tResult RS");
        
        for (i = 1; i <= noOfSizeIncrease; i++){// from 100,000 to 5 mln
            
            for (j = 0; j < noOfMeasurements; j++){ // Repeating the measurements for the average
                
                arr = new int[i*(int)1.0e5];

                for (k = 0; k < arr.length; k++){ // Loop filling the array with random values
                    arr[k] = generator.nextInt(i*(int)1.0e5);
                }//koniec for

                searched = generator.nextInt(i*(int)1.0e5);
                
                timeStart = System.nanoTime(); // Unsorted search
                resultUnsorted = unsortedSearch(arr, searched);
                timeStop = System.nanoTime();
                
                timeArrUnsorted[j] = timeStop - timeStart; 
                        
                Arrays.sort(arr);
                
                timeStart = System.nanoTime(); // RS
                resultRS = RandomSearch.search(arr, searched, noOfCores);
                timeStop = System.nanoTime();
                
                timeArrRS[j] = timeStop - timeStart;
            }// end for - next measurement
            
            System.out.println(i*(int)1.0e5 + "\t\t" + average(timeArrUnsorted) + "\t\t" + average(timeArrRS) + "\t\t" + resultUnsorted  + "\t\t" + resultRS);
            
        }// end for - next array size
    }
}
