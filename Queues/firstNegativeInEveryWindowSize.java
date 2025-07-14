class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        
        for(int i=0;i<k;i++)
        {
            if(arr[i]<0)
            {
                dq.addLast(i);
            }
        }
        
        if(!dq.isEmpty())
        {
            ans.add(arr[dq.peekFirst()]);
        }
        else{
            ans.add(0);
        }
        
        for(int i=k;i<arr.length;i++)
        {
            if(!dq.isEmpty() && i-dq.peekFirst()>=k)
            {
                dq.pollFirst();
            }
            
            if(arr[i]<0)
            {
                dq.addLast(i);
            }
            
            if(!dq.isEmpty())
            {
                ans.add(arr[dq.peekFirst()]);
            }
            else
            {
                ans.add(0);
            }
        }
        return ans;
        
    }
}
