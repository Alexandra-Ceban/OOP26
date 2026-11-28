import java.util.ArrayList;
import java.util.List;


public class LoggerFactory {
    
    private Config config;
    public LoggerFactory(Config config){
        this.config=config;
    }

    public Logger  create(String name){
        String levelValue=config.getOr("log.level", "INFO");
        LogLevel level= LogLevel.valueOf(
            levelValue.trim().toUpperCase()
        );

        String formatValue= config.getOr("log.format", "pattern");
         Formatter formatter;

    switch (formatValue.trim().toLowerCase()) {

    case "pattern":
        String pattern = config.getOr(
            "log.pattern",
            "[%t] [%l] %n: %m"
        );

        formatter = new PatternFormatter(pattern);
        break;

   

    default:
        throw new ConfigException(
            "Unsupported formatter: " + formatValue
        );
}

    String sinksValue = config.getOr("log.sinks", "console");

    String[] sinkNames = sinksValue.split(",");

    List<Sink> sinks = new ArrayList<>();

    for (String sinkName : sinkNames) {

        switch (sinkName.trim().toLowerCase()) {

            case "console":
                sinks.add(new ConsoleSink());
                break;

            case "file":
                String filename = config.getOr("log.file", "app.log");
                sinks.add(new FileSink(filename));
                break;

            default:
                throw new ConfigException(
                    "Unsupported sink: " + sinkName.trim()
                );
        }
    }
    Sink finalSink;

    if (sinks.size() == 1) {
        finalSink = sinks.get(0);
    } else {
        finalSink = new MultiSkink(sinks);
    }
     
    Logger logger=new Logger(name, level, formatter, finalSink);
       return logger;

    }
    
   



}
