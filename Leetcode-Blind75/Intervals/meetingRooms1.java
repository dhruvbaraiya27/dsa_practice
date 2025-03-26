class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
    if (intervals == null || intervals.size() <= 1) return true;
       Collections.sort(intervals, (a,b) -> Integer.compare(a.end, b.end));
       int lastEnd = intervals.get(0).end;

       for(int i=1;i<intervals.size();i++)
       {
        if(intervals.get(i).start < lastEnd)
            return false;
        lastEnd = intervals.get(i).end;
       } 
       return true;
    }
}
