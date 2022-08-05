package linear;

/*
* https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/


import java.util.*;

public class LongestSubstringWithoutRepeatChars {

    //Step 1 - Find all substrings
    public static List<String> getAllSubStrings(String input) {
        final List<String> substrings = new ArrayList<>();

        for (int outerindex = 0; outerindex <= input.length(); outerindex++) {
            for (int innerIndex = outerindex; innerIndex <= input.length(); innerIndex++) {
                String tempSubstring = input.substring(outerindex, innerIndex);
                //System.out.println(tempSubstring);
                if (tempSubstring.length() != 0 && !substrings.contains(tempSubstring.trim())) {
                    substrings.add(tempSubstring);
                }
            }
        }
        System.out.println(substrings);
        return substrings;
    }

    //Step 2 - find the substring with non-repeating characters, collect them in a map in descending order of the count of the characters
//    public static Map<Integer, String> nonRepeatingCharacterSubstring(List<String> substrings) {
//
//        final Map<Integer, String> stringMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
//        for(String substring:substrings) {
//            HashSet<Character> stringSet = new HashSet<>();
//            if(substring.length()!=1) {
//                for(Character character : substring.toCharArray()) {
//                    stringSet.add(character);
//                }
//                //if the size of the set is equal to the length of the substring, it is a unique character substring, add it to the Map
//                if(stringSet.size()==substring.length()) {
//                    stringMap.put(substring.length(),substring);
//                }
//            } else {
//                stringMap.put(substring.length(),substring);
//            }
//        }
//        System.out.println(stringMap);
//        return stringMap;
//    }


//
//    //Step 3 - the topmost entry of the Map, and the key of the entry is the answer
//
//    public static Integer getTopMostEntry(Map<Integer, String> stringMap) {
//
//        return stringMap.entrySet().iterator().next().getKey();
//    }

//    public static int lengthOfLongestSubstring(String s) {
//        if(s.length()!=0) {
//            return getTopMostEntry(nonRepeatingCharacterSubstring(getAllSubStrings(s)));
//        } else {
//            return 0;
//        }
//
//    }

    public static int nonRepeatingCharacterSubstring(List<String> substrings) {
        int longestSubstringLength = 0;
        for (String substring : substrings) {
            HashSet<Character> stringSet = new HashSet<>();

            for (Character character : substring.toCharArray()) {
                stringSet.add(character);
            }
            //if the size of the set is equal to the length of the substring, it is a unique character substring, check if it is the longest encountered string
            if (stringSet.size() == substring.length() && longestSubstringLength < substring.length()) {
                longestSubstringLength = substring.length();
            }

        }
        System.out.println(longestSubstringLength);
        return longestSubstringLength;
    }

//    public static int lengthOfLongestSubstring(String s) {
//        if (s.length() != 0) {
//            return getTopMostEntry(nonRepeatingCharacterSubstring(getAllSubStrings(s)));
//        } else {
//            return 0;
//        }
//
//    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        } else {
            return nonRepeatingCharacterSubstring(getAllSubStrings(s));
        }

    }


    public static void main(String[] args) {

        lengthOfLongestSubstring("    ");

    }
}
