package linear.greedy;

/*
Heap-based greedy scheduling
    You are given an array of CPU tasks represented by capital letters A–Z and a non-negative cooling interval n.Each same task must be separated
    by at least n intervals.

    Find the minimum total time units to finish all tasks.

    Example:
        tasks = [A, A, A, B, B, B], n = 2
        Output = 8
 */

import java.util.HashMap;
import java.util.Map;

public class CPUTaskScheduling {

    private static int getTimeToFinish(char [] _tasks) {
        int totalTime = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : _tasks){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            } else {
                map.put(c, 1);
            }
        }

        return totalTime;
    }



    public static void main(String[] args) {
        char [] _tasks = {'A', 'A', 'A', 'B', 'B', 'B','C','C','A','A'};
        getTimeToFinish(_tasks);
    }
}
