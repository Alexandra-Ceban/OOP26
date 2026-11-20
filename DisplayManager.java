import java.util.ArrayList;
import java.util.List;

public class DisplayManager{
     private String name;
     private Logger l1;
     private List<Display> manager= new ArrayList<>();
    
    public DisplayManager(String name, Logger l1){
        this.name=name;
        this.l1=l1;
    }
    public void assignDisplay(Display d){
        manager.add(d);
        l1.trace("Display % assigned to %!", d.getModel(), name);
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

    public  Display buyDisplay(Display d){
        if(!manager.remove(d)){
            l1.error("There was an error while buying %", d.getModel());
            return null;
        }
        
        l1.info(" Display % was bought!", d.getModel());

        if(manager.isEmpty()){
            l1.warn("Manager % has no displays left", name);
        }
        return d;
    }
}