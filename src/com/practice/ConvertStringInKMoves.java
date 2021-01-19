import java.util.HashSet;
import java.util.Set;

/* https://leetcode.com/problems/can-convert-string-in-k-moves/ */

/* Work in Progress */


public class ConvertStringInKMoves {

    public static boolean canConvertString(String s, String t, int k) {

        if(s.equals(t)) {
            return true;
        }

        char [] firstCharArray = s.toCharArray();
        char [] secondCharArray = t.toCharArray();

        int [] diffIndexes = new int [firstCharArray.length];
        Set<Integer> setOfPasses = new HashSet<>();

        setOfPasses.add(0);

        //store dissimilar indexes
        if(firstCharArray.length != secondCharArray.length || k<firstCharArray.length) {
            return false;
        }

        //aab bbb
        for(int i = 0;i < firstCharArray.length;i++) {
            diffIndexes[i] = secondCharArray[i]-firstCharArray[i];
            System.out.println("for i="+i+", difference between "+secondCharArray[i]+" and "+firstCharArray[i]+" is "+diffIndexes[i]);

            if(diffIndexes[i] > k) {
                System.out.println(diffIndexes[i]+" pass is greater than the allowed number of passes:"+k);
                return false;
            }

            if((diffIndexes[i]!=0) && setOfPasses.contains(diffIndexes[i])) {
                if(k>=diffIndexes[i] + 26) {
                    setOfPasses.add(26 + diffIndexes[i]);
                } else {
                    System.out.println(diffIndexes[i] + " pass has already been executed, it can not be executed again");
                    return false;
                }
            } else if(diffIndexes[i] < 0){
                if((26 + diffIndexes[i])> k) {
                    System.out.println((26 + diffIndexes[i])+" is greater than total number of allowed passes:"+k);
                    return false;
                } else {
                    setOfPasses.add(26 + diffIndexes[i]);
                }

            } else {
                setOfPasses.add(diffIndexes[i]);
            }
        }
        return true;

    }
}
