public class CatalanNumber {

    public static int catalan(int n) {
        int sum = 0;
        if(n==0 || n==1) {
            return 1;
        } else {
            for(int i = 0;i<n;i++) {
                sum = sum + catalan(i)*catalan(n-i-1);
            }
        }

        return sum;
    }

    public static void main(String [] args) {
        System.out.println(catalan(3));
    }
}
