/*
* https://leetcode.com/problems/3sum/
*
* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
*
Example 1:
    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
    Explanation:
    nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    The distinct triplets are [-1,0,1] and [-1,-1,2].
    Notice that the order of the output and the order of the triplets does not matter.

*
* Example 2:
    Input: nums = [0,1,1]
    Output: []
    Explanation: The only possible triplet does not sum up to 0.

*
* Example 3:
    Input: nums = [0,0,0]
    Output: [[0,0,0]]
    Explanation: The only possible triplet sums up to 0.
*
*
* */


package linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        List<Integer> inputNumbers = createList(nums);
        List<List<Integer>> threeSums = new ArrayList<>();
        for(int leftCounter = 0;leftCounter < (nums.length-1); leftCounter++) {
            int rightCounter = nums.length-1;
            while(leftCounter <rightCounter) {
                if(leftCounter != rightCounter) {
                    List<Integer> threeSum = new ArrayList<>();
                    int targetSum = -1*(nums[leftCounter] + nums[rightCounter]);
//                    int num = Arrays.binarySearch(inputNumbers.toArray(),leftCounter+1,nums.length-1, targetSum);
//                    System.out.println("first:"+nums[leftCounter]+",second:"+nums[rightCounter]+",third:"+num);
                    if(inputNumbers.contains(targetSum) ) {
                        int indexOfThirdNumber = inputNumbers.indexOf(targetSum);
                        if(indexOfThirdNumber != leftCounter && indexOfThirdNumber != rightCounter) {
                            threeSum.add(nums[leftCounter]);
                            threeSum.add(nums[rightCounter]);
                            threeSum.add(inputNumbers.get(indexOfThirdNumber));
                            if(!identicalLists(threeSums,threeSum)) {
                                Collections.sort(threeSum);
                                threeSums.add(threeSum);
                            }
                        }
                    }
                }
                rightCounter--;
            }
        }
        return threeSums;
    }


    private static boolean identicalLists(List<List<Integer>> parentCollection, List<Integer> secondList) {
        for(List<Integer> list:parentCollection) {
            Collections.sort(secondList);
            if(list.equals(secondList)) {
                return true;
            }
        }

        return false;
    }

//    public static List<List<Integer>> threeSumOptimized(int[] nums) {
//
//        List<Integer> inputNumbers = createList(nums);
//        List<List<Integer>> threeSums = new ArrayList<>();
//        for(int leftCounter = 0;leftCounter < (nums.length-1); leftCounter++) {
//            int rightCounter = nums.length-1;
//            while(leftCounter <rightCounter) {
//                if(leftCounter != rightCounter) {
//                    Integer [] threeSumArr = new Integer[3];
//
//                    int targetSum = -1*(nums[leftCounter] + nums[rightCounter]);
//
//
//                    int indexOfThirdNumber = searchTargetSumIndex(leftCounter,rightCounter,targetSum, nums);
//                    if(indexOfThirdNumber!=-1) {
//                        threeSumArr[0] = nums[leftCounter];
//                        threeSumArr[1] = nums[rightCounter];
//                        threeSumArr[2] = nums[indexOfThirdNumber];
//                        Arrays.sort(threeSumArr);
//                        if(threeSums.size()==0) {
//                            threeSums.add(Arrays.asList(threeSumArr));
//                        }
//                        else if (!identicalLists(threeSums,Arrays.asList(threeSumArr))) {
//                            threeSums.add(Arrays.asList(threeSumArr));
//                        } else {
//                            System.out.println("--------------");
//                        }
//                    }
//                }
//                rightCounter--;
//            }
//        }
//        return threeSums;
//    }

//    private static int searchTargetSumIndex(int leftCounter, int rightCounter, int targetSum, int[] nums) {
//
//        for(int indexOfThirdNumber=0;indexOfThirdNumber < nums.length;indexOfThirdNumber++) {
//            if(nums[indexOfThirdNumber] == targetSum) {
//                if(indexOfThirdNumber != leftCounter && indexOfThirdNumber != rightCounter) {
//                    return indexOfThirdNumber;
//                }
//            }
//        }
//
//        return -1;
//    }


//    private static boolean identicalLists(List<List<Integer>> parentCollection, List<Integer> secondList) {
//        for(List<Integer> list:parentCollection) {
//            Collections.sort(secondList);
//            if(list.equals(secondList)) {
//                return true;
//            }
//        }
//
//        return false;
//    }


    private static List<Integer> createList(int[] nums) {
        List<Integer> inputNumbers = new ArrayList<>();
        for(Integer num: nums) {
            inputNumbers.add(num);
        }

        return inputNumbers;
    }

    public static void main(String [] args) {
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {-1,0,1,2,-1,-2,-4,3,1};
        threeSum(nums);
    }

}
