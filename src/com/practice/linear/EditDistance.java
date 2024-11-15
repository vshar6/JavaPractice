/* https://leetcode.com/problems/edit-distance/description/ */

/*

 -- Not solved yet
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
        You have the following three operations permitted on a word:
        a) Insert a character
        b) Delete a character
        c) Replace a character
*/

package linear;

public class EditDistance {

    public static int minDistance(String source, String target) {
        boolean insertionRequired = true;
        int count = 0;
        char [] sourceLetters = source.toCharArray();
        char [] targetLetters = target.toCharArray();
        if(source.length()==target.length()) {

            for(int index = 0; index < sourceLetters.length; index++) {
                if(sourceLetters[index] != targetLetters[index]) {
                    targetLetters[index] = sourceLetters[index];
                    count++;
                }
            }

            constructTargetword(targetLetters);

        } else {
            if(sourceLetters.length > targetLetters.length) {
                
            }
        }
        System.out.println("count-"+count);
        return count;
    }

    private static void constructTargetword(char[] targetLetters) {
        System.out.println(String.valueOf(targetLetters));
    }

    public static void main(String [] args) {

        minDistance("horse","rose");
        minDistance("execution","intention");

    }
}
