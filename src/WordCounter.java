import java.io.File;
import java.io.FileWriter;
import java.util.*;


public class WordCounter {

    public static void main(String[] args) throws Exception {
        File file = new File("words.txt");
        Scanner fileInput = new Scanner(file);
        
        ArrayList<String> words = new ArrayList<String>();
        ArrayList<Integer> wordCount = new ArrayList<Integer>();

        //Counts the words
        while(fileInput.hasNext()){
            String checkWords = fileInput.next();
            //Checks if the index contains an already existing existing and increases the value
            if (words.contains(checkWords)){
                int place = words.indexOf(checkWords);
                wordCount.set(place, wordCount.get(place) + 1);
            //If the word does not exist it will add it so it can be counted
            } else {
                words.add(checkWords);
                wordCount.add(1);
            }
        }
        fileInput.close();
        


    //This part wll write the already existing file "words.txt" to a file of the users choice with the words counted
    Scanner scnr = new Scanner(System.in);
    String filename = scnr.next();
    FileWriter fileWriter = new FileWriter(filename);
        for (int i = 0; i < words.size(); i++){
            fileWriter.write(words.get(i) + ": " + wordCount.get(i) + "\n");
            
        }
        fileWriter.close();
        scnr.close();
    }

    }