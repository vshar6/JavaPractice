package linear;

//Given an array of integers, find the length of the longest subarray with sum ≤ K.

public class LongestSubArray {


    public static int lengthOfLongestSubArray(int [] array, int k) {
        int left = 0;
        int maxSum = 0;
        int maxLength = 0;

        for (int right = 0; right < array.length; right++) {
            maxSum = maxSum+array[right];
            while (maxSum > k && left <= right) {
                maxSum = maxSum-array[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int[] array = new int[]{-4, 2, -5, 1, 2, 3, 6, -5, 1};
        System.out.println("Length of largest subarray: " + lengthOfLongestSubArray(array, 0));

    }
}
