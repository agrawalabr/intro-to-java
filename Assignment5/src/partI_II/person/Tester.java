package partI_II.person;

import java.util.ArrayList;

import partI_II.task.Task;
import partI_II.task.TestModule;

public class Tester extends Person {
	 public Tester(ArrayList<Task> jobQueue) {
	     super(jobQueue);
	 }
	 
	 @Override
	 public void startTask(String moduleName, int time) {
	     jobQueue.add(new TestModule(moduleName, time));
	 }	
}