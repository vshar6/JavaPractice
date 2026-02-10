package linear.greedy;

//Given a string, find the length of the longest substring with at most K distinct characters.

/*
    Example 1
    Input: s = "eceba"; k = 2
    Output:2
    Explanation: Valid substrings (≤ 2 distinct chars):
            "e" → {e}
            "ec" → {e, c}
            "ece" → {e, c}
            "ce" → {c, e}
            "eb" → {e, b}

     Example 2
     Input: s = "abcdef";k = 2
     Output:2
    Explanation: Valid substrings:
            "ab" → {a, b}
            "bc" → {b, c}
            "cd" → {c, d}
*/

import java.util.HashMap;
import java.util.Map;

public class LongestStringWithKDistinctChars {

    public static int longestSubstringKDistinct(String s, int k) {

        int length = 0, left = 0;
        char [] strs = s.trim().toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for(int right=0;right<s.length();right++){
            map.put(strs[right], map.getOrDefault(strs[right], 0)+1);
            while(map.size()>k){
                char leftVal = strs[left];
                map.put(leftVal,map.get(leftVal)-1);

                if(map.get(leftVal) ==0) {
                    map.remove(leftVal);
                }
                left++;
            }

            length = Math.max(length,right-left+1);
        }


        return length;
    }

    public static void main(String[] args) {

    }
}
