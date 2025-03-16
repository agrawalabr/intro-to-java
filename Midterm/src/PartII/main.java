package PartII;

public class main {
	public static void main(String[] args) {
		String inputFile = "src/Hadoop_2k.log";
	    String warnOutputFile = "src/Hadoop_WARN.log";
	    String errorOutputFile = "src/Hadoop_ERROR.log";

	    WarnLogProcessor warnProcessor = new WarnLogProcessor();
	    warnProcessor.processLog(inputFile, warnOutputFile);
	    
	    ErrorLogProcessor errorProcessor = new ErrorLogProcessor();
	    errorProcessor.processLog(inputFile, errorOutputFile);
    }
}