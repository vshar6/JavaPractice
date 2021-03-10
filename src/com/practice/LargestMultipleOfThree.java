import java.util.*;

public class LargestMultipleOfThree {

    public String largestMultipleOfThree(int[] digits) {
        int sum = 0;
        int remainder = sum % 3;

        Integer[] digitx = reverseSort(digits);

        List<Integer> zeroRemainder = new ArrayList<>();
        Queue<Integer> oneRemainder = new PriorityQueue<>();
        Queue<Integer> twoRemainder = new PriorityQueue<>();

        for(int index = 0;index < digitx.length; index ++) {
            sum = sum + digitx[index];
            int elementRemainder = digitx[index] % 3;

            if(elementRemainder == 0) {
                zeroRemainder.add(digitx[index]);
            } else if(elementRemainder == 1) {
                oneRemainder.add(digitx[index]);
            } else {
                twoRemainder.add(digitx[index]);
            }
        }

        if(remainder == 0) {
            return getLargestString(zeroRemainder);
        } else if(remainder == 1) {
            if(oneRemainder.size() >= 1) {
                oneRemainder.remove();
            } else {
                if(twoRemainder.size() >= 2) {
                    twoRemainder.remove();
                    twoRemainder.remove();
                } else {
                    return "";
                }
            }
        } else {
            if(twoRemainder.size() >= 1) {
                twoRemainder.remove();
            } else {
                if(oneRemainder.size() >= 2) {
                    oneRemainder.remove();
                    oneRemainder.remove();
                } else {
                    return "";
                }
            }
        }

        
       return "";
    }

    private String getLargestString(List<Integer> zeroRemainder) {
        zeroRemainder.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(Integer element: zeroRemainder) {
            sb.append(element);
        }
        return sb.toString();
    }

    private Integer[] reverseSort(int[] digits) {

        Integer[] arrOfObjects = new Integer[digits.length];
        for (int i = 0; i < digits.length; i++)
            arrOfObjects[i] = new Integer(digits[i]);

        Arrays.sort(arrOfObjects, Collections.reverseOrder());

        return arrOfObjects;
    }



    public static void main(String[] args) {
        int[] digits = {8, 6, 7, 1, 0};
        new LargestMultipleOfThree().largestMultipleOfThree(digits);
    }
}
