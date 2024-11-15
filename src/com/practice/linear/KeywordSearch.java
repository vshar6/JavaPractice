package linear;

import java.io.*;
import java.util.*;

public class KeywordSearch {

    static List<String> stopwords = Arrays.asList("a",  "all", "am", "an",
            "and", "any", "are", "as", "at", "be", "do", "does",
            "either", "else", "ever", "every", "for", "from", "get", "got",
            "had", "has", "have", "he", "her", "hers", "him", "his", "how",
            "however", "i", "if", "in", "into", "is", "it", "its", "just",
            "least", "let", "like", "who", "whom", "why",
            "will", "with", "would", "yet", "you");


    static Map<String, List<Tuple>> invertedIndex = new HashMap<>();


    // createIndex
    public static void buildIndex(File[] files) throws IOException{
        int position =0;
        for(File file : files) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            for(String line = bufferedReader.readLine();line!=null; line = bufferedReader.readLine()) {
                String [] words = line.split("\\W+");             //tokenize the word
                position++;
                for(String _word : words) {
                    String word = _word.toLowerCase();  // Normalization. Step 1 - Lower case

                    if(stopwords.contains(word)) {
                        continue;
                    }

                    List<Tuple> tuples = invertedIndex.get(word);
                    Tuple tuple =  new Tuple(file,position);
                    if(tuples.isEmpty()) {                      // the word is new in the index
                        tuples = new LinkedList<>();
                       // tuples.add(tuple);
                        invertedIndex.put(word, tuples);
                    }                                    // the word exists in the index
                        tuples.add(tuple);// the word exists in the index
                }

            }

        }


    }



    //searchfiles
    public static Set<String> search(List<String> words) {

        Set<String> answer = new HashSet<>();
        for(String _word:words) {
            String word = _word.toLowerCase();

            if(!invertedIndex.get(word).isEmpty()) {
                for(Tuple tuple:invertedIndex.get(word)) {
                    answer.add(tuple.file.getPath());
                }
            }

        }

        return answer;
    }



    public static void main(String [] args) {

    }

    private static class Tuple {
        File file;
        int position;

        public Tuple(File fileNo, int position) {
            this.file=fileNo;
            this.position = position;
        }
}


}