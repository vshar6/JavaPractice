/*
https://leetcode.com/problems/reverse-integer/

        Given a signed 32-bit integer x, return x with its digits reversed.
            If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
            Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

        Example 1:
            Input: x = 123
            Output: 321

        Example 2:
            Input: x = -123
            Output: -321

        Example 3:
            Input: x = 120
            Output: 21
*/

package linear;

public class ReverseInteger {

//    public static int length(int number) {
//        return (int) (Math.log10(number) + 1);
//    }

    public static int reverse(int x) {
        char[] digits;
        int answer = 0;
        boolean isNegative = false;
        if(x >= 0) {
            digits = String.valueOf(x).toCharArray();
        } else {
            isNegative = true;
            digits = String.valueOf(Math.abs(x)).toCharArray();
        }

        int forwardIndex = 0;
        int backwardIndex = digits.length - 1;

        while(forwardIndex < backwardIndex) {
            char temp = digits[forwardIndex];
            digits[forwardIndex] = digits[backwardIndex];
            digits[backwardIndex] = temp;

            forwardIndex ++;
            backwardIndex --;
        }
        try {
             //answer = Integer.parseInt(String.valueOf(digits));
            answer = Integer.parseInt(new String(digits));
        } catch(NumberFormatException ex) {
            //System.err.println(digits+" is an invalid integer\n"+ex);
            return 0;
        }

        if(isNegative) {
            answer = answer*-1;
        }

        return answer;
    }

    public static void main(String [] args) {

        System.out.println("output="+reverse(-120));
    }
}
