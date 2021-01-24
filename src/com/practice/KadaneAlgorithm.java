
/* https://www.educative.io/m/largest-sum-subarray */

public class KadaneAlgorithm {

    public static int sum(int[] array) {

        int maxSum = array[0];
        int sumPerIteration = array[0];

        for(int i = 1; i < array.length; i++) {

            if(sumPerIteration < 0) {
                sumPerIteration = array[i];
            } else {
                sumPerIteration=sumPerIteration + array[i];
            }

            if(sumPerIteration > maxSum) {
                maxSum = sumPerIteration;
            }
        }

        return maxSum;

    }

    public static void main(String[] args) {
        int[] array = new int[]{-4, 2, -5, 1, 2, 3, 6, -5, 1};
        System.out.println("Sum of largest subarray: " + sum(array));

        //System.out.println(-4+ 2 -5+ 1+ 2+ 3+ 6 -5+ 1);
    }



}
