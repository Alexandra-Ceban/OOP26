import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Config {
    //reaidng the logger.conf
    private Map<String, String> settings= new HashMap<>();

    public static Config load(String fileName) throws IOException{
        Config config= new Config(); //empty hashmap
        try(BufferedReader reader= new BufferedReader( //to read the file
            new FileReader(fileName))) //open file
            {
                String line;
                while((line=reader.readLine())!=null){ //reading 1 line
                  line=line.trim();
                  if(line.isEmpty() || line.startsWith("#")){
                    continue;
                  }
                  String[] parts= line.split("=",2); //splitting in 2 parts
                  String key= parts[0].trim();
                  String value= parts[1].trim();
                  config.settings.put(key,value);  //adding to the list
                }
            }
            return config;
    }

    public String get(String key){
        return settings.get(key);
        //return null if the key is not found
    }

    public String getOr(String key, String DefaultValue){
        return settings.getOrDefault(key, DefaultValue);
    }
}
