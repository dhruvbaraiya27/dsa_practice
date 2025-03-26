class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1)
            return intervals;
        
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> merged = new ArrayList<>();
        for(int[] interval : intervals)
        {
            if(merged.isEmpty() || interval[0] > merged.get(merged.size()-1)[1])
                merged.add(interval);
            else
                merged.get(merged.size()-1)[1] = Math.max(interval[1], merged.get(merged.size()-1)[1]);
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
