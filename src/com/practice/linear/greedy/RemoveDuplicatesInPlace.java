package linear.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
* Given sorted array, remove duplicates in-place.
*
*   Input: {-1,2,3,3,4,5,5,6,7}
*   Output: {-1,2,3,4,5,6,7}
*
*   This is a same direction two pointer problem. The trick is to remove the duplicates in place.
*
* Approach
*
*
*
*
* */

public class RemoveDuplicatesInPlace {


    public static void main(String[] args) {
        //Integer[] array = {-4, 2, -5, 1, 2, 3, 6, -5, 1};

        int[] array = {-1,2,3,3,4,5,5,6,7,17,18,21,21,13,26,37,38,38,39,40};
        //List<Integer> list = Arrays.asList(array);
       // //list.remove(1);

        removeDuplicatesInPlace(array);
    }

    private static void removeDuplicatesInPlace(int[] array) {

       if(array.length == 0){
           return;
       }

       int write = 1;
       for(int read = 1; read < array.length; read++){
           if(array[read] != array[read - 1]){
                array[write] = array[read];
                write++;
           }

       }

    }
}
