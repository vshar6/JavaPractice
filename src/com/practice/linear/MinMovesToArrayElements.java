package linear;

import java.util.Arrays;

/*
* https://leetcode.com/problems/minimum-moves-to-equal-array-elements/ - minMoves
* https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/ - minMoves2
* */
public class MinMovesToArrayElements {

    public int minMoves(int[] nums) {
        int length = nums.length;
        int max = findMaxNumber(nums);
        int minMoves = 0;
        System.out.println(nums[length-1]);
        for(int i = length-1; i >=0;i--) {
            minMoves += nums[i]- max ;
        }

        return minMoves;
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length-1;

        int count = 0;
        while(i < j){
            count += nums[j]-nums[i];
            i++;
            j--;
        }
        return count;
    }




    private int findMaxNumber(int[] nums) {

        int max = nums [0];

        for(int num:nums) {
            if(num > max) {
                max = num;
            }
        }

        return max;
    }
}
