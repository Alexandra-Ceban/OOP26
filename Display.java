public class Display {
    
    private String model;
    private int width;
    private int height;
    private float ppi;
    private Logger l2;

     public Display(String model, int width, int height, float ppi, Logger l2){
        this.model=model;
        this.width=width;
        this.height=height;
        this.ppi=ppi;
        this.l2=l2;
        
        l2.trace( "% with % width and % height and % pixels was created",model,width,height,ppi );
     }
     public String getModel(){
      return this.model;
     }
     public Float getPpi(){
      return this.ppi;
     }
     private double diagonal(){
        return Math.sqrt((double)width*width + (double)height*height)/ppi;
     }
     public String compareSize(Display other){
         double first1=this.diagonal();
         double second=other.diagonal();

         String name1 = model + " (" + String.format("%.1f", first1) + "\")";
         String name2 = other.model + " (" + String.format("%.1f", second) + "\")";

         if(first1>second){
            return name1+" is bigger than "+ name2;
         }
         else if (first1< second) {
        return name1 + " is smaller than " + name2;
          } else {
          return name1 + " is the same size as " + name2;
          }

     }

       public String compareSharpness(Display other){
        double p1=this.ppi;
         double p2=other.ppi;

         String name3 = model + " (" + String.format("%.1f", p1) + "\")";
         String name4 = other.model + " (" + String.format("%.1f", p2) + "\")";

         if(p1>p2){
            return name3+" is sharper than "+ name4;
         }
         else if (p1< p2) {
        return name3 + " is not as sharp as " + name4;
          } else {
          return name3 + " is as sharp as " + name4;
          }
     }

       public String compareWithMonitor (Display other){
               int size = Double.compare(diagonal(), other.diagonal());
         int sharp = Float.compare(ppi, other.ppi);
         String verdict = (size > 0 && sharp > 0) ? model + " wins on both"
                        : (size < 0 && sharp < 0) ? other.model + " wins on both"
                        : "Mixed result: pick by size or sharpness";
         return compareSize(other) + "\n" + compareSharpness(other) + "\nVerdict: " + verdict;
}

     }

