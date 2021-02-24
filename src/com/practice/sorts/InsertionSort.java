package sorts;

import linear.Practice;

public class InsertionSort {

    protected static int[] insertionSort(int [] args) {

        for(int j=1;j<args.length;j++) {
            int i=j-1;
            int key = args[j];

            while(i>=0 && args[i]>key) {
                args[i+1]=args[i];
                i--;
            }
            args[i+1] = key;
        }
        //Practice.printArray(args);
        return args;
    }
}
