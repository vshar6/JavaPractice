package linear;

//https://leetcode.com/problems/remove-element/

public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int originalLength = nums.length;
        int valueCount = 0;

        for(int count = 0;count < nums.length; count++) {
            if(nums[count] == val) {
                valueCount++;
                for(int internalCount = count;internalCount < nums.length;internalCount++) {
                    int temp = nums[count];
                    nums[count] = nums[count+internalCount];
                    nums[count+internalCount] = temp;
                }
            }
        }

        System.out.println(originalLength - valueCount);
        return originalLength - valueCount;
    }

    public static void main(String [] args) {
        int [] nums = {3,2,2,4,5,6,2,3,4,1,2,1,2}; // output = {3,4,5,6,3,4,1,1,_,_,_...}
        removeElement(nums,2);
    }
}
