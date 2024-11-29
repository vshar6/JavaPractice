/*
* https://leetcode.com/problems/3sum-closest/
* Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

* Example 1:
    Input: nums = [-1,2,1,-5,-4], target = 2
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
    *
    * 1-4-2-5 = -5
    * 1+(-4) + (-2) +
    *
    *

Example 2:
    Input: nums = [0,0,0], target = 1
    Output: 0
    Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
* */

package linear;

import java.util.Arrays;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int distance = Integer.MAX_VALUE;
        for(int leftCounter = 0;leftCounter < nums.length; leftCounter++) {
            int rightCounter = nums.length - 1;
            while(leftCounter < rightCounter) {
                int tempTarget = target - (nums[leftCounter] + nums[rightCounter]);
                for(int index = 0;index < nums.length;index++) {
                    if(index!=leftCounter && index != rightCounter) {
                        int tempDistance = Math.abs(nums[index] - tempTarget);
                        if(tempDistance==0) {
                            return nums[leftCounter]+ nums[rightCounter] +  nums[index];
                        } else {
                            if(tempDistance <= distance) {
                                distance = tempDistance;
                                sum = nums[leftCounter]+ nums[rightCounter] +  nums[index];
                            }
                        }
                    }
                }
                rightCounter--;
            }
        }

        return sum;
    }



    public static int threeSumClosestOptimize(int[] nums, int target) {

        Arrays.sort(nums);
        int distance = nums[0]+nums[1]+nums[2];
        for(int index = 0;index < nums.length-2; index++) {
            int rightCounter = nums.length - 1;
            int leftCounter = index+1;
            while(leftCounter < rightCounter) {
                int tempSum = nums[index]+nums[leftCounter]+nums[rightCounter];
                if(tempSum == target) {
                    return tempSum;
                }

                if(Math.abs(tempSum-target) < Math.abs(distance - target)) {
                    distance = tempSum;
                }

                if(tempSum < target) {
                    leftCounter ++;
                } else {
                    rightCounter --;
                }
            }
        }

        return distance;
    }





    public static void main(String [] args) {
        //int[] nums = {-100,-98,-2,-1};
        //int[] nums = {1,3,4,7,8,9};
        int[] nums = {2,3,8,9,10};
        int target = 16;
        System.out.println("answer:"+threeSumClosestOptimize(nums,target));
    }

}
