package linear;

/* https://leetcode.com/problems/sum-of-square-numbers/ */
public class JudgeSquareSum {

    public boolean judgeSquareSum(int c) {

        double iterator =  Math.floor(Math.sqrt(c));

        for(double i = iterator; i>=0;i--) {
            double b = c - Math.pow(iterator,2);
            if(b>=0) {
                double temp = Math.sqrt(b);
                if(temp - Math.floor(temp) ==0) {
                    return true;
                } else {
                    iterator = iterator - 1;
                }
            }

        }
        return false;
    }

    public static void main(String []  args) {
        JudgeSquareSum judgeSquareSum = new JudgeSquareSum();
        System.out.println(judgeSquareSum.judgeSquareSum(1000));

       // System.out.println(interator);
    }
}
