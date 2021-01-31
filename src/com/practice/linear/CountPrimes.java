package linear;

import java.util.ArrayList;

/* https://leetcode.com/problems/count-primes/ */
public class CountPrimes {

    int index = 2;
  //  int size = 0;
    final ArrayList<Integer>  numberOfPrimes = new ArrayList<>(); ;

//    public CountPrimes(int size) {
//        numberOfPrimes = new ArrayList<>(size+1);
//        for(int i = 0; i<=size+1;i++) {
//            numberOfPrimes.add(Boolean.FALSE);
//        }
//    }

    public  int countPrimes(int n) {
        return countPrimes(n, index);
    }

//    private int sieveOfEratosthenes(int n)
//    {
//        if(n<=2) {
//            return 0;
//        }
//
//        boolean prime[] = new boolean[n + 1];
//        int size = 0;
//        for (int i = 0; i <= n; i++) {
//            prime[i] = true;
//        }
//        for (int p = 2; p * p <= n; p++) {
//            if (prime[p] == true) {
//                for (int i = p * p; i <= n; i += p)
//                    prime[i] = false;
//            }
//        }
//
//        for (int i = 2; i < n; i++) {
//            if (prime[i] &&i>=2) {
//                System.out.println(i + " ");
//                size = size +1;
//            }
//
//        }
//
//
//        System.out.println(size + ":size");
//        return size;
//    }
//    private int isPrimeSieveOfEratosthenes(int n) {
//        for(int temp=2;temp<=Math.sqrt(n);temp+=2) {
//            if(Boolean.TRUE.equals(numberOfPrimes.indexOf(temp))) {
//                for(int k = temp*temp;k<=n;k+=temp) {
//                    numberOfPrimes.add(k,false);
//                }
//            }
//        }
//        for(Boolean isPrime: numberOfPrimes) {
//            if(isPrime) {
//                size++;
//            }
//        }
//        return size;
//    }

    private boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

            // Check if number is 2
        else if (n == 2)
            return true;

            // Check if n is a multiple of 2
        else if (n % 2 == 0)
            return false;

        // If not, then just check the odds
        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int countPrimes(int n, int index) {

        if(n<=1) {
            return 0;
        }
        else if(n==2) {
            return 0;
        }
        else if(n==index) {
            return numberOfPrimes.size();
        } else {
            if(isPrime(index)) {
                numberOfPrimes.add(index);
            }
            index = index +1;
        }

        return countPrimes(n,index++);
    }

    public static void main(String [] args) {
        int size = 5;
        CountPrimes c = new CountPrimes();
        System.out.println(c.countPrimes(size));
       // System.out.println(c.isPrimeSieveOfEratosthenes(5));
        //System.out.println(isPrime(3));
        //c.sieveOfEratosthenes(10);
    }
}
