package pl.mazur;

import java.util.Random;

/**
 *
 * @author ptkma
 */
public class TestingProgram {

    /**
     * @param args the command line arguments
     */
    
    public static long average(long[] arr) {
        long sum = 0;
        for(int i = 0; i < arr.length; i++) sum += arr[i];
        return sum / arr.length;
    }
    
    public static void main(String[] args) {
        
        //Variables
        int noOfMeasurements = 10;
        long[] measurementArray = new long[noOfMeasurements]; // Tablica pomiarów czasu
        long timeStart;  
        long timeStop;  
        long avgTime = 0;
        int arrSize;
        SortingList<Integer> list = new SortingList<>();
        SortingList2D<Integer> sortingList2D = new SortingList2D<>();
        List2D<Integer> list2D = new List2D<>();
        Random generator = new Random();
        Integer[] sortedArray = null;
        
        // LINKED LIST SORTING
        
        System.out.println("LINKED LIST SORTING");
        for (int g = 0; g < 6000; g++) list.add(generator.nextInt(6000)); // 6000 random elements
        sortedArray = list.sortedArray(); 
        for (int h = 0; h < sortedArray.length; h++) System.out.println(sortedArray[h]);
        System.out.println("Array size: " + sortedArray.length);
        
        sortedArray = null;
        list.destroy();
        
        //  MEASURING SORTING TIME
        
        for (int i = 6; i <= 11; i++) { 
            arrSize = i * 1000;
            
            System.out.println("***** 1D LIST *****");
            System.out.println("***** " + arrSize + " *****");
            
            for (int j = 0; j < noOfMeasurements; j++){ 
                timeStart = System.nanoTime();  
                
                for (int k = 0; k < arrSize; k++){ 
                    list.add((Integer) generator.nextInt(arrSize));
                } //end for
                
                sortedArray = list.sortedArray(); 
                timeStop = System.nanoTime(); 
                measurementArray[j] = timeStop - timeStart; 
                System.out.println("Time " + (j+1) +".: " + measurementArray[j]);
                list.destroy();
                
            } // end for
            
            avgTime = average(measurementArray);
            System.out.println("Average time: " + avgTime);
            
            measurementArray = new long[noOfMeasurements];
            sortedArray = null;
            avgTime = 0;
        } // end for
        
        for (int i = 6; i <= 11; i++) { // 
            arrSize = i * 1000;
            
            System.out.println("***** 2D LIST *****");
            System.out.println("***** " + arrSize + " *****");
            
            for (int j = 0; j < noOfMeasurements; j++){ 
                timeStart = System.nanoTime(); 
                
                for (int k = 0; k < arrSize; k++){ 
                    sortingList2D.add((Integer) generator.nextInt(arrSize));
                } //end for
                
                sortedArray = sortingList2D.sortedArray(); 
                timeStop = System.nanoTime(); 
                measurementArray[j] = timeStop - timeStart; 
                System.out.println("Time " + (j+1) +".: " + measurementArray[j]);
                sortingList2D.destroy(); 
                
            } // end for
            
            avgTime = average(measurementArray);
            System.out.println("Average time: " + avgTime);
            
            measurementArray = new long[noOfMeasurements];
            sortedArray = null;
            avgTime = 0;
        } // end for

        
        
        System.out.println("***** 2D LIST *****");
        for (int i = 0; i < 100; i++) { 
            list2D.add(i);
            list2D.append(i + 100);
        }// end for
        
        list2D.print();
        
        System.out.println("Next element: " + list2D.next().value);
        System.out.println("Next element: " + list2D.next().value);
        System.out.println("Next element: " + list2D.next().value);
        System.out.println("Next element: " + list2D.next().value);
        System.out.println("Previous element: " + list2D.previous().value);
        System.out.println("Previous element: " + list2D.previous().value);
        System.out.println("Previous element: " + list2D.previous().value);
        System.out.println("Previous element: " + list2D.previous().value);
        list2D.goToEnd(); System.out.println("GOING TO THE END");
        System.out.println("Previous element: " + list2D.previous().value);
        System.out.println("Previous element: " + list2D.previous().value);
        System.out.println("Previous element: " + list2D.previous().value);
        System.out.println("Previous element: " + list2D.previous().value);
        list2D.goToBeginning(); System.out.println("GOING TO THE BEGINNING");
        System.out.println("Next element: " + list2D.next().value);
        System.out.println("Next element: " + list2D.next().value);
        System.out.println("Next element: " + list2D.next().value);
        System.out.println("Next element: " + list2D.next().value);
        
        list2D.destroy();        
        
    }
}
    
