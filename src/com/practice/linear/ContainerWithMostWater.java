/*

https://leetcode.com/problems/container-with-most-water/

You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
Example 1:
    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
    Input: height = [1,1]
    Output: 1
 */

package linear;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {

        int maxArea = 0;

        for(int index = 0;index < height.length; index++) {

            int length = 0;
            while(length < height.length) {
                if(length!=index) {
                    int effectiveHeight = Math.min(height[index], height[length]);
                    int effectiveLength = Math.abs(length-index);
                    int tempArea = effectiveHeight * effectiveLength;
                    //System.out.println("effectiveHeight for height["+index+"]:"+height[index]+" and height["+length+"]"+height[length]+", distance:"+effectiveLength+" is:"+effectiveHeight+". Area:"+tempArea);

                    if(tempArea > maxArea) {
                        maxArea = tempArea;
                    }
                }
                length++;
            }
            System.out.println("max area for height["+index+"]:"+maxArea);
        }
        System.out.println("max area:"+maxArea);
        return maxArea;
    }


    public static int maxAreas(int[] height) {

        int n = height.length;
        int left = 0;
        int area = 0;
        int right = n - 1;

        while (left < right) {
            // Calculating the max area
            area = Math.max(area, Math.min(height[left],
                    height[right]) * (right - left));

            if (height[left] < height[right])
                left += 1;
            else
                right -= 1;
        }
        return area;
    }

    public static void main(String [] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        //int[] height = {1,1};
        maxArea(height);
    }
}
