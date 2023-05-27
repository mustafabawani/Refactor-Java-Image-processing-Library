package Logger;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private String logFileName;
    private boolean appendToFile;

    public Logger(String logFileName, boolean appendToFile) {
        this.logFileName = logFileName;
        this.appendToFile = appendToFile;
    }

    public void log(String message) {
        try {
            FileWriter fileWriter = new FileWriter(logFileName, appendToFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(getTimestamp() + " - " + message);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
