import java.util.*;

public class Solution {

	public static int getKthLargest(ArrayList<Integer> arr, int k) {
		 // code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0;i<arr.size();i++)
        {
            int sum=0;
            for(int j=i;j<arr.size();j++)
            {
                sum+=arr.get(j);
                if(minHeap.size() < k)
                {
                    minHeap.offer(sum);
                }
                else
                {
                    if(sum > minHeap.peek())
                    {
                        minHeap.poll();
                        minHeap.offer(sum);
                    }
                }
            }
            
        }
        

		// Write your code here
		return minHeap.peek();
	}
}
