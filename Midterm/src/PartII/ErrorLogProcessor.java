package PartII;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogProcessor extends LogProcessor {
    
    public ErrorLogProcessor() {
        super("ERROR");
    }
    
    @Override
    public void processLog(String inFile, String outFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(" ERROR [")) {
                    LogEntry entry = parseLogLine(line);
                    if (entry != null) {
                        writer.write(entry.toString());
                        writer.newLine();
                    }
                }
            }
            System.out.println("ERROR logs written to: " + outFile);
            
        } catch (IOException e) {
            System.err.println("Error processing ERROR logs: " + e.getMessage());
        }
    }
}