/*
https://leetcode.com/problems/maximum-product-subarray/

https://leetcode.com/problems/subarray-product-less-than-k/
*/


public class MaxProductSubArray {

    public static int product(int[] array) {
        int maxProduct = array[0];
        for(int i=0;i<array.length;i++) {
                int productPerIteration = array[i];
                for(int j = i+1;j<array.length;j++) {
                    productPerIteration = productPerIteration * array[j];
                    if(productPerIteration > maxProduct) {
                        maxProduct = productPerIteration;
                    }
                }
                maxProduct = Math.max(maxProduct,array[i]);

        }
        return maxProduct;
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 2, 6};//{10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        //System.out.println("Product of largest subarray: " + product(array));
        System.out.println("Product of largest subarray less than k: " + numSubarrayProductLessThanK(array,100));
        //System.out.println(-4+ 2 -5+ 1+ 2+ 3+ 6 -5+ 1);
    }



//        for(int i=0;i<array.length;i++) {
//            int productPerIteration = array[i];
//            if(array[i]< k) {
//                productCounter++;
//            }
//            for(int j = i+1;j<k;j++) {
//                productPerIteration = productPerIteration * array[j];
//                if(productPerIteration < k) {
//                    //System.out.println("array["+i+"]="+array[i]+"* array["+j+"]="+array[j]);
//                    productCounter++;
//                }
//                if(productPerIteration >= k) {
//                    break;
//                }
//            }
//        }
}
