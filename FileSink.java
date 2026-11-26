import java.io.FileWriter;
import java.io.IOException;

import javax.management.RuntimeErrorException;
public class FileSink implements Sink {
     

    private final String fileName;
    
    public FileSink(String fileName){
        this.fileName=fileName;
    }
    
    
    @Override 
    public void write(String line){
       try(FileWriter writer = new FileWriter(fileName, true)){
           writer.append(" "+line);
       } 
       catch(IOException e){
        throw new RuntimeException("Could not write to file",e);
       }

    }

   
}
