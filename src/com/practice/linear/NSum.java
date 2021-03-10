package linear;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 0, 4, target);
    }
    public List<List<Integer>> nSum(int[] nums, int start, int n, int target) {
        if(n == 2) {

            return twoSum(nums, start, target);
        } else if(n > 2){
            List<List<Integer>> list = new LinkedList<>();
            for(int i = start; i < nums.length; i++) {
                List<List<Integer>> tuples = nSum(nums, i + 1, n - 1, target - nums[i]);
                for(List<Integer> tuple : tuples) {
                    List<Integer> tmp = new LinkedList<>();
                    tmp.addAll(tuple);
                    tmp.add(nums[i]);
                    list.add(tmp);
                }
                while(i + 1 < nums.length && nums[i] == nums[i+ 1]) {
                    i++;
                }
            }
            return list;
        }
        return new LinkedList<List<Integer>>();
    }
    public List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int lo = start;
        int hi = nums.length - 1;
        while(lo < hi) {
            int left = nums[lo];
            int right = nums[hi];
            int sum = left + right;
            if(sum < target) {
                while(lo < hi && nums[lo] == left) {
                    lo++;
                }
            } else if(sum > target) {
                while(lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else if(sum == target) {
                List<Integer> list = new LinkedList<>();
                list.add(left);
                list.add(right);
                res.add(list);
                while(lo < hi && nums[lo] == left) {
                    lo++;
                }
                while(lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
        }
        return res;
    }

    public static void main(String [] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        new NSum().fourSum(nums, 0);
    }

}
