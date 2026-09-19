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
        // Map<Integer, Integer> m = new HashMap<>();
        int rooms = 0;
        // q.offer(intervals.get(0));
        // m.put(intervals.get(0).start, intervals.get(0).end);
        for(int curr=0; curr<intervals.size(); curr++){
            // while(intervals.get(curr).start >= intervals.get(curr-1).end && q.size() != 0){
            //     q.poll();
            // }
            while(!q.isEmpty() && intervals.get(curr).start >= q.peek().end){
                q.poll();
            }
            // if(m.contains)
            q.offer(intervals.get(curr));
            rooms = Math.max(rooms, q.size());
        }
        return rooms;
    }
}
