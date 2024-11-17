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
*
* */


package linear;

public class LongestPalindrome {


    public static String longestPalindrome(String s) {
        String longestPalindrome = "";
        if(isPalindrome(s)) {
            return s;
        }

        char [] _letters = s.toCharArray();
        for(int index=0;index<_letters.length/2;index++) {
            int reverseCounter = s.length()-1;
            while(reverseCounter != 0 && reverseCounter > index) {

                if( _letters[reverseCounter] == _letters[index] ) {
                    String tempString = s.substring(index,reverseCounter+1);
                    System.out.println(tempString);
                    if(isPalindrome(tempString) && tempString.length() > longestPalindrome.length() ) {
                        longestPalindrome = tempString;
                    }
                }

                reverseCounter--;
            }
        }

        return longestPalindrome;
    }

    private static boolean isPalindrome(String word) {
        int length = word.length();
        char[] _reverse = new char[length];
        int counter =0;
        char [] _letters = word.toCharArray();

        while(length!=0) {
            length--;
            _reverse[length] = _letters[counter];
            counter++;
        }

        String reverse = new String(_reverse);
        if(reverse.equals(word)) {
            System.out.println("Possible palindrome:"+reverse);
        }

        return reverse.equals(word);
    }



    public static void main(String [] args) {
        System.out.println("answer="+longestPalindrome("cbbd"));

       // System.out.println("answer="+isPalindrome("21a12321a12"));
    }
}
