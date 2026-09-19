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
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> q = new PriorityQueue<>((a, b) -> a.end - b.end);
        int rooms = 0;
        for(int curr=0; curr<intervals.size(); curr++){
            while(!q.isEmpty() && intervals.get(curr).start >= q.peek().end){
                q.poll();
            }
            q.offer(intervals.get(curr));
            rooms = Math.max(rooms, q.size());
        }
        return rooms;
    }
}
