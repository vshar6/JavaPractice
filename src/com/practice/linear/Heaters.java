package linear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/heaters/

public class Heaters {

    public static void fizzBuzz(int n) {

        for(int index = 1; index <= n; index++) {
            if(index < 3) {
                System.out.println(index);
            } else if(index%3==0 && index%5==0) {
                System.out.println("FizzBuzz");
            } else if(index%3==0 && index%5!=0) {
                System.out.println("Fizz");
            } else if(index%3!=0 &&  index%5==0) {
                System.out.println("Buzz");
            } else {
                System.out.println(index);
            }
        }

    }

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxDistance = 0;

//        if(heaters.length >=houses.length) {
//            return maxDistance;
//        }
             if(heaters.length==1) {
            for(int index = 0 ; index < houses.length ; index ++) {
                if(heaters[0]!=houses[index]) {
                    int tempDistance = Math.abs(houses[index] - heaters[0]);
                    if(tempDistance > maxDistance) {
                        maxDistance = tempDistance;
                    }
                }
            }
        }
        else if(houses[houses.length - 1] < heaters[0]) {
            maxDistance = heaters[0];
            return maxDistance;
        } else if(heaters[heaters.length-1] <houses[0]) {
            maxDistance = houses[0];
            return maxDistance;
        }
        else {
            if(heaters[0] >= houses [0] && heaters[heaters.length-1] <= houses[houses.length-1]) {
                maxDistance = Math.max(Math.abs(houses[0] - heaters[0]), Math.abs(houses[houses.length - 1] - heaters[heaters.length - 1]));
                for (int index = 1; index < heaters.length; index++) {
                    int tempDistance = (int) Math.floor(Math.abs(heaters[index - 1] - heaters[index]) / 2);

                    if (tempDistance > maxDistance) {
                        maxDistance = tempDistance;
                    }
                }
            } else {
                maxDistance = Math.min(Math.abs(houses[houses.length-1] - heaters[0]), Math.abs(houses[houses.length - 1] - heaters[heaters.length - 1]));
            }
        }



        System.out.println("maxDistance:"+maxDistance);
        return maxDistance;
    }
    //[282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923]
    //[823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612]
    public static void main(String [] args) {
        int [] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int [] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        //new Heaters().findRadius(houses,heaters);
        //fizzBuzz(15);

        renameFile("abc","aaabbbccc");
    }

    public static int renameFile(String newName, String oldName) {
        int newStringLength = newName.length();
        int oldStringLength = oldName.length();

        int ways = 0;
        int characterDiff = oldStringLength - newStringLength;
        if(characterDiff <= 0 || newName.equals(oldName)) {
            return ways;
        } else {
            for(int index = 0;index <= oldStringLength - characterDiff; index ++) {
                String currentStringPrefix = oldName.substring(0, index);
                int currentNameStartIndex = index + characterDiff - 1;

                String currentName = currentStringPrefix + oldName.substring(currentNameStartIndex,oldStringLength - 1);
                if(currentName.equals(newName)) {
                    ways ++;
                }
            }
            System.out.println(ways);
            return ways;
        }
    }

}
