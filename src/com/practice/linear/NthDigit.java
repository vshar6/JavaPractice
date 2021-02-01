package linear;

import java.util.ArrayList;
import java.util.List;

public class NthDigit {

    List<Interval> intervals = new ArrayList<>();

    public NthDigit(int size) {

        for(int i=0;i<=size;i++) {
            Interval interval = new Interval();
            interval.setIndex(i+1);
            interval.setUpperBoundNumber(Math.pow(10,i+1)-1);
            interval.setLowerBoundNumber(Math.pow(10,i));
            interval.setUpperDigitCount(9*(i+1)*Math.pow(10,i));
            if(i==0) {
                interval.setLowerDigitCount(1);
            } else {
                interval.setLowerDigitCount(intervals.get(i-1).upperDigitCount+1);
            }
            intervals.add(interval);
        }
        System.out.println(intervals);
    }

    public int findNthDigit(int n) {

        if(n >1 && n<=9) {
            return n;
        } else {
            Interval matchingInterval = fetchMatchingInterval(n);
            System.out.println(matchingInterval);

            double lowerNumber = matchingInterval.getLowerBoundNumber();
            double remainingDigitsToCount = n - matchingInterval.getLowerDigitCount()+1;

            for(int digitCounter = 0; digitCounter < matchingInterval.getUpperDigitCount();digitCounter++) {
                lowerNumber = lowerNumber + 1;
                remainingDigitsToCount = remainingDigitsToCount - matchingInterval.getIndex();
                System.out.println("lowerNumber:" + lowerNumber);
                System.out.println("remainingDigitsToCount:" + remainingDigitsToCount);

                if(remainingDigitsToCount < matchingInterval.getIndex()) {
                    System.out.println("number:" + (lowerNumber));
                    Double x = lowerNumber / Math.pow(10,matchingInterval.getIndex()-1);
                    return x.intValue();
                }
            }

        }
        return 0;
    }

    private Interval fetchMatchingInterval(int n) {
        for(Interval interval: intervals) {
            if(interval.lowerDigitCount <=n && interval.upperDigitCount>=n) {
                return interval;
            }
        }
        return null;
    }

    public static void main(String [] args) {

        System.out.println(calculateSize(3));
        NthDigit nthDigit = new NthDigit(5);
        //System.out.println(nthDigit.findNthDigit(3));
    }

    private static double calculateSize(int n){

        int index = 1;
        while(true) {
            double number = index*9*Math.pow(10, index);
            if(number >=n) {
                return index+1;
            } else {
                index = index+1;
            }
        }
    }
}

class Interval {
    int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    double lowerBoundNumber;
    double lowerDigitCount;



    double upperDigitCount;

    @Override
    public String toString() {
        return "Interval{" +
                "index=" + index +
                ", lowerBoundNumber=" + lowerBoundNumber +
                ", lowerDigitCount=" + lowerDigitCount +
                ", upperDigitCount=" + upperDigitCount +
                ", upperBoundNumber=" + upperBoundNumber +
                '}';
    }

    double upperBoundNumber;

    public double getLowerBoundNumber() {
        return lowerBoundNumber;
    }

    public void setLowerBoundNumber(double lowerBoundNumber) {
        this.lowerBoundNumber = lowerBoundNumber;
    }

    public double getLowerDigitCount() {
        return lowerDigitCount;
    }

    public void setLowerDigitCount(double lowerDigitCount) {
        this.lowerDigitCount = lowerDigitCount;
    }

    public double getUpperDigitCount() {
        return upperDigitCount;
    }

    public void setUpperDigitCount(double upperDigitCount) {
        this.upperDigitCount = upperDigitCount;
    }



    public double getUpperBoundNumber() {
        return upperBoundNumber;
    }

    public void setUpperBoundNumber(double upperBoundNumber) {
        this.upperBoundNumber = upperBoundNumber;
    }

    public Interval(double lowerBound, double upperBoundNumber,double lowerDigitCount,double upperDigitCount) {
        this.lowerBoundNumber =lowerBound;
        this.upperBoundNumber = upperBoundNumber;
        this.lowerDigitCount = lowerDigitCount;
        this.upperDigitCount = upperDigitCount;
    }

    public Interval() {

    }
}
