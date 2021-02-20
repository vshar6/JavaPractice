package linear;

public class WildCardMatching {

    public boolean isMatch(String s, String p) {

        char[] inputCharArray = s.toCharArray();
        char[] patternCharArray = p.toCharArray();

        int patternCharIterator = 0;
        String resultantString = "";

        if(s.equals(p) || p.equals("*")) {
            return true;
        }


        for(int inputCharIterator = 0;inputCharIterator < inputCharArray.length;inputCharIterator++) {

            if(inputCharArray[inputCharIterator] == patternCharArray[patternCharIterator] || patternCharArray[patternCharIterator]=='?') {
                resultantString = resultantString + inputCharArray[inputCharIterator];
            }

            if(patternCharArray[patternCharIterator]=='*') {
                //char nextPatternCharacter =
                int substringTargetIndex = 0;
                if(patternCharIterator == patternCharArray.length -1) {
                    substringTargetIndex = s.length()-1;
                } else {
                    substringTargetIndex = s.indexOf(patternCharArray[patternCharIterator+1]);
                }

                resultantString = resultantString + findSubString(s,inputCharIterator,substringTargetIndex);
                inputCharIterator = substringTargetIndex-1;

            }

            if(patternCharIterator >= patternCharArray.length-1) {
                    if(inputCharIterator == inputCharArray.length - 1) {
                        return s.equals(resultantString);
                    }  else {
                        return false;
                    }
            }
            patternCharIterator ++;
        }

        return false;
    }

    private String findSubString(String s,int indexOfInputArray, int substringTargetIndex) {
        return s.substring(indexOfInputArray,substringTargetIndex);
    }


    public static void main(String [] args) {

        String input = "aab";
        String pattern = "c*a*b";
        WildCardMatching wildCardMatching = new WildCardMatching();

        System.out.println(wildCardMatching.isMatch(input, pattern));
    }

}
