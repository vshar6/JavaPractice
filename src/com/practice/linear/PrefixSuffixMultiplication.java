package linear;

/*
* Given an array arr[] of n integers, construct a Product Array prod[] (of the same size)
* such that prod[i] is equal to the product of all the elements of arr[] except arr[i]
* without using the division.
* Input: arr[]  = {1, 2, 3, 4, 5}
* Output: ans[]  = {120, 60, 40, 30, 24 }
* */


import java.util.Arrays;

public class PrefixSuffixMultiplication {


    public int doMultiplication(int [] array) {
        int mulitplication = 0;
        if(array.length > 0) {
            for(int i= 0;i<array.length;i++) {
                mulitplication = mulitplication * array[i];
            }
        } else {
            return 0;
        }

       return mulitplication;
    }

    public static int [] getOutputArray(int [] input) {
        int result = 0;
        int [] output = new int [input.length];
        for(int outputIndex = 0;outputIndex<input.length;outputIndex++) {
            int temp = input[outputIndex];
            input[outputIndex]=1;
            result = Arrays.stream(input).reduce(1,(multiplication,element)->multiplication*element);
            input[outputIndex]=temp;
            output[outputIndex] = result;
            System.out.println(result);
        }

        return output;
    }


    public static void main(String [] args) {
        int [] array = {1, 2, 3, 2, 0};
        getOutputArray(array);
    }
}
