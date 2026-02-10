package linear.greedy;

/*
    You are given an array height[], where height[i] represents the height of a vertical line at index i.
    Choose two lines such that they form a container that holds the maximum amount of water.

    Return the maximum area.

    Example
        Input: [1,8,6,2,5,4,8,3,7]
        Output: 49


    Solution:
        This is a classical greedy two pointer approach.
        Let height[] is an array where height[i] contains the height of one wall of the container.

        So following would be the constraints -
            a) The area = min(height[left],height[right]) x (right-left);
            b) The greedy invariant is that the pointers would move only when the new area is more than the earlier area
            c) Only way to increase the area is to increase the min height as the width is constant
*/

public class BucketWithMostWater {


    public static int maxArea(int[] height){
        int left = 0, right = height.length-1;
        int area = 0;

       while(left < right) {
            int tempArea = Math.min(height[left],height[right]) * (right - left);

            if(tempArea > area){
                area = tempArea;
            }

            // Since the key is that the window shrinks depending upon which side of the container is lower
            if(height[left] < height[right]){
                left++;
            }  else {
                right--;
            }

        }
        System.out.println("area:"+area);
        return area;

    }

    public static void main(String[] args) {
        int [] _height = {1,8,6,2,5,4,8,3,7};

        maxArea(_height);
    }



}
