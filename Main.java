public class Main {
    public static void main(String[] args){
        Logger.setLevel(LogLevel.TRACE);
        ParenthesesValidator input1= new ParenthesesValidator();
          String input_user="((00)))";
         boolean result = input1.isValid(input_user);
          System.out.println(result);
          
           //DAY5
           Formatter f1= new Formatter();
           ConsoleSink s1= new ConsoleSink();
           Logger managerLogger = new Logger("Manager", f1, s1);
        //DAY4
        DisplayManager m1= new DisplayManager("Manager1", managerLogger);
        DisplayManager m2= new DisplayManager("manager2", managerLogger);
        Display lg = new Display("LG=877", 40, 122, 722, managerLogger);
        Display samsung = new Display("Samsung-9872", 2092, 107, 112f, managerLogger);
        m1.assignDisplay(samsung);
        m1.assignDisplay(lg);
        m2.assignDisplay(samsung);
         m1.assist();
        Display bought=m1.buyDisplay(samsung);
        
       
       
      





                
        
      
        
       
    }
        

    }

