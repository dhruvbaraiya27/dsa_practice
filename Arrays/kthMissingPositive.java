class Solution {
    public int kthMissing(int[] arr, int k) {
        if(arr[0]>k)
        {
            return k;
        }
        int n=arr.length;
        int start=0;
        int end=n-1;
        
        while(start <= end)
        {
            int mid = start + (end-start)/2;
            int totalMissingTillEnd = arr[mid]-(mid+1);
            
            if(totalMissingTillEnd<k)
            {
                start=mid+1;
            }
            else
            {
                end=mid-1;
            }
        }
        int totalMissingTillEnd = arr[end]-(end+1);
        return arr[end] + (k - totalMissingTillEnd);
    }
}
