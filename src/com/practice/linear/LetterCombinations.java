/*
* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
* Return the answer in any order.
*
*
Example 1:
    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    *
Example 2:
    Input: digits = ""
    Output: []
    *
Example 3:
    Input: digits = "2"
    Output: ["a","b","c"]

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

* */
package linear;

import java.io.CharConversionException;
import java.util.*;

public class LetterCombinations {

    public static final Map<Character, String> letterMaster = new HashMap<>();


    public LetterCombinations() {
        letterMaster.put('2',"abc");
        letterMaster.put('3',"def");
        letterMaster.put('4',"ghi");
        letterMaster.put('5',"jkl");
        letterMaster.put('6',"mno");
        letterMaster.put('7',"pqrs");
        letterMaster.put('8',"tuv");
        letterMaster.put('9',"wxyz");
    }

    public static List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();

        if(digits.length() > 0) {
            getLetterCombinations(0,new StringBuilder(),digits.toCharArray(), answer);
        }

        return answer;
    }

    private static void getLetterCombinations(int index,StringBuilder combination, char[] digits, List<String> answer) {

        if(digits.length ==index) {
            answer.add(combination.toString());
            return;
        }

        for(Character character: letterMaster.get(digits[index]).toCharArray()) {
            StringBuilder temp = new StringBuilder(combination);
            temp.append(character);
            getLetterCombinations(index+1,temp, digits, answer);
        }
    }


    public static void main(String [] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        for(String combination: letterCombinations("234")) {
            System.out.println("combination:"+combination);
        }
    }
}
