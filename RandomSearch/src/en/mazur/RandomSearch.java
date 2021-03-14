// Zdecydowałem się użyć interfejsu Callable i FutureTask, gdyż wątki wykonane w ten sposób mogą zwracać wartość.

package pl.mazur;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class RandomSearch implements Callable<Boolean>{
    private final int[] arr; // The array that is searched through
    private final int searched; // Searched value
    private final int startingIndex; // Where a given thread starts searching
    private final int endIndex; // Where a given thread ends searching
    
    public RandomSearch(int[] arr, int searched, int startingIndex, int endIndex){ //Konstruktor
        this.arr = arr;
        this.searched = searched;
        this.startingIndex = startingIndex;
        this.endIndex = endIndex;
    }// Constructor end
    
    public static boolean search(int[] arr, int searched, int numberOfCores){ //Główna metoda służąca do przeszukiwania tablic int
        // Variables
        boolean result = false;
        int howManyCores = numberOfCores;
        FutureTask<Boolean>[] searchingTasks = new FutureTask[howManyCores]; // We create as many threads, tasks and objects as the machine allows us
        Thread[] searchingThreads = new Thread[howManyCores];
        Callable<Boolean>[] searchingObjects = new RandomSearch[howManyCores];
        int threadStartingIndex = 0;
        int threadEndIndex = (arr.length - 1)/howManyCores + (arr.length - 1) % howManyCores; // The first range is enlarged by the remainder from the division array size / cores
        int i = 0; //iterator

        
        
        for (i = 0; i < howManyCores; i++){ // Filling the arrays of searching objects, threads and tasks with consecutive ranges from the array
            searchingObjects[i] = new RandomSearch(arr, searched, threadStartingIndex, threadEndIndex);
            searchingTasks[i] = new FutureTask<Boolean>(searchingObjects[i]);
            searchingThreads[i] = new Thread(searchingTasks[i]);
            searchingThreads[i].start();
            
            threadStartingIndex = threadEndIndex + 1;// Moving the index
            threadEndIndex += (arr.length - 1)/howManyCores;
        }// end for
        
        
        for (i = 0; i < searchingTasks.length && result == false; i++){ // Loop checking the results from each searching
            try{
                result = (boolean) searchingTasks[i].get();
            } catch (Exception ex) {
                System.out.println(ex);
            }// end try ... catch
            
        }// end for
        
        return result;
    } // end method

    @Override
    public Boolean call() throws Exception { // method carried out in each thread
        //Variables
        Boolean result = false; 
        int i = this.startingIndex;
        int j = this.endIndex;
        boolean searchedInRange = searched >= arr[i] && searched <= arr[j];
        int index = 0; // auxiliary random index
        Random generator = new Random();
        
        
        
        // Beginning of algorithms implementation
        if (searchedInRange){ // The main condition, the value must fit in the range
            
            do{//do ... while, predicate: (result == false && searchedInRange)
                
                index = i + generator.nextInt(j - i + 1); // getting a random index                   
                if (arr[index] == searched) result = true; // checking if the value is stored at the indices
                if (arr[i] == searched) result = true;
                if (arr[j] == searched) result = true;
               
                if (result == false){ // if none of the indices stores the value, we overwrite the proper index with the auxiliary index
                    if (arr[index] > searched) j = index - 1;
                    if (arr[index] < searched) i = index;
                    searchedInRange = searched >= arr[i] && searched <= arr[j]; // updating the range adter changes the outermost indices
                }
            } while (result == false && searchedInRange); // end do ... while
        }// end if
        
        return result;
    } // end method
 
} // end class
