
/*
*
* https://leetcode.com/problems/self-dividing-numbers/
*
* Beats 100% with 1ms runtime
*
* */

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumber {
   static  List<Integer> selfDividingNumbers = new ArrayList<>();
    public static List<Integer> selfDividingNumbers(int left, int right) {

        if(left > right) {
            return selfDividingNumbers;
        } else {
            int number = left;
            while(left>0) {
                int divisor=left%10;
                if(divisor !=0 && number%divisor==0) {
                    left=left/10;
                } else {
                    left=number;
                    break;
                }
                if(left==0) {
                    selfDividingNumbers.add(number);
                    left = number;
                    break;
                }
            }
            left++;
            return selfDividingNumbers(left,right);
        }

    }

    public static void main(String [] args) {
       System.out.println(selfDividingNumbers(47,85));
    }
}
