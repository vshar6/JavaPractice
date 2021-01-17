

public class SelectionSort {
    private static int[] selectionSort(int [] args) {

        int lengthOfArgs = args.length;
        for (int i = 0; i < lengthOfArgs - 1; i++) {
            int indexOfSmallest = i;
            for (int j = i + 1; j < lengthOfArgs; j++) {

                if (args[j] < args[i]) {
                    indexOfSmallest = j;
                }
            }
            //System.out.println("Smallest:"+smallest);
            System.out.println("Index of smallest:" + indexOfSmallest);
            Practice.swapElements(args, i, indexOfSmallest);

            Practice.printArray(args);

        }
        // printArray(args);

        //System.out.println(smallest);
        return args;
    }
}
