package PartII;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class LogProcessor {
    public String targetSeverity;
    
    public LogProcessor(String targetSeverity) {
        this.targetSeverity = targetSeverity;
    }
    
    public abstract void processLog(String inFile, String outFile);
    
    public LogEntry parseLogLine(String logLine) {
        Pattern pattern = Pattern.compile("(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2},\\d{3})\\s+(\\w+)\\s+\\[(.*?)\\]\\s+(.*)");
        Matcher matcher = pattern.matcher(logLine);
        
        if (matcher.find()) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
                return new LogEntry(sdf.parse(matcher.group(1)), matcher.group(2), matcher.group(3), matcher.group(4));
            } 
            catch (ParseException e) {
                System.err.println("Error parsing date: " + e.getMessage());
            }
        }
        return null;
    }
}
