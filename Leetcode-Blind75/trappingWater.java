class Solution {
    public int maxWater(int arr[]) {
        
        int n = arr.length;
        int leftMax=0, rightMax=0;
        
        int trappedWater=0;
        
        int left=0,right=n-1;
        
        while(left<right)
        {
            if(arr[left]< arr[right])
            {
                if(arr[left]>=leftMax)
                    leftMax = arr[left];
                else
                    trappedWater+=leftMax-arr[left];
                
                left++;
            }
            else
            {
                if(arr[right]>=rightMax)
                    rightMax=arr[right];
                else
                    trappedWater+=rightMax-arr[right];
                
                right--;
            }
        }
        return trappedWater;
    }
}
