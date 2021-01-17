package com.walmart;

public class QuickSort {

    protected void quickSort(int[] array, int begin, int end) {
        int partition = partition(array,0,array.length-1);
        if(begin<partition-1) {
            quickSort(array, begin,partition);
        }
        if(end > partition) {
            quickSort(array,partition, end);
        }
    }

    protected static int partition(int arr[], int begin, int end) {

        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        SumTwo.printArray(arr);
        return i+1;
    }
}
