package linear;


/*
Return the length of the longest subarray that contains at most 2 distinct numbers

    Example 1
    nums = [1,2,1,2,3,2,2]
    Output = 4
    Explanation: [1,2,1,2]

    Example 2
    nums = [0,1,2,2]
    Output = 3
    Explanation: [1,2,2]
 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithKDistinctNumbers {

    /*
    * The solution contains four parts
    * 1. the range of the output is not fixed, so apply sliding window approach.
    * 2. This means start from the left and expand to the right until the constraint is violated
    * 3. Once the constraint is violated, move left to 1 index
    * 4. Calculate the length of the window till it is valid, not before, not after
    *
    *
    * */
    private static int getLongestSubArray(int [] array, int k) {

        final Map<Integer, Integer> frequencies = new HashMap<>();
        int maxLength = 0;
        int left=0;
        for(int right = 0; right < array.length; right++) {
            frequencies.put(array[right], frequencies.getOrDefault(array[right], 0) + 1);

            //protect the constraint - shrink the window when constraint is broken
            while(frequencies.size() > k && left <= right) {
                int leftValue = array[left];
                frequencies.put(array[left], frequencies.get(leftValue)- 1);

                if(frequencies.get(leftValue) == 0) {
                    frequencies.remove(leftValue);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left+1);

        }
        System.out.println(maxLength);

        return maxLength;
    }


//    If we have to do an exact "k" length then below would be the code.

    //Approach 1. getExactLongestSubArray(array,k) - getExactLongestSubArray(array,k-1)
    private static int getExactKLongestSubArray(int [] array, int k) {
        return getLongestSubArray(array, k)- getLongestSubArray(array, k-1);
    }


    //Approach 2. We would need to protect the invariant where the length is only considerable when the invariant is met i.e. the array contains exactly "k" unique numbers.
    private static int getExactLongestSubArray(int [] array, int k) {

        final Map<Integer, Integer> frequencies = new HashMap<>();
        int maxLength = 0;
        int left=0;
        for(int right = 0; right < array.length; right++) {
            frequencies.put(array[right], frequencies.getOrDefault(array[right], 0) + 1);

            //protect the constraint - shrink the window when constraint is broken
            while(frequencies.size() > k && left <= right) {
                int leftValue = array[left];
                frequencies.put(array[left], frequencies.get(leftValue)- 1);

                if(frequencies.get(leftValue) == 0) {
                    frequencies.remove(leftValue);
                }
                left++;
            }
            if(frequencies.size() == k) {
                maxLength = Math.max(maxLength, right-left+1);
            }

        }
        System.out.println(maxLength);

        return maxLength;
    }




    public static void main(String [] args) {
        //int [] nums = {1,2,2,3,1,2,3,2,2,4,5,1,22,12,45};
        int [] nums = {1,2,2,3,1,2};
        getLongestSubArray(nums,2);
    }
}
