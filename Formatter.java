import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Formatter {
 //no static, each format variable gets its own space in memory
   private String format;


   //used in Logger1 constructor , automatically with the setup below
   public Formatter(){
     this.format="[%t] [%l] %n: %m %r ";
   }
   public Formatter(String format){
      this.format=format;
   }


   public  void setFormat(String newformat){
        this.format=newformat;
     }
   

     public  String GetData(String name, LogLevel level, String message){
             String time=LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));


             String additional = getAdditionalMessage(level);
             String output= format
                 .replace("%t", time)
                 .replace("%n", name)
                 .replace("%l", level.toString())
                 .replace("%r", additional)
                 .replace("%m", message);
               return output;
                
     }
     

     private String getAdditionalMessage(LogLevel messLevel){
           
          String [] messages;

      switch(messLevel){
          case TRACE: 
             messages=new String[]{
                    " Something ",
                    " Another thing",
                    " News"
               };
             break;

          case INFO:
                 messages=new String[]{
                    " Here is your result",
                    " Operation completed" ,
                    " Everything looks good"
               };
               break;

          case WARN:
                messages=new String[]{
                    " Might check again",
                    " Not ready for submitting" ,
                    " Take another look"
               };
               break;

          case ERROR:
                 messages=new String[]{
                    " Additional error",
                    " Not working" ,
                    " Failed"
               };
               break;
          default:
               return " ";
      }
      int random=ThreadLocalRandom.current().nextInt(messages.length);
        return messages[random];
     }
}
