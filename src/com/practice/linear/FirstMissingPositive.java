package linear;

import java.util.*;

// https://leetcode.com/problems/first-missing-positive/

public class FirstMissingPositive {

    public int firstMissingPositive(int [] nums) {
        Arrays.sort(nums);
        boolean isallNegative = true;
        Set<Integer> uniqueNumbers = new HashSet<>(nums.length);
        int first_missing_positive = 1;
        for(int index = 0;index < nums.length;index++) {
            //System.out.println("[" + index + "]=" + nums[index]);
            if (nums[index] > 0) {
                isallNegative = false;
                if (nums[index] <= first_missing_positive && !uniqueNumbers.contains(nums[index])) {
                    first_missing_positive = first_missing_positive +1;
                }

                uniqueNumbers.add(nums[index]);
            }
        }
        System.out.println("apple".compareTo("banana"));
        System.out.println("first_missing_positive:" + first_missing_positive);
        return isallNegative?1:first_missing_positive;
    }

//    public int firstMissingPositive(int [] nums) {
//
//        boolean isallNegative = true;
//        Set<Integer> uniqueNumbers = new TreeSet<>();
//        int first_missing_positive = 1;
//        for(int index = 0;index < nums.length;index++) {
//            uniqueNumbers.add(nums[index]);
//        }
//
//        for(Integer element: uniqueNumbers) {
//            if (element > 0) {
//                isallNegative = false;
//                if(element <=first_missing_positive) {
//                    first_missing_positive = first_missing_positive +1;
//                }
//            }
//        }
//
//        System.out.println("first_missing_positive:" + first_missing_positive);
//        return isallNegative?1:first_missing_positive;
//    }


    public static void main(String [] args) {
        int [] array = {};
        System.out.println("apple".compareTo("banana"));
        //new FirstMissingPositive().firstMissingPositive(array);
    }

    /*
    * public int firstMissingPositive(int [] nums) {
        Arrays.sort(nums);
        boolean isallNegative = true;
        Set<Integer> uniqueNumbers = new HashSet<>(nums.length);
        int first_missing_positive = 1;
        for(int index = 0;index < nums.length;index++) {
            //System.out.println("[" + index + "]=" + nums[index]);
            if (nums[index] > 0) {
                isallNegative = false;
                if (nums[index] <= first_missing_positive && !uniqueNumbers.contains(nums[index])) {
                    first_missing_positive = first_missing_positive +1;
                }
                uniqueNumbers.add(nums[index]);
            }
        }
        System.out.println("first_missing_positive:" + first_missing_positive);
        return isallNegative?1:first_missing_positive;
    }
    }
    * */

    /*
    * public int firstMissingPositive(int [] nums) {
         boolean isallNegative = true;
        Set<Integer> uniqueNumbers = new HashSet<>();
        int first_missing_positive = 1;
        for(int index = 0;index < nums.length;index++) {
            uniqueNumbers.add(nums[index]);
        }

        for(Integer element: uniqueNumbers) {
            if (element > 0) {
                isallNegative = false;
                if(element <=first_missing_positive) {
                    first_missing_positive = first_missing_positive +1;
                }
            }
        }

        System.out.println("first_missing_positive:" + first_missing_positive);
        return isallNegative?1:first_missing_positive;
    }
    * */




}
