class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int n=arr.length;
        
        int low=0;
        int high=n-1;
        int count=0;
        
        while(low<high)
        {
            int sum = arr[low]+arr[high];
            
            if(sum<target)
            {
                count+=(high-low);
                low++;
            }
            else high--;
        }
        return count;
    }
}
