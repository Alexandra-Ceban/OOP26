import java.io.File;
import java.util.Scanner;

public class CommandReader {
    private Logger l3;
    Scanner file =new Scanner(new File("shop-monday.txt"));
    while(file.hasNext()){
        String command=file.next();
        if(command.startsWith("#"){
            //ignore whole comment
      file.nextLine();
        }
        else if(command.equals("MANAGER")){
            String name= file.next();
        }
    }

}
