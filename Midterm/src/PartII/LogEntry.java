package PartII;

import java.text.SimpleDateFormat;
import java.util.Date;

class LogEntry {
    private Date date;
    private String severity;
    private String module;
    private String message;
    
    public LogEntry(Date date, String severity, String module, String message) {
        this.date = date;
        this.severity = severity;
        this.module = module;
        this.message = message;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
        return String.format("%s %s [%s] %s", severity, sdf.format(date), module, message);
    }
}