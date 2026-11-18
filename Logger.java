


public  class Logger{

       private String name;
       private static LogLevel levelcurrent=LogLevel.INFO;
       private Formatter formatNew;
       private ConsoleSink sink;
       
      
       //composition quick logger with 0 setup
       //we build internally the formatter and consolesink
      public Logger(String name){
       this.name=name;
       this.formatNew=new Formatter();
       this.sink= new ConsoleSink();
      
      }

      //aggregation- plug in customed shared parts
      public Logger(String name, Formatter formatNew, ConsoleSink sink ){
           this.name = name;
           this.formatNew = formatNew;
           this.sink = sink;
      }

      //ensure encapsulation , we can access variables without changing them
      public String getName(){
          return name;
      }

     public static void setLevel(LogLevel newLevel){
        levelcurrent=newLevel;
     
     }
     public static LogLevel getLevel(){
          return levelcurrent;
     }

     
    
     
     
     public void log(LogLevel messLevel, String message, Object...args){
       if(messLevel.ordinal()<levelcurrent.ordinal()){
            return ;
       }

       String line = formatNew.GetData(name, messLevel, message);
      
        sink.write(line);
     }

     

       


     public void trace(String message, Object...args){
     
      log(LogLevel.TRACE, message,args);
     }

     public void info(String message,Object...args){
      
      log(LogLevel.INFO, message,args);

     }

     public void warn(String message,Object...args){
     
     log(LogLevel.WARN, message,args);

     }

     public void error(String message,Object...args){
     
     log(LogLevel.ERROR, message,args);

     }
}
