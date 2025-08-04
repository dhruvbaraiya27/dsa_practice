class Solution {
    
    private int signum(int a, int b)
    {
        if(a==b)    return 0;
        return a>b ? 1 : -1;
    }

    private void callMedian(int element, PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, double[] median)
    {
        switch (signum(maxHeap.size(), minHeap.size())){
            case 0:
                if(element > median[0])
                {
                    minHeap.offer(element);
                    median[0] = (double) minHeap.peek();
                }
                else{
                    maxHeap.offer(element);
                    median[0] = (double) maxHeap.peek();
                }
                break;
            case 1:
                if(element > median[0]){
                    minHeap.offer(element);
                    median[0] = (double) (maxHeap.peek() + minHeap.peek())/2;
                }
                else{
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(element);
                    median[0] = (double) (maxHeap.peek() + minHeap.peek())/2;
                }
                break;
            case -1:
                if(element > median[0]){
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(element);
                    median[0] = (double) (maxHeap.peek() + minHeap.peek())/2;
                }
                else{
                    maxHeap.offer(element);
                    median[0] = (double) (maxHeap.peek() + minHeap.peek())/2;
                }
                break;
        }
    }

    public ArrayList<Double> getMedian(int[] arr) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        double[] median = {0};
        
        ArrayList<Double> result = new ArrayList<>();
        
        for(int i=0;i<arr.length;i++)
        {
            callMedian(arr[i], maxHeap, minHeap, median);
            result.add(median[0]);
        }
        
        return result;
    }
}
