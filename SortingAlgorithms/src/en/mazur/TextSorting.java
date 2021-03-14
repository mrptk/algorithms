
package pl.mazur;

import java.util.Comparator;

/**
 *
 * @author ptkma
 */
public class TextSorting {
    
    public static String[] bubble(String[] arr, Comparator<String> comparator) {
        //Variables
        String[] result = arr.clone(); // returned array
        int i = 0; //first index
        int j = 0; //second index
        String auxiliary = ""; //auxiliary variable
        int indexMax = result.length - 1; //the last index


        // ***** Algorithm *****
        while (j <= indexMax) {
            if (comparator.compare(result[i], result[i + 1]) > 0) {
                auxiliary = result[i];
                result[i] = result[i + 1];
                result[i + 1] = auxiliary;
            }// end if
            
            i++;
            
            if (i >= indexMax) {
                j++;
                i = 0;
            }// end if
        }// end while

        return result;
    }
    
    public static String[] selection(String[] arr, Comparator<String> comparator) {
        //Variables
        String[] result = arr.clone(); 
        int i = 0; //first index
        int j = 1; //second index
        String auxiliary = ""; //auxiliary variable
        int indexMax = result.length - 1; // last index

      
        // ***** Algorithm *****
        while (i <= indexMax - 1){
            if (comparator.compare(result[i], result[j]) > 0){
                auxiliary = result[i];
                result[i] = result[j];
                result[j] = auxiliary;
            }//end if
            
            j++;
            
            if (j > indexMax){
                i++;
                j = i + 1;
            }//end if
        }//end while
       
        return result;
    }
    
    public static String[] doubleEndedSelection(String[] arr, Comparator<String> comparator){
        //Deklaracja zmiennych
        String[] result = arr.clone();
        String min, max; 
        String auxiliary;
        int iMin, iMax; //max and min indices
        int i = 0; //starting index
        int j = result.length - 1; //end index
        int k; //auxiliary index
        
      
        // ***** Algorithm *****
        do { //beginning do...while, preicate: i < j
            min = result[i]; max = result[i];
            iMin = i; iMax = i;
            
            for (k = i; k <= j; k++){
                if (comparator.compare(result[k], max) > 0){
                    max = result[k];
                    iMax = k;
                }//end if
                else if (comparator.compare(result[k], min) < 0){
                    min = result[k];
                    iMin = k;
                }//end if
            }
            
            auxiliary = result[i];
            result[i] = result[iMin];
            result[iMin] = auxiliary;
            
            if (result[iMin] == max){ // if the max value was swapped with the value at the min index
                auxiliary = result[j];
                result[j] = result[iMin];
                result[iMin] = auxiliary;
            } else {
                auxiliary = result[j];
                result[j] = result[iMax];
                result[iMax] = auxiliary;
            }//end if ... else
            
            i++;
            j--;
        } while (i < j);
        
        return result;
    }
}
