package linear;


import java.util.ArrayList;
import java.util.List;

/*
* Input = 1102021222
* k = 2
* Output = 5
* Explanation = [11,02,02,0202,22,22]
*
*
*
*
*
*
*
* */
public class PerfectString {

    public static int perfectStrings(String input, int k) {

        //Get the substrings of the array of the multiples of k
        List<String> substrings = getAllSubStrings(input,k);

        //Check if the 'k' chunks of the substrings are equal
        int count = identicalChunks(substrings,k);
        System.out.println("count:"+count);

        return count;
    }

    //Create chunks of 'k' sizes

    private static int identicalChunks(List<String> substrings, int k) {
        int count = 0;
        for(String value:substrings) {
            boolean isChunkIdentical = true;
            if(value.length() == 2 &&  value.charAt(0)!=value.charAt(1)) {
                isChunkIdentical = false;
            } else {
                List<String> chunks = new ArrayList<>();
                String localChunk = "";

                for (int i = 0; i < value.length(); i += k) {
                    String currentChunk = value.substring(i, Math.min(value.length(), i + k));
                     if(!localChunk.equals("") && !localChunk.equals(currentChunk)) {
                         isChunkIdentical = false;
                         break;
                    } else{
                        localChunk = currentChunk;
                    }
                }

            }
            if(isChunkIdentical) {
                System.out.println("perfect String:"+value);
                count ++;
            }
        }

        return count;
    }

    public static List<String> getAllSubStrings(String input,int k) {
        List<String> substrings = new ArrayList<>();

        for(int outerindex = 0; outerindex <= input.length();outerindex++) {
            for(int innerIndex = outerindex;innerIndex <= input.length();innerIndex++) {
                String tempSubstring = input.substring(outerindex,innerIndex);
                System.out.println(tempSubstring);
                if(tempSubstring.trim().length()!=0 && tempSubstring.length()%k==0) {
                    substrings.add(tempSubstring);
                }
            }

        }

        System.out.println(substrings);
        return substrings;
    }


    public static void main(String[] args) {
        perfectStrings("1102021212",2);
    }
}
