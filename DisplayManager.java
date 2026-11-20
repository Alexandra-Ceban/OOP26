import java.util.ArrayList;
import java.util.List;

public class DisplayManager{
     private String name;
     private List<Display> manager= new ArrayList<>();
    
    public DisplayManager(String name){
        this.name=name;
    }
    public void assignDisplay(Display d){
        manager.add(d);
    }
     
    //comparing each element
    public void assist(){
            for(int i=0;i<manager.size()-1; i++){
                Display current= manager.get(i);
                Display next= manager.get(i+1);

                if(current.getppi()<next.getppi()){
                 System.out.println(current.getModel()+" has lower ppi than "+ next.getModel());
                }
                else if(current.getppi()==next.getppi()){
                 System.out.println(current.getModel()+" has equal ppi with "+ next.getModel());
                }
                else{
                 System.out.println(current.getModel()+" has bigger ppi than "+ next.getModel());
                }
            }
    }

    public Display buyDisplay(Display d){
        manager.remove(d);
        return d;
    }
}