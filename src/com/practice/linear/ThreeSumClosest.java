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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {

        Integer [] targetNumbers = new Integer[3];
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


    public static void main(String [] args) {
        //int[] nums = {-100,-98,-2,-1};
        //int[] nums = {1,3,4,7,8,9};
        int[] nums = {2,3,8,9,10};
        int target = 16;
        System.out.println("answer:"+threeSumClosest(nums,target));
    }

}
