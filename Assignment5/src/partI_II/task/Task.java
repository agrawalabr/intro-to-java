package partI_II.task;

public abstract class Task {
    protected String module;
    protected int time;
    
    public Task(String module, int time) {
        this.module = module;
        this.time = time;
    }
    
    public int getTime() {
    	return time;
    }
    
    public abstract void performTask();
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [module=" + module + ", time=" + time + "]";
    }
}