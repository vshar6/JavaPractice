package sorts;

import linear.Practice;

/*
 *  https://leetcode.com/problems/sort-array-by-parity/
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] array) {
        int [] helperArray = new int[array.length];
        int j=0;
        int k=array.length;
        for(int i = 0;i<array.length;i++) {
            if(array[i]%2==0) {
                helperArray[j]=array[i];
                j++;
            } else {
                helperArray[k-1]=array[i];
                k--;
            }
        }
        //Practice.printArray(helperArray);
        return helperArray;
    }

    public static void main(String [] args) {
        int[] array = {3,1, 2, 4};//, 65, 32, 22, 9, 44, 31};
        sortArrayByParity(array);
    }

}
