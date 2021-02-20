package linear;

import java.util.Arrays;

public class CountingSort {

    public void sort(int[] data) {
        int[] temp = new int[26];

        for (int i = 0; i < data.length; i++) { // populate the temp array
            temp[data[i]] = temp[data[i]] + 1;
        }

        int curr = 0;

        for (int i = 0; i < temp.length; i++) { // k iterations
            for (int j = 0; j < temp[i]; j++) { // n/k iterations for each (avg)
                data[curr] = i;
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {25,2,7,2,18,23,12,18};
        System.out.println(Arrays.toString(data));
        new CountingSort().sort(data);
        System.out.println(Arrays.toString(data));
    }
}
