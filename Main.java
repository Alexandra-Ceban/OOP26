public class Main {
    public static void main(String[] args){
        Logger.setLevel(LogLevel.INFO);
        ParenthesesValidator input1= new ParenthesesValidator();
          String input_user="()";
         boolean result = input1.isValid(input_user);
          System.out.println(result);
          

        Display product1= new Display("Samsung-22", 2560, 1440, 93f);
        Display lg= new Display("LG-27GP850", 2560, 1440, 109f);
        Display dell= new Display("Dell-P2422H", 1920, 1080, 92f);
         System.out.println(product1.compareSize(dell));
        System.out.println(dell.compareSharpness(lg));
        System.out.println(product1.compareWithMonitor(dell));


                
        
      
        
       
    }
        

    }

