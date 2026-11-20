public class Main {
    public static void main(String[] args){
        Logger.setLevel(LogLevel.INFO);
        ParenthesesValidator input1= new ParenthesesValidator();
          String input_user="((00)))";
         boolean result = input1.isValid(input_user);
          System.out.println(result);
          

        
        DisplayManager m1= new DisplayManager("manager1");
        DisplayManager m2= new DisplayManager("manager2");
        Display lg = new Display("LG-272", 2892, 177, 002f);
        Display samsung = new Display("Samsung-9872", 2092, 107, 112f);
        m1.assignDisplay(samsung);
        m1.assignDisplay(lg);
        m2.assignDisplay(samsung);
         m1.assist();
        Display bought=m1.buyDisplay(samsung);
        
        System.out.println("Bought: "+bought.getModel());
       





                
        
      
        
       
    }
        

    }

