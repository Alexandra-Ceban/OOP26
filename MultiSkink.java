import java.util.List;

public class MultiSkink implements Sink {
    

   private final List<Sink> myList;
   public MultiSkink(List<Sink> myList){
    //unmodifiable copy of the list
       this.myList=List.copyOf(myList);
   } 

    @Override 
    public void write(String line){
        for(Sink sink: myList){
            sink.write(line);
        }

   }
   
}
