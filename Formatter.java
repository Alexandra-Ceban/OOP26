import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Formatter {
     private static String format="[%t] [%l] %n: %m %r ";

     public static String GetData(String name, LogLevel level, String message, String additional){
             String time=LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

             String output= format
                 .replace("%t", time)
                 .replace("%n", name)
                 .replace("%l", level.toString())
                 .replace("%m", message)
                 .replace("%r", additional);
               return output;
                
     }
     public static void setFormat(String newformat){
        format=newformat;
     }
}
