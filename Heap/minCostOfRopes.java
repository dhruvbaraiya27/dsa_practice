class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int num: arr)
        {
            minHeap.offer(num);
        }
        
        int totalCost=0;
        while(minHeap.size() > 1)
        {
            int a = minHeap.poll();
            int b = minHeap.poll();
            
            int currCost=a+b;
            totalCost += currCost;
            
            minHeap.offer(currCost);
        }
        
        return totalCost;
    }
}
