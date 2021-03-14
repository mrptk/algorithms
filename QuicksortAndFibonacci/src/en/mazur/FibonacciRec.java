/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mazur;

import java.util.ArrayList;

/**
 *
 * @author ptkma
 */
public class FibonacciRec {
    private long result; 
    private long howManyCalls; // how many times the method long fib(long) was called
    
    public FibonacciRec(long number){ //constructor
        howManyCalls = 0; 
        result = fib(number);
    }
    
    private long fib(long n){
        howManyCalls++; 

        if (n < 2) return n;

        return fib(n-1) + fib(n-2);
    }
    
    public long result(){ return result; }
    public long calls() { return howManyCalls; }
    
}
