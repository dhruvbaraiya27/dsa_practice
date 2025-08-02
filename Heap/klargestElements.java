class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        // Your code here
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0;i<k;i++)
        {
            minHeap.offer(arr[i]);
        }
        
        for(int i=k;i<arr.length;i++)
        {
            if(arr[i] > minHeap.peek())
            {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(minHeap);
        list.sort(Collections.reverseOrder());
        return list;
        
    }
}
