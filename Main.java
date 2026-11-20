import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<DisplayManager> managers= new ArrayList<>();
     private static final List<Display> displays= new ArrayList<>();
     private static Logger parseLog;
      private static Logger mgrLog;
       private static Logger dispLog;
    public static void main(String[] args){
        
       
          
           //DAY5
          Formatter f = new Formatter();
            ConsoleSink s = new ConsoleSink();
             Logger validatorLogger = new Logger("ParenthesesValidator", f, s);
            Logger.setLevel(LogLevel.TRACE);

        ParenthesesValidator input1= new ParenthesesValidator(validatorLogger);
          String input_user="((00)))";
         boolean result = input1.isValid(input_user);
          System.out.println(result);

            mgrLog = new Logger("DisplayManager", f, s);
            dispLog = new Logger("Display", f, s);
            Logger readerLog = new Logger("CommandReader", f, s);
            parseLog= new Logger("ParseLogger",f,s);
        //DAY4
        DisplayManager m1= new DisplayManager("DisplayManager1", dispLog);
        DisplayManager m2= new DisplayManager("Displaymanager2", dispLog);
        Display lg = new Display("LG=877", 40, 122, 722, mgrLog);
        Display samsung = new Display("Samsung-9872", 2092, 107, 112f, mgrLog);
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
       System.out.println((i+1)+ ": "+ lines.get(i));
    
        }

        for(String line:lines){
            parseCommand(line);
        }
       }



        
       
    }
     private static boolean hasArgs(String[] a, int count, String usage){
        if (a.length==count) return true;
        parseLog.error("Usage %", usage);
        return false;

     }

     private static DisplayManager manager(String name){
        for (DisplayManager m:managers){
            if (m.getName().equals(name)) return m;}
            parseLog.error("Unknown manager: %", name);
            return null;
        
     }

     private static Display display(String model){
        for (Display d: displays){
             if(d.getModel().equals(model)) return d;}

        parseLog.error("Uknown display: %", model);
        return null;
     }

    static void parseCommand(String line){
        line=line.trim();
        if(line.isEmpty() || line.startsWith("#")) return;
        String[] a= line.split("\\s+");
        switch(a[0].toUpperCase()){
            case "MANAGER":
                if(hasArgs(a,2,"MANAGER <name>"))
                    managers.add(new DisplayManager(a[1], mgrLog));
                break;

            case "DISPLAY":
                if(hasArgs(a,5, "DISPLAY <model> <width> <height> <ppi>")){
                    addDisplay(a);}
                    break;
            case "ASSIGN":
                if(!hasArgs(a, 3, "ASSIGN <manager> <display>")) return;
                DisplayManager m=manager(a[1]);
                Display d= display(a[2]);
                if(m!=null && d!=null) m.assignDisplay(d);
                break;
            case "COMPARE":
                if (!hasArgs(a, 3, "COMPARE <display1> <display2>")) return;
                Display w = display(a[1]);
                Display b = display(a[2]);
                if (w != null && b != null) System.out.println(w.compareWithMonitor(b));
                break;
            case "ASSIST" :
                if (!hasArgs(a, 2, "ASSIST <manager>")) return ;
                DisplayManager o = manager(a[1]);
                if (o != null) o.assist();
                break;
        
            case "BUY":
                if (!hasArgs(a, 3, "BUY <manager> <display>")) return;
                DisplayManager v = manager(a[1]);
                Display s= display(a[2]);
                if (v != null && s != null) v.buyDisplay(s);
                break;
        
            default: parseLog.error("Unknown command: %", a[0]); break;
            
            
        }
    }

    private static void addDisplay(String[] a){
        try{
            displays.add(new Display(a[1],Integer.parseInt(a[2]),
        Integer.parseInt(a[3]), Float.parseFloat(a[4]), dispLog));
        }
        catch(NumberFormatException e){
            parseLog.error("Invalid number is DISPLAY command");
        }
    }
        

    }

