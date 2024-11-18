/*
*  https://leetcode.com/problems/longest-palindromic-substring/
*
* Given a string s, return the longest palindromic substring in s.

Example 1:
    Input: s = "babad"
    Output: "bab"
    Explanation: "aba" is also a valid answer.
Example 2:
    Input: s = "cbbd"
    Output: "bb"

*
*
*
* */


package linear;

import java.util.Timer;
import java.util.TimerTask;

public class LongestPalindrome {

    public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        if(isPalindrome(s)) {
            return s;
        }

        char [] _letters = s.toCharArray();
        for(int index=0;index<_letters.length;index++) {
            int reverseCounter = s.length()-1;
            while(reverseCounter != 0 && reverseCounter > index) {
                if( _letters[reverseCounter] == _letters[index] ) {
                    String tempString = s.substring(index,reverseCounter+1);
                    if(isPalindrome(tempString) && tempString.length() > longestPalindrome.length() ) {
                        longestPalindrome = tempString;
                    }
                }

                reverseCounter--;
            }
        }
        //  System.out.println("longestPalindrome:"+longestPalindrome);

        if(longestPalindrome.equals("")) {
            longestPalindrome = String.valueOf(s.charAt(0));
        }
        return longestPalindrome;
    }

//     private static boolean isPalindrome(String word) {
//         int length = word.length();
//         char[] _reverse = new char[length];
//         int counter =0;
//         char [] _letters = word.toCharArray();

//         while(length!=0) {
//             length--;
//             _reverse[length] = _letters[counter];
//             counter++;
//         }

//         String reverse = new String(_reverse);
// //        if(reverse.equals(word)) {
// //            System.out.println("Possible palindrome:"+reverse);
// //        }

    //         return reverse.equals(word);
//     }
    private static boolean isPalindrome(String str)
    {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    public static void main(String [] args) {
        long startTime = System.currentTimeMillis();
        Runtime rt = Runtime.getRuntime();
        long total_mem = rt.totalMemory();
        String input = "jglknendplocymmvwtoxvebkekzfdhykknufqdkntnqvgfbahsljkobhbxkvyictzkqjqydczuxjkgecdyhixdttxfqmgksrkyvopwprsgoszftuhawflzjyuyrujrxluhzjvbflxgcovilthvuihzttzithnsqbdxtafxrfrblulsakrahulwthhbjcslceewxfxtavljpimaqqlcbrdgtgjryjytgxljxtravwdlnrrauxplempnbfeusgtqzjtzshwieutxdytlrrqvyemlyzolhbkzhyfyttevqnfvmpqjngcnazmaagwihxrhmcibyfkccyrqwnzlzqeuenhwlzhbxqxerfifzncimwqsfatudjihtumrtjtggzleovihifxufvwqeimbxvzlxwcsknksogsbwwdlwulnetdysvsfkonggeedtshxqkgbhoscjgpiel";
        //System.out.println("answer="+longestPalindrome("kqwertytrewq"));
        System.out.println("longestPalindrome:"+longestPalindrome(input));
        System.out.println("elapsetime="+( System.currentTimeMillis()-startTime));

        System.out.println("Amount of used memory: " + (total_mem - rt.freeMemory()));
       // System.out.println("answer="+isPalindrome("21a12321a12"));
    }
}
