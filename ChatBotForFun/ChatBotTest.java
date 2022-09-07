package ChatBotForFun;

import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
//import java.util.Iterator;
import java.util.PriorityQueue;
//import java.util.*;;
public class ChatBotTest extends SpellCheker
{
    public static void main(String[] args) throws FileNotFoundException
    {
        SpellCheker spell =  new SpellCheker();
            //keyboard
            char nom[] = {'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p', 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'z', 'x', 'c', 'v', 'b', 'n', 'm'};
            //array for frequancy of dictiionary words
            File Dictionary = new File("C:\\Users\\Viktorija\\Documents\\UNI\\VSCODE\\java\\ChatBotForFun\\dictionary.txt");
            Scanner read = new Scanner(Dictionary);
            int cost = 4;
            String closestWord = "";
            String checkWord = "thwre";
            String finalWord = "";
            PriorityQueue<String> pq = new PriorityQueue<>();
            //*to do: add frequancy to th edictionary file */
            /*we check every letter in the word then when there is inconsistancy we check the nearby letter
            if the distance is incorrect check the other letters 
            if correct smaller search time
            */
            while(read.hasNextLine())
            {
                closestWord = read.next();
                int tempCost = spell.MainCost(checkWord , closestWord );
                
                if(tempCost <= cost)
                {
                    
                        pq.add(closestWord);
                    
                    //pq.add(closestWord);
                    finalWord = closestWord;
                    cost = tempCost;
                }
            }
            //System.out.println(pq);
            int index = 0;
            String temp = "";
            int i = 0;
            while(!pq.isEmpty() && pq.size() > 1)
            {
                if(checkWord.charAt(index) == pq.peek().charAt(index))
                {
                    temp += checkWord.charAt(index);
                }
                else
                {
                    for(i = 0; i < nom.length; ++i)
                    {
                        if(checkWord.charAt(index) == nom[i])
                        {
                            //System.out.println(i);
                            break;
                        }
                    }
                    if(pq.peek().contains(temp + nom[i - 1]))
                    {
                        finalWord = pq.peek();
                        //System.out.println("i - 1");
                        break;
                    }
                    else if(pq.peek().contains(temp + nom[i + 1]))
                    {
                        finalWord = pq.peek();
                        //System.out.println("i + 1");
                        break;
                    }
                    else
                    {
                        index = 0;
                        pq.poll();
                    }  
                }
                ++index;
            }
            System.out.println(finalWord);
            

            read.close();
    }    
}
