package linear;

public class ShortestSubArray {

    public int findLengthOfShortestSubarray(int[] arr) {

        int startIndex = 0;
        int referenceIndex = 0;
        int length = 0;
        for(int index = 1; index < arr.length; index++) {
            if (arr[index - 1] > arr[index]) {
                startIndex = index - 1;
                referenceIndex = (startIndex - 1);

                if (referenceIndex < 0) {
                    referenceIndex = 0;
                }
                break;
            }
        }
        for (int endIndex = arr.length - 1; endIndex > startIndex; endIndex--) {
            if (arr[endIndex] < arr[referenceIndex]) { //condition when end index is lesser than the reference index, this means this is the end Index we were looking for
                length = endIndex - startIndex + 1;
                if(length==arr.length) {
                    length = length -1;
                }
                System.out.println("length:" + length);
                return length;
            } else {
                if (arr[endIndex] < arr[endIndex - 1]) {
                    length = endIndex - startIndex + 1;

                    if(length==arr.length) {
                        length = length -1;
                    }
                    System.out.println("length:" + length);
                    return length;
                } else {
                    System.out.println("arr[" + endIndex + "] =" + arr[endIndex] + ";arr[" + startIndex + "]=" + arr[startIndex]);
                    continue;
                }
            }
        }

        System.out.println("length:" + length);
        return length;
    }

    public static void main(String [] args) {
        int [] array ={2,2,2,1,1,1,3,3,3};
        //int [] array = {1,2,3,10,0,7,8,9};
        //int [] array = {5,4,3,2,1};
        new ShortestSubArray().findLengthOfShortestSubarray(array);
    }


}
