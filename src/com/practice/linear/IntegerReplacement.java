package linear;

public class IntegerReplacement {

    int numberOfOperations = 0;
    public int integerReplacement(int n, int operations) {

        if(n%2 == 0) { //even number
            if(powerOf2(n)) {
                return countOperations(n, numberOfOperations);
            } else {
                numberOfOperations ++;
                integerReplacement(n/2, numberOfOperations);
            }
        } else { //odd number
            numberOfOperations ++;
            if(powerOf2(n+1) ) {
                return countOperations(n+1, numberOfOperations);
            } else if(powerOf2(n-1)) {
                return countOperations(n+1, numberOfOperations);
            } else {

            }
        }

        return numberOfOperations;
    }

    private boolean powerOf2(int n) {
        if (n == 1) {
            return true;
        }
        else if (n % 2 != 0 || n ==0) {
            return false;
        }

        return powerOf2(n / 2);
    }

    private int countOperations(int n, int numberOfOperations) {
        int number = n/2;
        if(number==1) {
            return numberOfOperations;
        } else {
            numberOfOperations++;
            countOperations(number, numberOfOperations);
        }
        return 1;
    }
}
