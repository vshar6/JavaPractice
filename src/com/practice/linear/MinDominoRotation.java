package linear;


/* https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/ */

public class MinDominoRotation {

    public int minDominoRotations(int[] A, int[] B) {
        int minRotation = Math.min(
                minRotate(A[0],A,B),minRotate(B[0],A,B)
        );
        minRotation = Math.min(minRotation,minRotate(A[0],B,A));
        minRotation =  Math.min(minRotation,minRotate(B[0],B,A));

        return minRotation==Integer.MAX_VALUE?-1:minRotation;
    }

    private int minRotate(int item, int[] A, int[] B) {
        int minRotations = 0;
        for(int i =0;i<A.length;i++) {
            if(A[i]!= item && B[i]!=item) {
                return Integer.MAX_VALUE;
            } else if(A[i]!= item) {
                minRotations ++;
            }
        }
        return minRotations;
    }

    public static void main(String [] args) {
        int [] A = {2,1,2,4,2,2}, B = {5,2,6,2,3,2};
        MinDominoRotation dominoRotation = new MinDominoRotation();
        dominoRotation.minDominoRotations(A, B);
    }
}
