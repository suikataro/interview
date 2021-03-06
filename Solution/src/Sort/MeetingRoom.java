package Sort;

import java.util.Arrays;
import java.util.Comparator;

//Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings. For example, Given [[0, 30],[5, 10],[15, 20]], return false.
public class MeetingRoom {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        //sort based on meeting start time
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        //i和i+1的比较，就要注意这里i < intervals.length - 1
        for(int i = 0; i < intervals.length - 1; i++){
            //因为是先按照start排序了，就只要比较前一个end是不是小于后一个start就好了
            if(intervals[i].end > intervals[i + 1].start){
                return false;
            }
        }

        return true;
    }

    /*

        public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        int end = intervals[0].end;
        //这里是i是从1开始，是比较后一个的start是不是小于前一个end
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < end) {
                return false;
            }
            //这里只是更新了end
            end = Math.max(end, intervals[i].end);
        }
        return true;
    }
     */

}
