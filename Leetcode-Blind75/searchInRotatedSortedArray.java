class Solution {
    private int getPivot(int[] nums, int low, int high)
    {
        while(low<high)
        {
            int mid = low+(high-low)/2;
            if(nums[mid]>=nums[0])
                low=mid+1;
            else
                high=mid;

        }
        return low;
    }
    private int binarySearch(int[] nums, int low, int high, int target)
    {
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        int n=nums.length;
        int pivot = getPivot(nums,0,n-1);
        if(target>=nums[pivot] && target<=nums[n-1])
            return binarySearch(nums,pivot,n-1, target);
        else
            return binarySearch(nums,0,pivot-1,target);
    }

}
