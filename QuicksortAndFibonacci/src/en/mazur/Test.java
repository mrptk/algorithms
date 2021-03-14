package pl.mazur;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        System.out.println("*******************************************************");
        System.out.println("********************** QUICKSORT **********************");
        System.out.println("*******************************************************\n");

        var gen = new Random(); // generating random numbers in the array
        int[] tab = new int[100];
        for (int i = 0; i < tab.length; i++) tab[i] = gen.nextInt(75);

        System.out.println("********************** BEFORE SORTING **********************");
        for (int i : tab) System.out.print(i + ", ");

        var sort = new QuicksortInt(tab);

        System.out.println("\n************************ AFTER SORTING ************************");

        for (int i : sort.getArray()) System.out.print(i + ", ");
    } 
}
