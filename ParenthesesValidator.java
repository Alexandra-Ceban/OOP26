public class ParenthesesValidator {
    Logger first=new Logger("Parentheses");

    public boolean  isValid (String input_user){
        int balance=0;
         for(int i=0; i<input_user.length();i++){
          char current=input_user.charAt(i);

          if(current=='('){
             balance++;
             first.trace(" Opening parenthesis found.\n");
          }
          else if(current==')'){

            if(balance==0){
              first.trace("Detailed info");
              first.info("Final result is: FALSE");
              first.warn("Closing parenthesis has no opening match.");
              first.error(" Invalid input "+ input_user);
              return false;
            }
            balance--;
            first.info(" Matching pair found");
          }
         }

           boolean result=balance==0;

           if(result){
            first.info("The final result is: TRUE");
           }
           else{
            first.info("The final result is: FALSE");
            first.error("Invalid input: " + input_user
            + ". There are unmatched opening parentheses.");
           }
           return result;
    }

}


