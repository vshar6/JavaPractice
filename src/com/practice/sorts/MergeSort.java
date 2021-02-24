package sorts;

import linear.Practice;

public class MergeSort {
    public static void mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array,helper,0,array.length-1);
    }

    public static int[] mergeSort(int[] array, int[] helper, int start, int end) {

        if(start<end) {
            int middle = (start+end)/2;
            mergeSort(array,helper,start, middle);
            mergeSort(array, helper,middle+1, end);
            merge(array, helper, start, middle, end);
        }

        return null;
    }

    static void merge(int[] array, int[] helper, int low, int middle, int high) {
        for (int i =low; i <= high;i++){
            helper[i] =array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;

        int current = low;


        /* Iterate through helper array. Compare the left and right half, copying back the sm • element from the two halves into the original array." */

        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;

            /*Copy the rest of the left side of the array into the target array */

            int remaining = middle - helperLeft;

            for (int i = 0; i <= remaining; i++) {
                array[current + i] = helper[helperLeft + i];
            }
        }

        //Practice.printArray(array);
    }
}
