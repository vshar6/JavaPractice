package linear;

import java.util.*;

public class LongestWealthyInterval {

    public int longestWPI(int[] hours) {

        int [] wealthArray = computeWealthIndicator(hours);
        int longestWPI = longestPositiveSubArray(wealthArray);
        return longestWPI<=0?0:longestWPI;
    }

    private int [] computeWealthIndicator(int [] hours) {
        int [] wealthArray = new int[hours.length];

        for(int i = 0;i<hours.length;i++) {
            if(hours[i] > 8) {
                wealthArray[i] = 1;
            } else {
                wealthArray[i] = -1;
            }
        }
        return wealthArray;
    }

    private int longestPositiveSubArray(int[] wealthArray) {
        for(int i = 0;i<wealthArray.length;i++) {
            int startIndex = i;
            int endIndex = 0;
            int maxsum = wealthArray[i];
            for(int j = i+1;i < wealthArray.length;j++) {
                int sum = wealthArray[i] + wealthArray[j];

                if(sum > maxsum) {
                    maxsum = sum;
                }

                if(sum <= maxsum) {
                    endIndex = j-1;
                }
            }
        }
        return 0;
    }

    private void printArray(int[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + ",");
        }
    }

    public static void main(String [] args) {
        LongestWealthyInterval longestWealthyInterval = new LongestWealthyInterval();

        int[] array = {9,9,6,0,6,6,9};
        longestWealthyInterval.longestWPI(array);
    }
}
