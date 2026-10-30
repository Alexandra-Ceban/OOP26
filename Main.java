public class Main {
    public static void main(String[] args){
        
        Logger.setLevel(LogLevel.INFO);
         Logger.setFormat("%n [%l] %m %r");
        ParenthesesValidator input1= new ParenthesesValidator();
          String input_user="())(()";
         boolean result = input1.isValid(input_user);
          System.out.println(result);
        
         
        
       
    }
        

    }

