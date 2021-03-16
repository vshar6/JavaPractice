package linear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BubbleSort {

    private static int[] bubbleSort(int [] args) {
        int lengthOfArgs = args.length;
        for(int i=0;i<lengthOfArgs-1; i++) {
            for(int j=1;j<lengthOfArgs-i;j++) {
                if(args[j]<args[j-1]) {
                    Practice.swapElements(args, j, j-1);
                }
            }
        }
        Practice.printArray(args);

        return args;

    }

    public static String getLargestString(String s, int k) {

        Map<Character, Integer> characterMap= new HashMap<>();
        List<Character> charList = new ArrayList<>();

        for(Character character: s.toCharArray()) {
            characterMap.put(character, characterMap.getOrDefault(character, 0)+ 1);
        }

        return "";
    }
}
