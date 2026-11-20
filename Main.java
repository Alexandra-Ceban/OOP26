import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        
       
          
           //DAY5
          Formatter f = new Formatter();
            ConsoleSink s = new ConsoleSink();
             Logger validatorLogger = new Logger("ParenthesesValidator", f, s);
            Logger.setLevel(LogLevel.TRACE);

        ParenthesesValidator input1= new ParenthesesValidator(validatorLogger);
          String input_user="((00)))";
         boolean result = input1.isValid(input_user);
          System.out.println(result);

            Logger mgrLog = new Logger("DisplayManager", f, s);
            Logger dispLog = new Logger("Display", f, s);
            Logger readerLog = new Logger("CommandReader", f, s);
        //DAY4
        DisplayManager m1= new DisplayManager("DisplayManager1", dispLog);
        DisplayManager m2= new DisplayManager("Displaymanager2", dispLog);
        Display lg = new Display("LG=877", 40, 122, 722, mgrLog);
        Display samsung = new Display("Samsung-9872", 2092, 107, 112f, mgrLog);
        m1.assignDisplay(samsung);
        m1.assignDisplay(lg);
        m2.assignDisplay(samsung);
         m1.assist();
        Display bought=m1.buyDisplay(samsung);
        
       //DAY6
      
       CommandReader reader= new CommandReader(readerLog);
       List <String> lines= reader.readFile("shop-monday.txt");
       if (lines!=null){
        for(int i=0;i<lines.size(); i++){
            //liniile incep de la rand 1
       System.out.println((i+1)+ ": "+ lines.get(i));
        }
       }

        
       
    }
        

    }

