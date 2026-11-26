public class ConsoleSink implements Sink {
    
    @Override 
         public void write(String line){
        System.out.println(line);
    }
    
}
