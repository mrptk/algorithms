/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mazur;

/**
 *
 * @author ptkma
 */
public class QuicksortInt {
    private int[] arr;
    
    public QuicksortInt(int[] arrayToSort){ 
        arr = arrayToSort.clone();
        quickSort(0, arr.length - 1);
        
    } //constructor end
    
    public int[] getArray(){ return arr; }
    
    private void swap(int i, int j){ // swapping values at provided indices
        int aux;
        aux = arr[i];
        arr[i] = arr[j];
        arr[j] = aux;
    } //end swap
    
    private void quickSort(int left, int right){
        if(left < right){
            int axis = div(left, right);
            quickSort(left, axis - 1);
            quickSort(axis + 1, right);
        }
    }

    private int div(int left, int right){
        // Variables
        int axis = left + ((right - left) / 2);
        int i; //iterator
        int j; //stored value

        swap(axis, right); // swapping the element stored at the middle index with the element at the last index
        j = left; //first sotred value

        for(i = left; i <= right - 1; i++)
            if (arr[i] <= arr[right]){
                swap(i, j);
                j++;
            }
        swap(j, right);

        return j;
    }
}
