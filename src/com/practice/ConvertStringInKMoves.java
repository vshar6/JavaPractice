import java.util.*;

/* https://leetcode.com/problems/can-convert-string-in-k-moves/ */

/* Work in Progress */

/*
*  String s is the first String
* String t is the second String
* k is the allowed number of passes
* */
public class ConvertStringInKMoves {

    public static boolean canConvertString(String s, String t, int k) {
        if (s == null || t == null || s.length() != t.length() || k < 0) {
            return false;
        }
        Map<Integer, Integer> shiftsToFreq = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                int shift = t.charAt(i) - s.charAt(i);
                if (shift < 0) {
                    shift += 26;
                }
                shiftsToFreq.put(shift, shiftsToFreq.getOrDefault(shift, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : shiftsToFreq.entrySet()) {
            int shift = entry.getKey();
            int freq = entry.getValue();
            if (shift + (freq-1)*26 > k) {
                return false;
            }
        }
        return true;
    }



    /*a-t=-19;t-v=-2;m-b=11;x-j=14;z-h=18;j-v=-12;k-j=1;z-d=22*/
    public static void main(String [] args) {
       System.out.println(canConvertString("jicfxaa","ocxltbp",15));
        //System.out.println(generateTheString(22));
    }
}
