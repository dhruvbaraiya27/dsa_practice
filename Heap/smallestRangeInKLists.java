class Solution {
    private class Element{
        int value;
        int row;
        int col;
        Element(int value, int row, int col){
            this.value = value;
            this.row = row;
            this.col=col;
        }
    }
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        // code here
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int n=arr.length;
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
     
        for(int i=0;i<n;i++)
        {
            minHeap.offer(new Element(arr[i][0], i, 0));
            mini=Math.min(mini,arr[i][0]);
            maxi = Math.max(maxi,arr[i][0]);
        }
        int start=mini;
        int end=maxi;
        
        while(!minHeap.isEmpty())
        {
            Element current = minHeap.poll();
            mini = current.value;
            if(maxi - mini < end - start)
            {
                end = maxi;
                start = mini;
            }
            int nextCol = current.col +1;
            if(nextCol < arr[current.row].length)
            {
                int nextVal = arr[current.row][nextCol];
                minHeap.offer(new Element(nextVal, current.row,nextCol));
                maxi = Math.max(maxi, nextVal);
            }
            else break;
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(start);
        result.add(end);
        return result;
        
    }
}
