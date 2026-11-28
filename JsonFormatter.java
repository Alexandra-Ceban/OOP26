import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class JsonFormatter implements Formatter {
    

    @Override 
    public String GetData(String name, LogLevel level, String message, Object...args){
          String time=LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
       String filledMsg=FillMethod.fill(message,args);


        return "{\"time\":\"" + escapeJson(time) +
           "\",\"level\":\"" + escapeJson(level.toString()) +
           "\",\"logger\":\"" + escapeJson(name) +
           "\",\"message\":\"" + escapeJson(filledMsg) + "\"}";

    }

    //json transforming
    private String escapeJson(String text) {
    return text
        .replace("\\", "\\\\")
        .replace("\"", "\\\"")
        .replace("\n", "\\n")
        .replace("\r", "\\r")
        .replace("\t", "\\t");
}
    
}
