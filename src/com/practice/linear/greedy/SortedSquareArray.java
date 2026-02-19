package linear.greedy;



/*]
*
*  Problem: Given a sorted array, return a sorted array that contains the squares of the elements
*
*
*  Solution: This approach entails the usage of a two pointer approach with opposite direction.
*   The reason behind
*       Using the two pointer approach - one pointer traverses and the other pointer applies the constraint.
*       Opposite direction - The square of any number would be greater than the number, and must lie on the right of the sorted array.
*
*
*
*
*
*
* */


public class SortedSquareArray {


    public static void main(String[] args) {
        int[] array = {-4, 2, -5, 1, 2, 3, 6, -5, 1};

        System.out.println(getSortedSquare(array));

    }

    private static int[] getSortedSquare(int[] array) {
        int length = array.length-1;
        int [] result = new int [length];
        int left = 0, right = length, position = length;

        while(left < right) {
            int leftSquare = array[left]*array[left];
            int rightSquare = array[right]*array[right];
            position--;
            if(leftSquare > rightSquare) {
                result[position]=leftSquare;
                left++;
            } else {
                result[position]=rightSquare;
                right--;
            }

        }

        return result;

    }
}
