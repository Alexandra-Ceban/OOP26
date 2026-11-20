import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class CommandReader {
    private Logger l3;
   public CommandReader(Logger l3){
    this.l3=l3;
   }

   public List<String> readFile(String filePath){
    List<String> lines= new ArrayList<>();
    try(Scanner file=new Scanner(new File(filePath))){
        while(file.hasNextLine()){
            String line= file.nextLine();
            lines.add(line);
        }
    }
    catch(FileNotFoundException e){
        l3.error("File % was not found", filePath);
        return null;
    } 
    return lines;
  }
}
