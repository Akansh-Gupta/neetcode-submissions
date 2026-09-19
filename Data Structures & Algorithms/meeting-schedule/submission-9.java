/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a,b)-> a.start - b.start);
        int prev = 0;

        for(int curr=1; curr<intervals.size(); curr++){
            if(intervals.get(curr).start < intervals.get(prev).end){
                return false;
            }
            prev = curr;
        }
        return true;
    }
}
