package linear;

import java.util.*;


// https://leetcode.com/problems/subsets/
public class SubSets {

    public static void main(String[] args) {

        //array.SubSets soa= new array.SubSets();
        int[] nums= {1, 2, 3};
        List<Integer> elements = new ArrayList<>(){{add(1);add(2);add(3);}};
        //System.out.println(powerSet(new HashSet<>(){{add(1);add(2);add(3);}}));
        //List<List<Integer>> subsets = subsets(nums);
        List<List<Integer>> subsets = subSetBuilder(elements,0);

        System.out.println("--"+subsets);
        for (List<Integer> subset: subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> subSetBuilder(List<Integer> nums, int index) {
        List<List<Integer>> list= new ArrayList<>();
        if(nums.size() == index) {
            list.add(new ArrayList<Integer>());
        } else {
            list = subSetBuilder(nums, index+1);
            int item = nums.get(index);
            List<List<Integer>> additionalList = new ArrayList<>();
            for(List<Integer> subsets : list) {
                ArrayList<Integer> newSubSet = new ArrayList<>();
                newSubSet.addAll(subsets);
                newSubSet.add(item);
                additionalList.add(newSubSet);
            }
            list.addAll(additionalList);
        }
        return list;
    }


    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void subsetsHelper(List<List<Integer>> subsets , List<Integer> currentSubset, int [] nums, int start){
        subsets.add(new ArrayList<>(currentSubset));
        for(int i = start; i < nums.length; i++){
            // add element
            currentSubset.add(nums[i]);
            // Explore
            subsetsHelper(subsets, currentSubset, nums, i + 1);
            // remove
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    /*public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }*/
}
