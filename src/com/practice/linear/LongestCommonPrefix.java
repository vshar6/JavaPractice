package linear;

/*
* https://leetcode.com/problems/longest-common-prefix/
*
* Write a function to find the longest common prefix string amongst an array of strings.
* If there is no common prefix, return an empty string "".
*
* Example 1:
* Input: strs = ["flower","flow","flight"]
* Output: "fl"
*
*
* Example 2:
* Input: strs = ["dog","racecar","car"]
* Output: ""
* Explanation: There is no common prefix among the input strings.
* */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        //int [] sizeofStrs = new int[strs.length];
        String idealPrefix = getSmallestWord(strs);

        //String longestCommonPrefix = getCommonPrefix(strs,idealPrefix);
        //System.out.println("longestCommonPrefix:"+longestCommonPrefix);
        return getCommonPrefix(strs,idealPrefix);
    }

    private static String getCommonPrefix(String[] strs, String idealPrefix) {
        String longestCommonPrefix;
        int counter = 0;
        for(String str:strs) {

            if (idealPrefix.equals(str.substring(0, idealPrefix.length()))) {
                counter++;
                if(counter==strs.length) {
                    return idealPrefix;
                }
            } else {
                idealPrefix = idealPrefix.substring(0, idealPrefix.length() - 1);
                break;
            }
        }

        if (idealPrefix.length() <= 0) {
            return "";
        }  else {
            longestCommonPrefix = getCommonPrefix(strs, idealPrefix);
        }
        return longestCommonPrefix;
    }

    private static String getSmallestWord(String[] strs) {
        int smallestIndex = 0;
        int smallestLength = strs[smallestIndex].length();
        for(int index = 1; index< strs.length; index++) {
            if(smallestLength > strs[index].length()) {
                smallestLength = strs[index].length();
                smallestIndex = index;
            }
        }
        //System.out.println("smallestIndex:"+smallestIndex);
        //System.out.println("smallestWord:"+strs[smallestIndex]);

        return strs[smallestIndex];
    }

    public static void main(String[] args) {
        String [] strs = {"flower","flowing","flight"};
        longestCommonPrefix(strs);

    }
}
