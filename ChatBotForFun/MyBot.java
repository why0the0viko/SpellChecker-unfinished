package ChatBotForFun;
import java.util.*;
//the dumbest one 
public class MyBot
{
    //We add a memory which now will be only a hashmap
    private HashMap<String, String > goodmemory = new HashMap<String, String>();
    //private HashMap<String, String >angrymemory = new HashMap<String, String>();
    //private int angerMeter;

    public MyBot()
    {
        //these are starting phrases
        //angerMeter = 0;
        goodmemory.put("hi", "hello, amigo!");
        goodmemory.put("hello", "hi");
        goodmemory.put("how are you!", "terrific, cuz im talking to you, how are you tho");
    }
    
}
