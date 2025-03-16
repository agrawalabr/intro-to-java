package partI_II.person;

import java.util.ArrayList;

import partI_II.task.DevelopModule;
import partI_II.task.Task;

public class Developer extends Person {
	public Developer(ArrayList<Task> jobQueue) {
		super(jobQueue);
		}
		
	@Override
	public void startTask(String moduleName, int time) {
		jobQueue.add(new DevelopModule(moduleName, time));	
	}	
}