import java.util.ArrayList;
import java.util.List;

public class DisplayManager{
     private String name;
     private Logger l1;
     private List<Display> assignedDisplays= new ArrayList<>();
    
    public DisplayManager(String name, Logger l1){
        this.name=name;
        this.l1=l1;
        l1.trace("A display was created %!", name);
    }
    public void assignDisplay(Display d){
        if(assignedDisplays.contains(d)){
            l1.warn("Display % is already assigned to %!", d.getModel(), name);
        }
        else{
        assignedDisplays.add(d);
        l1.trace("Display % assigned to %!", d.getModel(), name); }
    }
    public String getName(){
        return name;
    }

    public boolean hasDisplay(Display d){
        return assignedDisplays.contains(d);
    }
    
     public boolean hasDisplay() {
        return !assignedDisplays.isEmpty();
      }

     
     
    //comparing each element
    public void assist(){
            for(int i=0;i<assignedDisplays.size()-1; i++){
                System.out.println(assignedDisplays.get(i).compareWithMonitor(assignedDisplays.get(i + 1)));
            }
    }

    public  Display buyDisplay(Display d){
        if(!assignedDisplays.remove(d)){
            l1.error("There was an error while buying %", d.getModel());
            return null;
        }
        
        l1.info(" Display % was bought!", d.getModel());

        if(assignedDisplays.isEmpty()){
            l1.warn("Manager % has no displays left", name);
        }
        return d;
    }
}