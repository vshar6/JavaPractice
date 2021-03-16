package linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/4sum/
public class FourSumtoTarget {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }
    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k)
            return res;
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i])
                for (var set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i])));
                    res.get(res.size() - 1).addAll(set);
                }
        return res;
    }
    public List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                ++lo;
            else if (sum > target || (hi < nums.length - 1 && nums[hi] == nums[hi + 1]))
                --hi;
            else
                res.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return res;
    }

    public static void main(String [] args) {
        int [] nums = {-2,-1,-1,1,1,2,2};
        int target = 0;

        new FourSumtoTarget().fourSum(nums,target);
    }

























//    public List<List<Integer>> fourSums(int[] nums, int target) {
//
//        return getPossibleSubArrays(nums, nums.length, 4, target);
//    }
//
//
//    private List<List<Integer>> getPossibleSubArrays(int[] nums, int length, int size, int target) {
//
//        List<List<Integer>> list = new ArrayList<>();
//        subsetsHelper(list, new ArrayList<>(), nums, 0, size, target);
//        System.out.println("available quadruplets:"+list);
//
//
//        return list;
//    }
//
//
//    private void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start, int size, int target){
//
//        for(int i = start; i < nums.length; i++){
//            resultList.add(nums[i]);
//            subsetsHelper(list, resultList, nums, i + 1, size, target);
//            resultList.remove(resultList.size() - 1);
//        }
//        if(resultList.size() == size) {
//            int sum = 0;
//            for(Integer element : resultList) {
//                sum = sum + element;
//            }
//            if(sum==target) {
//                List<Integer> targetList = new ArrayList<>(resultList);
//                if(!list.contains(targetList)) {
//                    list.add(targetList);
//                }
//
//            }
//
//        }
//    }
//
//    public static void main(String [] args) {
//        int [] nums = {-2,-1,-1,1,1,2,2};
//        int target = 0;
//
//        new FourSumtoTarget().fourSum(nums,target);
//    }

}
