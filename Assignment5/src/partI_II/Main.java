package partI_II;

import java.util.*;

import partI_II.person.*;
import partI_II.task.*;

import java.util.function.Predicate;

public class Main {
	 public static void main(String[] args) {
		 // Part I: Abstracts
		 ArrayList<Task> jobQueue = new ArrayList<Task>();
	        
	     Developer developer = new Developer(jobQueue);
	     Tester tester = new Tester(jobQueue);
	     TechWriter techWriter = new TechWriter(jobQueue);
	        
	     Random random = new Random();
	     for (int i = 0; i < 5; i++) {
	    	 String moduleName = String.format("%04d", random.nextInt(10000));
	    	 int time = random.nextInt(10) + 1;    
	         developer.startTask(moduleName, time);
	         tester.startTask(moduleName, time);
	    	 techWriter.startTask(moduleName, time);   
	     }
	        
	     int totalTime = 0;
	     System.out.println("Executing all tasks:");
	     for (Task task : jobQueue) {
	     	 task.performTask();
	     	 totalTime += task.getTime();
	     }
	     System.out.println("Total time to process all tasks: " + totalTime + " units\n");
	     
	     // Part II: Lambdas
	     System.out.println("Sorting tasks by time:");
	     Comparator<Task> intCompare = (t1, t2) -> Integer.compare(t1.getTime(), t2.getTime());
	     jobQueue.sort(intCompare);
	     jobQueue.forEach(task -> System.out.println(task));
	        
	     System.out.println("\nFiltering tasks with time > 5:");
	     Predicate<Task> timeFilter = task -> task.getTime() > 5;
	     ArrayList<Task> filteredTasks = new ArrayList<>();
	     
	     for (Task task : jobQueue) {
	            if (timeFilter.test(task)) {
	                filteredTasks.add(task);
	            }
	        }
	        
	     filteredTasks.forEach(task -> System.out.println(task));
	 }	
}





