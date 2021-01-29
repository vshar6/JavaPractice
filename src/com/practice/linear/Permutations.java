package linear;

import java.util.ArrayList;

public class Permutations {


    public static ArrayList<String> getPerms(String str) {
        if (str == null) return null;
        ArrayList<String> permutations = new ArrayList<String>();
        if (str.length() == 0) { // base case
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0); // get the first char 11 String remainder - str.substring(1); // remove the first char
        String remainder = str.substring(1);
        ArrayList<String> words = getPerms(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                String s = insertCharAt(word, first, j);
                permutations.add(s);
            }
        }
        System.out.println("permutations:"+permutations);
        return permutations;
    }


    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);

        return start + c + end;
    }

    public static void main(String [] args) {
        getPerms("abc");
    }
}
