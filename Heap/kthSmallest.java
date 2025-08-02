// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++)
        {
            maxHeap.offer(arr[i]);
        }
        
        for(int i=k;i<arr.length;i++)
        {
            if(arr[i] < maxHeap.peek())
            {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        return maxHeap.peek();
    }
}
