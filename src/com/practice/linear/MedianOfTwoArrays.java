package linear;

// https://leetcode.com/problems/median-of-two-sorted-arrays/

public class MedianOfTwoArrays {



    public static int median(int [] firstArray, int [] secondArray) {
        int [] mergedArray = new int[firstArray.length+secondArray.length];
        int lengthOftheMergedArray = mergedArray.length;

        int firstArrayPointer = 0, secondArrayPointer =0, mergedArrayPointer = 0;
        int indexOfMedian = 0;
        boolean isMergedArrayOddLength = false;

        if(lengthOftheMergedArray % 2 != 0) {
            isMergedArrayOddLength = true;
            indexOfMedian = mergedArray.length/2;
        } else {
            indexOfMedian = (mergedArray.length/2)-1;
        }

        while(firstArrayPointer < firstArray.length &&  secondArrayPointer < secondArray.length) {
            if(indexOfMedian >= mergedArrayPointer) {
                if(firstArray[firstArrayPointer] < secondArray[secondArrayPointer]) {
                    mergedArray[mergedArrayPointer] = firstArray[firstArrayPointer];
                    firstArrayPointer++;
                } else {
                    mergedArray[mergedArrayPointer] = secondArray[secondArrayPointer];
                    secondArrayPointer++;
                }

                    mergedArrayPointer++;

            } else {
                if(isMergedArrayOddLength) {
                    return mergedArray[indexOfMedian];
                } else {
                    return (mergedArray[indexOfMedian] +  mergedArray[indexOfMedian+1])/2;
                }
            }
        }

        while(firstArrayPointer < firstArray.length ) {
            mergedArray[mergedArrayPointer] = firstArray[firstArrayPointer];
            firstArrayPointer++;
            mergedArrayPointer++;
            if(indexOfMedian == mergedArrayPointer) {
                if(isMergedArrayOddLength) {
                    return mergedArray[indexOfMedian];
                } else {
                    return (mergedArray[indexOfMedian] +  mergedArray[indexOfMedian+1])/2;
                }
            }
        }

        while(secondArrayPointer < secondArray.length) {
            if(indexOfMedian == mergedArrayPointer) {
                if(isMergedArrayOddLength) {
                    return mergedArray[indexOfMedian];
                } else {
                    return (mergedArray[indexOfMedian] +  mergedArray[indexOfMedian+1])/2;
                }
            }
            mergedArray[mergedArrayPointer] = secondArray[secondArrayPointer];
            secondArrayPointer++;
            mergedArrayPointer++;
        }
        return 0;
    }



    public static void main(String [] args) {

        int [] firstArray = {1,3};
        int [] secondArray = {2};


        //System.out.println(xmedian(firstArray,secondArray));

    }
}
