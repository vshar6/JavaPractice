package linear.greedy;

/*
Problem statement
    You are given an array of meetings where each meeting is represented as: [startTime, endTime]
    Return the maximum number of meetings that can be attended such that no two meetings overlap.

Example:
    Input: [[1, 3], [2, 4], [3, 5], [0, 6], [5, 7], [8, 9]]
    Output: 4
        One optimal selection: [1,3], [3,5], [5,7], [8,9]
 */

import java.util.*;

public class MaxMeetingsWithNoOverlap {

    public static int maxMeetings(int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] m : meetings) {
            if (m[0] >= lastEnd) {
                count++;
                lastEnd = m[1];
            }
        }
        return count;
    }

    public static int getNonOverlappingMeets(List<Meeting> meetings) {
        //Meetings need to be sorted by their end time, reason being - the earliest ending meetings would accommodate more meetings for the day
        meetings.sort(Comparator.comparing(meeting->meeting.end));
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;
        for(Meeting meeting:meetings){
            //the invariant
            if(meeting.start >= lastEnd){
                count++;
                lastEnd = meeting.end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int [][] _meetings = {{1, 3}, {2, 4},{3,5},{0,6},{5,7},{8,9}};
        getNonOverlappingMeets(getMeetings(_meetings));
    }

    private static List<Meeting> getMeetings(int[][] _meetings) {
        List<Meeting> meetings = new ArrayList<>();
        for(int [] _meeting:_meetings){
            meetings.add(new Meeting(_meeting[0],_meeting[1]));
        } return meetings;
    }
}


class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start; this.end = end;
    }
    @Override
    public String toString() {
        return "["+start+","+end+"]";
    }
}


