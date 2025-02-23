class Solution {
    private static boolean canWeAllow(int[] arr, int k, int mid)
    {
        int painterCount=1;
        int totalTime=0;
        
        for(int timePerWall : arr)
        {
            if(timePerWall + totalTime > mid)
            {
                painterCount++;
                totalTime=timePerWall;
            }
            else
            {
                totalTime+=timePerWall;
            }
        }
        
        if(painterCount > k)
        {
            return false;
        }
        return true;
    }
    
    public int minTime(int[] arr, int k) {
        // code here
        int n=arr.length;
       
        int low=Integer.MIN_VALUE;
        int high=0;
        
        for(int i:arr)
        {
            low = Math.max(i,low);
            high+=i;
        }
        
        while(low<=high)
        {
            int mid = (low +high)/2;
            if(canWeAllow(arr,k,mid))
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}
