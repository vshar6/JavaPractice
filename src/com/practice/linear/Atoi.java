/* https://leetcode.com/problems/string-to-integer-atoi/description/ */

/*
Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached.
           If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range.
         Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 */

package linear;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Atoi {

    // Read the string and check for the conditions.
    /*
        1. if the first index is negative
        2. check each character of the string if it is a digit or not
     */

    /*public static boolean checkIfPossibleNegative(String s) {
        if(s.charAt(0) == '-') {
            return true;
        }
        return false;
    }



    // Parse the string into a list/arraylist

    // Form the number and check for the range
    //Output



    public static int myAtoi(String s) {
        if(Character.isLetter(s.charAt(0))) {
            return 0;
        }
        else if(checkIfPossibleNegative(s)) {
            return Math.negateExact( findIntegers(s.substring(1)));
        }
        else {
            findIntegers(s);
        }
        return 0;
    }


    private static Integer findIntegers(String s) {
        int counter = 0;
        final List<Integer> integers = new ArrayList<>();
        char [] inputArray = s.toCharArray();

        while(counter!=inputArray.length) {
            if(checkInteger(inputArray[counter])!=99) {
                integers.add(Character.getNumericValue(inputArray[counter]));
            } else {
                break;
            }
            counter++;
        }
        System.out.println(integers);
        //whenCollectorsJoining_thenPrintCustom(integers);
       String output = integers.stream().map(i -> String.valueOf(i)).collect(Collectors.joining());
       System.out.println();
        return Integer.parseInt(output);
    }


    private static int checkInteger(char c) {
        if(Character.isDigit(c)) {
            return c;
        } else {
            return 99;
        }
    }*/


        public static int myAtoi(String s) {
            char[] letters = s.trim().toCharArray();

            if(letters == null) {
                return 0;
            }

            List<Character> numbers = new ArrayList<>();
            int initIndex = 0;
            boolean isNegative = false;
            if (letters.length == 0) {
                return 0;
            }
            if (letters[0] == '-') {
                isNegative = true;
                initIndex = 1;
            } else if (letters[0] == '+') {
                initIndex = 1;
            }
            for (int index = initIndex; index < letters.length; index++) {
                if (checkIfInteger(letters[index])) {
                    numbers.add(letters[index]);
                } else {
                    break;
                }
            }

            return createNumber(isNegative, numbers);
        }

//    private static char[] processWord(String s) {
//            String [] arr = s.split(" ");
//            StringBuilder sb = new StringBuilder();
//            for(String str: arr) {
//                if
//                sb.append(arr.toString());
//            }
//            char [] _letters = sb.toString().toCharArray();
//            //List<Character> letters = new ArrayList<>();
//
////            for(Character letter: _letters) {
////                if(letter != ' ') {
////                    letters.add(letter);
////                } else {
////                    if(letters.size() > 0 ) {
////                        return null;
////                    }
////                }
////
////            }
//
//            return _letters;
//    }

    private static int createNumber(boolean isNegative, List<Character> numbers) {
            Integer answer = 0;
            StringBuilder number = new StringBuilder();
            if (numbers.isEmpty()) {
                return 0;
            }
            for (Character character : numbers) {
                number.append(character);
            }
            try {
                if (isNegative) {
                    answer = -1 * Integer.parseInt(number.toString());
                } else {
                    answer = Integer.parseInt(number.toString());
                }
            } catch (NumberFormatException ex) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            return answer;
        }

        private static boolean checkIfInteger(Character character) {

            if (48 <= character && character <= 57) {
                return true;
            } else {
                return false;
            }
        }

        public static void main(String [] args) {

        System.out.println("answer="+myAtoi("  4193 with words"));

        //System.out.println(Integer.parseInt( "-123243434542"));

    }

}
