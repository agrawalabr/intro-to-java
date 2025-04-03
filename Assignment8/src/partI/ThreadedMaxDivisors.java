package partI;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;
import java.util.AbstractMap;

public class ThreadedMaxDivisors implements Runnable {
	
	private long min;
	private long max;
	private Entry<Long, Long> result;
	private boolean is_optimised = true;
	
	public ThreadedMaxDivisors(long min, long max, boolean is_optimised) {
        this.min = min;
        this.max = max;
        this.result = null;
        this.is_optimised = is_optimised;
    }

	@Override
	public void run() {
        long maxDivisors = 0;
        long numFound = 0;
        int divisors = 0;
        
        for (long num = min; num <= max; num++) {
        	if (is_optimised == true) {
        		divisors = CountDivisors.optimisedCountDivisors(num);
        	} 
        	else {
        		divisors = CountDivisors.countDivisors(num);
        	}
        	
            if (divisors > maxDivisors) {
                maxDivisors = divisors;
                numFound = num;
            } 
            else if (divisors == maxDivisors && num > numFound) {
                numFound = num;
            }
        }
        
        result = new AbstractMap.SimpleEntry<>(numFound, maxDivisors);
    }
	
	public Entry<Long, Long> getResult() {
        return result;
    }

	public static void main(String[] args) {
		
		long min = 100_000;
		long max = 200_000;
		
		boolean[] optimised = {true, false};

        for (boolean iter : optimised) {
            int numThreads = Runtime.getRuntime().availableProcessors();
            long rangePerThread = (max - min + 1) / numThreads;
            
            Set<Thread> threadSet = new HashSet<Thread>();
    		Set<ThreadedMaxDivisors> divisorsSet = new HashSet<ThreadedMaxDivisors>();
    		
    		long startTime = System.currentTimeMillis();
    	    for (int i = 0; i < numThreads; i++) {
    	    	long threadMin = min + (i * rangePerThread);
    	        long threadMax = (i == numThreads - 1) ? max : threadMin + rangePerThread - 1;
    	            
    	        ThreadedMaxDivisors tmd = new ThreadedMaxDivisors(threadMin, threadMax, iter);
    	        Thread t = new Thread(tmd);
    	            
    	        threadSet.add(t);
    	        divisorsSet.add(tmd);
    	        t.start();
    	    }
    	    
    	    for (Thread t: threadSet) {
    			try {
    				t.join();
    				System.out.print("Done ");
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    	    }
    	    
    	    long overallMaxDivisors = 0;
    	    long overallNumFound = 0;
          
    	    for (ThreadedMaxDivisors tmd : divisorsSet) {
             	Entry<Long, Long> threadResult = tmd.getResult();
             	if (threadResult != null) {
             		if (threadResult.getValue() > overallMaxDivisors) {
             			overallMaxDivisors = threadResult.getValue();
             			overallNumFound = threadResult.getKey();
             		} else if (threadResult.getValue() == overallMaxDivisors && 
                        threadResult.getKey() > overallNumFound) {
             			overallNumFound = threadResult.getKey();
             		}
             	}
    	    }
  		
    	    long endTime = System.currentTimeMillis();
    	    System.out.println("Threaded elapsed time: " + (endTime - startTime));
    	    System.out.println(overallNumFound + "=" + overallMaxDivisors);
          	System.out.println("---------------------------------------------");
      }
        
      long startTime = System.currentTimeMillis();
      Entry<Long, Long> e = CountDivisors.maxDivisors(min, max);
      
      long number = e.getKey();
      long numDivisors = e.getValue();
      
      System.out.println("\n" + number + "=" + numDivisors);
      long endTime = System.currentTimeMillis();
      
      System.out.println("Non-threaded elapsed time: " + (endTime - startTime));
	}
}
