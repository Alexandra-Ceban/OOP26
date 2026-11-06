import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public  class Logger{

       private String name;
       private static LogLevel levelcurrent=LogLevel.INFO;
       private static String format="[%t] [%l] %n: %m %r ";

       
      
      public Logger(String name){
       this.name=name;
      
      }
     public static void setLevel(LogLevel newLevel){
        levelcurrent=newLevel;
     
     }

     public  static void setFormat(String newFormat){
        format=newFormat;
     }
    

     private void log(LogLevel messLevel, String message){
       if(messLevel.ordinal()<levelcurrent.ordinal()){
            return ;
       }

       String time=LocalTime.now().format(
            DateTimeFormatter.ofPattern("HH:mm:ss")
       );
        String additional = getAdditionalMessage(messLevel);
      
       String output=format
                   .replace("%t",time)
                   .replace("%n",name)
                   .replace("%m",message)
                   .replace("%l",messLevel.toString())
                   .replace("%r",additional);
                   

       System.out.println(output);
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


     public void trace(String message){
     
      log(LogLevel.TRACE, message);
     }

     public void info(String message){
      
      log(LogLevel.INFO, message);

     }

     public void warn(String message){
     
     log(LogLevel.WARN, message);

     }

     public void error(String message){
     
     log(LogLevel.ERROR, message);

     }
}
