package linear;

public class BubbleSort {

    private static int[] bubbleSort(int [] args) {
        int lengthOfArgs = args.length;
        for(int i=0;i<lengthOfArgs-1; i++) {
            for(int j=1;j<lengthOfArgs-i;j++) {
                if(args[j]<args[j-1]) {
                    Practice.swapElements(args, j, j-1);
                }
            }
        }
        Practice.printArray(args);

        return args;

    }
}
