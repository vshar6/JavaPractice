package sorts;

import linear.Practice;

public class ShellSort {

    private static int[] shellSort(int[] arr){
        int interval = 1;
        int temp;
        // interval calculation using Knuth's interval sequence
        while(interval <= arr.length/3){
            interval = (interval * 3) + 1;
        }
        while(interval > 0){
            for(int i = interval; i < arr.length; i++){
                temp = arr[i];
                int j;
                for(j = i; j > interval - 1 && arr[j-interval] >= temp; j=j-interval){
                    arr[j] = arr[j - interval];
                }
                arr[j] = temp;
            }
            // reduce interval
            interval = (interval - 1)/3;
        }
        Practice.printArray(arr);
        return arr;
    }

}
