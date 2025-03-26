class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals==null || intervals.size()==0)
            return 0;
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Interval interval : intervals)
        {
            if(!minHeap.isEmpty() && minHeap.peek()<=interval.start)
                minHeap.poll();
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }
}
