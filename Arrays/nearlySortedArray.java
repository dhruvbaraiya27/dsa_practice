class Solution {
    public void nearlySorted(int[] arr, int k) {
        // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = arr.length;
        int j=0;
        while(j<n && j<=k)
        {
            minHeap.add(arr[j++]);
        }
        int i=0;
        while(i<n)
        {
            arr[i] = minHeap.poll();
            if(j<n)
            {
                minHeap.add(arr[j++]);
            }
            i++;
            
            
        }
    }
}
