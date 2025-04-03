package partI;

import java.util.AbstractMap;
import java.util.Map.Entry;

public class CountDivisors {

    public static int countDivisors(long val) {
    	// Naive Approach - O(N)  	
        int divisorCount = 2;

        for (long testDivisor = 2; testDivisor <= val/2; testDivisor++) {
            if (val % testDivisor == 0)
                divisorCount++;
        }

        return divisorCount;
    }
    
    
    public static int optimisedCountDivisors(long val) {
    	// Prime Factorization - O(√N) 
        int divisorCount = 1;
        
        if (val % 2 == 0) {
            int power = 0;
            while (val % 2 == 0) {
                val /= 2;
                power++;
            }
            divisorCount *= (power + 1);
        }
        
        for (long i = 3; i * i <= val; i += 2) {
            if (val % i == 0) {
                int power = 0;
                while (val % i == 0) {
                    val /= i;
                    power++;
                }
                divisorCount *= (power + 1);
            }
        }

        return (val > 1)? 2*divisorCount: divisorCount;
    }

    
    public static Entry<Long, Long> maxDivisors(long from, long to) {

        long maxDivisors = 0;
        long numFound = 0;
        long numberTested = 0;
        for (long num = from; num <= to; num++) {
            int divisors = countDivisors(num);
            if (divisors >= maxDivisors) {
                maxDivisors = divisors;
                numFound = num;
            }
            numberTested++;
            if (numberTested == 1000) {
                System.out.print('.');
                numberTested = 0;
            }

        }
        Entry<Long,Long> result = new AbstractMap.SimpleEntry<Long,Long>(numFound, maxDivisors);

        return result;
    }

    public static void main(String[] args)
    {
        Entry<Long,Long> result = maxDivisors(100000, 200000);
        System.out.println("\n" + result);
    }
}




//0 --------1 ---------2 ---------3 --------4 ---------5 ---------6 --------7 ---------8 ---------9 --------10 ---------11 ---------12



