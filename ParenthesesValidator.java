import java.util.ArrayDeque;
import java.util.Deque;

public class ParenthesesValidator {
   private final Logger first;
    
   public ParenthesesValidator(Logger first){
    this.first=first;
   }

   public boolean isValid(String s){
    Deque <Character> stack= new ArrayDeque<>();
    for(int i=0; i<s.length();i++){
      char c= s.charAt(i);

   
      if(c=='('){
        stack.push(c);
        first.trace("Opening paranthesis tracked %",c);

      }
      else if(c==')'){
        if(stack.isEmpty())
          {
         first.warn("Closing paranthesis detected %"+" No opening paranthesis before", c);
         return false;
         }  
     char top=stack.pop();

   if(!isMatchingPair(top,c)){
      first.warn("Mismatched pair % "+" doesnt have a matching %", top,c);
       return false;
    }
   first.info("Matching pair found % %",top, c);
        }
    }
    if (!stack.isEmpty()) {
            first.warn("Unmatched opening parentheses remaining.");
            first.error("Invalid input %",s);
            return false;
        }

        first.info("The final result is: TRUE");
        return true;
    }
     
//charAt()

 private boolean isMatchingPair(char open, char closed){
   return(open =='(' && closed==')');
 }
}


