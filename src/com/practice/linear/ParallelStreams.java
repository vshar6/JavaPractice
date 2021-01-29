package linear;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {


    public static long iterativeSum(long n) {
        long result = 0;
        for (long i = 1L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i->i+1).limit(n).reduce(0L, Long::sum);
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i->i+1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long longStreamSum(long n) {
        return LongStream.rangeClosed(1,n).reduce(0L, Long::sum);
                //LongStream.iterate(1L, i->i+1).limit(n).parallel().reduce(0L, Long::sum);
    }

    public static long measurePerformance(Function<Long, Long> adder, Long n) {

        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
            //System.out.println("Result: " + sum);
            if (duration < fastest) fastest = duration;
        }

        return fastest;
    }

    public static void main(String [] args) {
        System.out.println("availableProcessors:"+Runtime.getRuntime().availableProcessors());

        System.out.println("Sequential Processing:"+measurePerformance(ParallelStreams::sequentialSum,1000000L)+" msecs");
        System.out.println("Iterative Processing:"+measurePerformance(ParallelStreams::iterativeSum,1000000L)+" msecs");
        System.out.println("Parallel Processing:"+measurePerformance(ParallelStreams::parallelSum,1000000L)+" msecs");
        System.out.println("Longstream Processing:"+measurePerformance(ParallelStreams::longStreamSum,1000000L)+" msecs");
    }


}
