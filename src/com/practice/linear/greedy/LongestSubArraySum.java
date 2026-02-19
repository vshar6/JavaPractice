package linear.greedy;

//Given an array of integers, find the length of the longest subarray with sum ≤ K.

import java.util.TreeMap;

public class LongestSubArraySum {


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


    /*
    The parts of the approach
        1. The problem and the keywords
            a) array of integers - negative
            b) length of longest subarray
            c) sum <=K (invariant/constraint)

        2. Since it deals with the length of the subarray with negative integers,the two pointer approach would not work
                because the predictability that moving right would always increase the sum and shrinking from left would always decrease the sum,
           instead it now becomes a prefix sum problem because we do not want to now track the moving window, but track all the historical sums.

        3. The invariant that needs protection is the maximum sum should not go beyond K


     */
    public static int lengthOfMaxSumLongestSubArray(int [] array, int k) {

        /* Define the prefixSum ->
                Let prefixSum[i] is the sum of all elements of the array from 0 to i. Mathematically,
                    prefixSum[i] = a[0]+a[1]+a[2]+ ...... + a[i];

                Sum of subarray (j+1 → i) = prefixSum[i] - prefixSum[j]; where j+1 is the floating index and i is the index size of the array
                for the interval (j+1->i). Now,
                 => prefixSum[i] - prefixSum[j] ≤ K;
                 => prefixSum[j] ≥ prefixSum[i] - K;

          We need to find the earliest occurring smallest prefixSum (refixSum[j]), hence the TreeMap as it provides exactly the same thing ceilingKey(x)
        */
        // Treemap<prefixSum, earliestIndex>
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1); // Initialization
        int prefixSum=0,maxLength=0;
        //index = i in our explanation above
        for(int index = 0;index<array.length;index++){

            //applying the condition to find prefixSum[j] ≥ K - prefixSum[i];
            Integer candidate = map.ceilingKey(prefixSum-k);

            if(candidate!=null){
                int length = index - map.get(candidate);
                maxLength= Math.max(maxLength, length);
            }
            // Store earliest occurrence only
            map.putIfAbsent(prefixSum, index);
        }

        return maxLength;
    }



    public static void main(String[] args) {
        int[] array2 = {-4, 2, -5, 1, 2, 3, 6, -5, 1};
        int[] array = {4, 2, 5, 1, 2, 3, 6, 5, 1};
        System.out.println("Length of largest subarray approach 1 (greedy algorithm, handles negatives and positives. Case positive:): " + lengthOfMaxSumLongestSubArray(array, 2));
        //System.out.println("Length of largest subarray approach 1 (greedy algorithm, handlesnegatives and positives. Case negative:): " + lengthOfMaxSumLongestSubArray(array2, 2));

        System.out.println("Length of largest subarray approach 2 (prefix sum and treemap, handles positives): "+lengthOfLongestSubArray(array, 2));

    }
}
