package pl.mazur;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        System.out.println("*******************************************************");
        System.out.println("********************** FIBONACCI **********************");
        System.out.println("*******************************************************\n");

        int[] elements = new int[]{
            5,
            10,
            15,
            20,
            25,
            30,
            35,
            40,
            44
        };

        for (int n : elements){
            var fiboR = new FibonacciRec(n);
            var fiboI = new FibonacciIter(n);
            System.out.println("N: " + n + "\nRecursion: " + fiboR.result() + "\nIteration: " + fiboI.result() + "\n");
        }

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
