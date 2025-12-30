//https://leetcode.com/problems/minimum-time-to-make-rope-colorful/description/?envType=daily-question&envId=2025-11-03
/*
Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
Return the minimum time Bob needs to make the rope colorful.

        Input: colors = "abaac", neededTime = [1,2,3,4,5]
        Output: 3
        Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
        Bob can remove the blue balloon at index 2. This takes 3 seconds.
        There are no longer two consecutive balloons of the same color. Total time = 3.

        Input: colors = "abc", neededTime = [1,2,3]
        Output: 0
        Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.


        Input: colors = "aabaa", neededTime = [1,2,3,4,1]
        Output: 2
        Explanation: Bob will remove the balloons at indices 0 and 4. Each balloons takes 1 second to remove.
        There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.

*/


package linear;

import java.util.*;
import java.util.stream.Collectors;

public class MinimalTimeToColorfulRope {


    private static boolean isAlreadyColorful(String colors, int [] neededTime) {
        boolean isAlreadyColorful = false;

        Set<Character> uniqueColors = new HashSet<Character>();
        for (char c : colors.toCharArray()) {
            uniqueColors.add(c);
        }

        return uniqueColors.size() == colors.length();
    }

//    public static int getMinCost(String colors, int[] neededTime) {
//        int minCost = 0;
//        if(colors.length()!=neededTime.length) {
//            return 0;
//        }
//
//        if(!isAlreadyColorful(colors)) {
//            int counter = 0;
//
//           while(counter < neededTime.length-1) {
//               if(colors.charAt(counter) == colors.charAt(counter+1)) {
//                   minCost = minCost + (Math.min(neededTime[counter], neededTime[counter + 1]));
//               }
//               counter++;
//           }
//        }
//
//        return minCost;
//    }

    public static int getMinCost(String colors, int[] neededTime) {
        int minCost = 0;
        if(colors.length() != neededTime.length) {
            return 0;
        } else {
            return getMinCost(colors, neededTime,minCost,0);
        }
    }

public static int getMinCost(String colors, int[] neededTime, int minCost, int counter) {
    if(!isAlreadyColorful(colors,neededTime)) {
        char currentchar = colors.charAt(0);
        int colorCounter = 0;
        List<Integer> tempArray = new ArrayList<>();
        while(colorCounter < colors.length() && colors.charAt(colorCounter)==currentchar) {
            tempArray.add(neededTime[counter]) ;
            colorCounter++;
            counter++;
        }
        minCost = minCost+findMinSum(tempArray);

        if(counter > colors.length()) {
            return minCost;
        } else {
            getMinCost(colors.substring(colorCounter,colors.length()),neededTime,minCost,counter);
        }
    }

    return minCost;

}

    private static int findMinSum(List<Integer> inputArray) {
        int minSum = 0;
        inputArray= inputArray.stream().sorted().limit(inputArray.size()-1).collect(Collectors.toList());

        if(inputArray.size() > 1) {

            for(int i = 0; i < inputArray.size(); i++) {
                minSum += inputArray.get(i);
            }
        }

        return minSum;
    }


    public static void main(String[] args) {
        //int minCost = getMinCost("aabaa", new int[]{1,2,3,4,1});
        System.out.println(getMinCost("aaabbbabbbb", new int[]{3,5,10,7,5,3,5,5,4,8,1}));
        //aaabbbabbbb
        // 3+5, 'aa'-abbbabbbb = 8
        // 8+(5+3), 'aa'-ab-'bb'-abbbb = 16
        // 16 + (5+4+1), 'aa' - ab - 'bb' - a - 'bb'-b-'b' = 26

    }
}
