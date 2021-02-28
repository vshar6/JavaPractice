package linear;


// https://leetcode.com/problems/find-the-duplicate-number/
public class DuplicateNumber {

    public int findDuplicate(int[] nums) {

        int [] numberCounter = new int[nums.length];

        for(int index =0; index < nums.length;index++) {
            numberCounter[nums[index]] = numberCounter[nums[index]] + 1;

            if(numberCounter[nums[index]] > 1) {
                System.out.println(nums[index]);
                return nums[index];
            }
        }
        return 0;
    }


    public static void main(String [] args) {
        int [] array = {1,3,4,4,2};
        new DuplicateNumber().findDuplicate(array);
    }

}
