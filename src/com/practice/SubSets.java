import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



// https://leetcode.com/problems/subsets/
public class SubSets {

    public static void main(String[] args) {

        //SubSets soa= new SubSets();
        int[] nums= {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);

        for (List<Integer> subset: subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void subsetsHelper(List<List<Integer>> list , List<Integer> resultList, int [] nums, int start){
        list.add(new ArrayList<>(resultList));
        for(int i = start; i < nums.length; i++){
            // add element
            resultList.add(nums[i]);
            // Explore
            subsetsHelper(list, resultList, nums, i + 1);
            // remove
            resultList.remove(resultList.size() - 1);
        }
    }
}
