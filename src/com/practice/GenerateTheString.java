

/* https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
int n = length of the string
 */
public class GenerateTheString {

    public static String generateTheString(int n) {
        StringBuilder theString = new StringBuilder();
        if(n%2==0) {
            for(int i=0;i<n-1;i++) {
                theString=theString.append("a");
            }
            theString = theString.append("b");
        } else {
            for(int i=0;i<n;i++) {
                theString=theString.append("a");
            }
        }
        return theString.toString();
    }
}
