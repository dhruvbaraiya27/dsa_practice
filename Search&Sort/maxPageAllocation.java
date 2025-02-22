class Solution {
    private static boolean canWeAllocate(int[] arr, int k, int mid )
    {
        int studentCount=1;
        int pageSum=0;
        
        for(int pages: arr)
        {
            if(pageSum+pages > mid)
            {
                studentCount++;
                pageSum=pages;
            }
            else
            {
                pageSum+=pages;
            }
        }
        
        if(studentCount > k )
        {
            return false;
        }
        return true;
    }
    
    public static int findPages(int[] arr, int k) {
        int n=arr.length;
        if(k>n)
        {
            return -1;
        }
        
        int low = Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>=low)
            {
                low=arr[i];
            }
            high+=arr[i];
            
        }

        while(low <= high)
        {
            int mid = (low+high)/2;
            if(canWeAllocate(arr,k,mid))
            {

                high=mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return low;
    }
}
