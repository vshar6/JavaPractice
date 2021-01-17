
public class AdditiveNumber {

    public static boolean isAdditiveNumber(String number) {
        if (number.length() < 3) {
            return false;
        }
        for (int i = 0; i <= number.length()/2; i++) {
            if (number.charAt(0) == '0' && i > 0) {
                break;
            }
            int x1 = Integer.valueOf(number.substring(0, i + 1));
            //make sure remaining size is at least size of first and second integer.
            for (int j = i + 1; Math.max(i, j - (i + 1)) + 1 <= number.length() - j - 1 ; j++) {
                if (number.charAt(i + 1) == '0' && j > i + 1) {
                    break;
                }
                int x2 =  Integer.valueOf(number.substring(i + 1, j + 1));
                if (isValid(number, j + 1, x1, x2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(String num, int start, int x1, int x2) {
        if (start == num.length()) {
            return true;
        }
        int x3 = x1 + x2;
        //if num starts with x3 from offset start means x3 is found. So look for next number.
        return num.startsWith(String.valueOf(x3), start) && isValid(num, start + String.valueOf(x3).length(), x2, x3);
    }

    public static void main(String [] args) {
        isAdditiveNumber("199100199");
    }
}
