package linear;


/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 *
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
 * [−2^31, 2^31 − 1].
 *
 * For this problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1,
 * and if the quotient is strictly less than -2^31, then return -2^31
 **/

public class DivideTwoNumbers {

    public static int divide(int dividend, int divisor) {

        //Check if the dividend and/or the divisor is negative
        int isDividendNegative = isNumberNegative(dividend);
        int isDivisorNegative = isNumberNegative(divisor);

        //The quotient is the count of the times we can subtract the divisor from the dividend unless the dividend turns negative
        int quotient = 0;

         if(divisor == dividend) {
            return 1;
        } else if(divisor == 1) {
            return dividend;
        }
        else if(divisor == -1) {
            if (Integer.MIN_VALUE == dividend) {
                return Integer.MAX_VALUE;
            }
            else if(dividend>0) {
                return -1 * dividend;
            } else {
                return dividend;
            }
        }
        else if(Math.abs(divisor) > Math.abs(dividend)) {
            return 0;
        }
        else if(isDividendNegative * isDivisorNegative > 0) {
            return getQuotient(dividend, divisor,quotient);
        } else {
            return  -1 * getQuotient(Math.abs(dividend), Math.abs(divisor),quotient);
        }
    }

    private static int getQuotient(int dividend, int divisor,int quotient) {

        if(dividend <=0) {
            return quotient;
        } else {
            dividend = dividend - divisor;
            if(dividend == 0) {
                quotient++;
                return quotient;
            }
            else if(dividend < 0) {
                return quotient;
            } else {
                quotient++;
                return getQuotient(dividend,divisor,quotient);
            }
        }
    }

    private static int isNumberNegative(int dividend) {
        return Integer.compare(dividend,0);
    }

    public static void main(String[] args) {

        int quotient  = divide(-1,-1);

        System.out.println("quotient:"+quotient);
    }
}
