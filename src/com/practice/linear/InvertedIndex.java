package linear;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {

    List<String> stopwords = Arrays.asList("a",  "all", "am", "an",
            "and", "any", "are", "as", "at", "be", "do", "does",
            "either", "else", "ever", "every", "for", "from", "get", "got",
            "had", "has", "have", "he", "her", "hers", "him", "his", "how",
            "however", "i", "if", "in", "into", "is", "it", "its", "just",
            "least", "let", "like", "who", "whom", "why",
            "will", "with", "would", "yet", "you");

    Map<String, List<Tuple>> index = new HashMap<String, List<Tuple>>();
    List<String> files = new ArrayList<String>();


    /*
    public void indexFiles(File file) throws IOException {
        int fileno = files.indexOf(file.getPath());
        if (fileno == -1) {
            files.add(file.getPath());
            fileno = files.size() - 1;
        }

        int pos = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            for(String _word: line.split("\\W+")) {
                String word = _word.toLowerCase();

                if(stopwords.contains(word)) {
                    continue;
                } else {
                    if(null==index.get(word)) {
                        List<Tuple> tuples = new LinkedList<>();
                        index.put(word, tuples);
                    }
                    List<Tuple> tuples = index.get(word);
                    tuples.add(new Tuple(fileno, pos));
                }
            }
        }
    }*/


//    *************************** Practice - please ignore ************************************
//    public void indexFiles(final File file) throws IOException {
//        int fileno = files.indexOf(file.getPath());
//        if (fileno == -1) {
//            files.add(file.getPath());
//            fileno = files.size() - 1;
//        }
//
//        int position = 0;
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        for(String line = reader.readLine(); line!= null; line = reader.readLine()) {
//            String[] _words = line.split("\\W+");         //tokenization
//            for(String _word: _words) {
//                String word = _word.toLowerCase();              //normalization - step 1 (lower casing)
//                position++;
//
//                if(stopwords.contains(word)) {
//                    continue;
//                } else {
//                    Tuple tuple = new Tuple(fileno,position);
//                    List<Tuple> tuples = index.get(word);
//                   if(tuples==null) {
//                       tuples = new LinkedList<>();
//                       index.put(word, tuples);
//                   }
//                    tuples.add(tuple);
//                }
//            }
//        }
//    }
//     ****************************************************************************************




    public void indexFile(File file) throws IOException {
        int fileno = files.indexOf(file.getPath());
        if (fileno == -1) {
            files.add(file.getPath());
            fileno = files.size() - 1;
        }

        int position = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {        // read step for the line
            for (String _word : line.split("\\W+")) {                                   //tokenizing step for the line
                String word = _word.toLowerCase();                                             // word to lower case
                position++;
                if (stopwords.contains(word))
                    continue;
                List<Tuple> tuples = index.get(word);
                if (tuples == null) {
                    tuples = new LinkedList<Tuple>();
                    index.put(word, tuples);
                }
                tuples.add(new Tuple(fileno, position));
            }
        }
        System.out.println("indexed " + file.getPath() + " " + position + " words");
    }




//    public void searchs(List<String> words) {
//
//        for(String _word: words) {
//            Set<String> answers = new HashSet<>();
//            String word = _word.toLowerCase();
//            if(null!= index.get(word)) {
//                List<Tuple> tuples = index.get(word);
//                for (Tuple tuple : tuples) {
//                    answers.add(String.valueOf(tuple.fileno));
//                }
//            }
//        }
//    }



    public Set<String> search(List<String> words) {
        Set<String> answer = null;
        for (String _word : words) {
            answer = new HashSet<String>();
            String word = _word.toLowerCase();
            List<Tuple> tuples = index.get(word);
            if (tuples != null) {
                for (Tuple t : tuples) {
                    answer.add(files.get(t.fileno));
                }
            }
            System.out.print(word);
            for (String f : answer) {
                System.out.print(" " + f);
            }
            System.out.println("");
        }

       return answer;
    }

    public void multiKeywordSearch(String phrase, String mode) {
        if(mode.equals("AND")) {        // use intersection
            andSearch(phrase);
        } else {
            orSearch(phrase);           // use union
        }
    }

    public void multiKeywordSearch(String phrase) {
        andSearch(phrase);
    }

    private void andSearch(String phrase) {
        Set<String> answer = new HashSet<>();
        String[] phraseTokens = phrase.split("\\W+");
        for(String phraseToken: phraseTokens) {
            answer.retainAll(search(Arrays.asList(phraseToken)));
        }
    }

    private void orSearch(String phrase) {
        Set<String> answer = new HashSet<>();
        String[] phraseTokens = phrase.split("\\W+");
        for(String phraseToken: phraseTokens) {
            answer.addAll(search(Arrays.asList(phraseToken)));
        }
    }


    public static void main(String[] args) {

        try {
            InvertedIndex idx = new InvertedIndex();
            for (int i = 1; i < args.length; i++) {
                idx.indexFile(new File(args[i]));
            }
            idx.search(Arrays.asList(args[0].split(",")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Tuple {
        private int fileno;
        private int position;

        public Tuple(int fileno, int position) {
            this.fileno = fileno;
            this.position = position;
        }
    }
}