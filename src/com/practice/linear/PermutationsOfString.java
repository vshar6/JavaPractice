package linear;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {

    public List<String> getPermutations(final String str) {

        if(str == null) {
            return null;
        }

        List<String> finalPermutations = new ArrayList<>();
        if(str.length()==0) {
            finalPermutations.add("");
            return finalPermutations;
        }

        char first = str.charAt(0);
        String remainder  = str.substring(1);

        List<String> permutations = getPermutations(remainder);

        for(String permutation: permutations) {
            for(int i=0;i<permutation.length();i++) {
                String perm = insertCharAt(permutation,first,i);
                finalPermutations.add(perm);
            }
        }

        return finalPermutations;
    }

    private String insertCharAt(String permutation, char c, int i) {

        String start = permutation.substring(0,i);
        String end = permutation.substring(i);

        return start + c + end;
    }


    public static void main(String [] args) {
        PermutationsOfString permutationsOfString = new PermutationsOfString();
        System.out.println(permutationsOfString.getPermutations("abc"));
    }
}
