class Solution {
    private static boolean canWePlaceCow(int[] stalls,int distance, int k)
    {
        int n=stalls.length;
        int count=1;
        int lastCow= stalls[0];
        
        for(int i=1;i<n;i++)
        {
            if(stalls[i]-lastCow >=distance)
            {
                count++;
                lastCow=stalls[i];
            }
        }
        if(count>=k)
        {
            return true;
        }
        return false;
        
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n=stalls.length;
        int left=1;
        int right= stalls[n-1]-stalls[0];
        
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(canWePlaceCow(stalls,mid,k))
            {
                left=mid+1;
            }
            else
            {
                right=mid-1;
            }
        }
        return right;
    }
}
