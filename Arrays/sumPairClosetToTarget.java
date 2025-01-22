class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n=arr.length;
        if(n<2)
        {
            return new ArrayList<>();
        }
        List<Integer> list= new ArrayList<>();
        Arrays.sort(arr);
        
        int clossetDiff = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;
        int low=0;
        int high=n-1;
        
        while(low<high)
        {
            int sum =arr[low]+arr[high];
            int diff = Math.abs(sum - target);
            
            if(diff < clossetDiff || (diff == clossetDiff && arr[high] - arr[low] > maxAbsDiff))
            {
                clossetDiff=diff;
                maxAbsDiff = arr[high]-arr[low];
                list = Arrays.asList(arr[low],arr[high]);
                
            }
            if(sum<target) low++;
            else high--;
            
            
        }
        return list;
        
    }
}
