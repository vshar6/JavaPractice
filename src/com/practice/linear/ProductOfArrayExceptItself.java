package linear;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 */

public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {

        int [] ans = new int[nums.length];

        int runningProduct = 1;

        for (int i=0;i<nums.length-1; i++) {
            runningProduct = runningProduct * nums[i];
            ans[i] = runningProduct;
        }

        runningProduct = 1;

        for (int i=nums.length -1 ;i>=1; i--) {
            ans[i] = runningProduct * ans[i-1];
            runningProduct = runningProduct * nums[i];
        }

        ans[0] = runningProduct;

        return ans;
    }

    public static void main(String [] args) {
        ProductOfArrayExceptItself productOfArrayExceptItself = new ProductOfArrayExceptItself();
        int[] nums =  {1,2,3,4,5};

        productOfArrayExceptItself.productExceptSelf(nums);

    }

}
