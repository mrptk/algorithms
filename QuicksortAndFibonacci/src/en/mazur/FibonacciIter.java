package pl.mazur;

/**
 *
 * @author ptkma
 */
public class FibonacciIter {
    private long result;
    
    public FibonacciIter(int number){
        result = fib(number);
    }
    
    private long fib(int n){
        // Variables
        long first = 1; //first summand(f(n-2))
        long second = 1; //second summand (f(n-1))
        long result = 1;

        for (int i = 2; i < n && n >= 3; i++){
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }
    
    public long result(){ return result; }
}
