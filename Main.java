
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<DisplayManager> managers= new ArrayList<>();
     private static final List<Display> displays= new ArrayList<>();
     private static Logger parseLog;
      private static Logger mgrLog;
       private static Logger dispLog;
    public static void main(String[] args) throws IOException{
        
       
          
           //DAY5
          Formatter f = new PatternFormatter();
            ConsoleSink s = new ConsoleSink();
             Logger validatorLogger = new Logger("ParenthesesValidator", LogLevel.TRACE,f, s);
           

        ParenthesesValidator input1= new ParenthesesValidator(validatorLogger);
          String input_user="((00)))";
         boolean result = input1.isValid(input_user);
          System.out.println(result);

            mgrLog = new Logger("DisplayManager", LogLevel.INFO, f, s);
            dispLog = new Logger("Display", LogLevel.WARN, f, s);
            Logger readerLog = new Logger("CommandReader", LogLevel.INFO, f, s);
            parseLog= new Logger("ParseLogger", LogLevel.ERROR,f,s);
        //DAY4
        DisplayManager m1= new DisplayManager("DisplayManager1", dispLog);
        DisplayManager m2= new DisplayManager("Displaymanager2", dispLog);

        managers.add(m1);
        managers.add(m2);
        Display lg = new Display("LG=877", 40, 122, 722, mgrLog);
        Display samsung = new Display("Samsung-9872", 2092, 107, 112f, mgrLog);

        displays.add(lg);
        displays.add(samsung);

        m1.assignDisplay(samsung);
        m1.assignDisplay(lg);
        m2.assignDisplay(samsung);
         m1.assist();
        Display bought=m1.buyDisplay(samsung);
        
       //DAY6
      
       CommandReader reader= new CommandReader(readerLog);
       List <String> lines= reader.readFile("shop-monday.txt");
       if (lines!=null){
        for(int i=0;i<lines.size(); i++){
            //liniile incep de la rand 1
          parseCommand( lines.get(i), i+1);
    
        }

        
       }
     
       //testing Config
       Config config= Config.load("logger.conf");
       LoggerFactory factory= new LoggerFactory(config);
       Logger logger=factory.create("Dispatch");
        
       
    }
     private static boolean hasArgs(String[] a, int count, String usage, int LineNumber){
        if (a.length==count) return true;
        parseLog.error("Line %: Usage %",LineNumber, usage);
        return false;

     }

     private static DisplayManager manager(String name, int LineNumber){
        for (DisplayManager m:managers){
            if (m.getName().equals(name)) return m;}
            parseLog.error("Line %: Unknown manager: %",LineNumber, name);
            return null;
        
     }

     private static Display display(String model, int LineNumber){
        for (Display d: displays){
             if(d.getModel().equals(model)) return d;}

        parseLog.error("Line %: Uknown display: %",LineNumber, model);
        return null;
     }

     private static boolean managerExist(String name){
        for(DisplayManager a: managers){
          if(a.getName().equals(name)){
            return true;
          }
        
        }
        return false;
     }

     private static boolean displayExist(String model){
        for(Display w: displays){
          if(w.getModel().equals(model)){
            return true;
          }
        
        }
        return false;
     }

    static void parseCommand(String line, int lineNumber){
        line=line.trim();
        if(line.isEmpty() || line.startsWith("#")) return;
        try{
        String[] a= line.split("\\s+");
        switch(a[0].toUpperCase()){
            case "MANAGER":
                if(!hasArgs(a,2,"MANAGER <name>",lineNumber) ) return;
                 if( managerExist(a[1])){
                    parseLog.warn("Line %: manager already exists %", lineNumber, a[1]);
                 }
                 else{
                
                
                    managers.add(new DisplayManager(a[1], mgrLog));}
                break;

            case "DISPLAY":
                if(!hasArgs(a,5, "DISPLAY <model> <width> <height> <ppi>", lineNumber)) return;
                if (displayExist(a[1])){
                     parseLog.warn("Line %: This display already exists %", lineNumber, a[1]);
                    }
                    else{
                    addDisplay(a, lineNumber);}
                    break;
            case "ASSIGN":
                if(!hasArgs(a, 3, "ASSIGN <display>  <manager> ", lineNumber)) return;
                DisplayManager m=manager(a[2], lineNumber);
                Display d= display(a[1], lineNumber);
                if(m!=null && d!=null) m.assignDisplay(d);
                break;
            case "COMPARE":
                if (!hasArgs(a, 3, "COMPARE <display1> <display2>",  lineNumber)) return;
                Display w = display(a[1], lineNumber);
                Display b = display(a[2], lineNumber);
                if (w != null && b != null) System.out.println(w.compareWithMonitor(b));
                break;
            case "ASSIST" :
                if (!hasArgs(a, 2, "ASSIST <manager>",  lineNumber)) return ;
                DisplayManager o = manager(a[1],  lineNumber);
                if (o != null){
                   if (!o.hasDisplay()) {
                   parseLog.warn("Line %: Manager % has no displays to assist",
                  lineNumber, a[1]);
                    } else {
                        o.assist();
                    } }

                break;
        
            case "BUY":
                if (!hasArgs(a, 3, "BUY  <display> <manager>", lineNumber)) return;
                DisplayManager v = manager(a[2], lineNumber);
                Display s= display(a[1], lineNumber);
                if (v != null && s != null){
                    if (v.hasDisplay(s)) v.buyDisplay(s);
                    else {parseLog.error("Line %: Such manager % and display % were not assigned", lineNumber, a[2],a[1]);} }
                break;
        
            default: parseLog.error("Line %: Unknown command: %",lineNumber, a[0]); break;
                } 
            } 
            
        
    
    catch(RuntimeException e){
        parseLog.error("Line %: This command % does not exist", lineNumber, e.getMessage());
    }
}
    


    private static void addDisplay(String[] a, int  lineNumber){
        try{
            
            displays.add(new Display(a[1],Integer.parseInt(a[2]),
        Integer.parseInt(a[3]), Float.parseFloat(a[4]), dispLog));
        }
        catch(NumberFormatException e){
            parseLog.error("Line %: Invalid number in DISPLAY command",  lineNumber);
        }
    }

}
        

    


