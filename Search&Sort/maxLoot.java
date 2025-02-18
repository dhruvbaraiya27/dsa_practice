class Solution {
    // Function to find the maximum money the thief can get.
    public int findMaxSum(int arr[]) {
        // Your code here
        int n=arr.length;
        int prev1=arr[0];
        int prev2 = Math.max(arr[0],arr[1]);
        int max=0;
        for(int i=2;i<n;i++)
        {
            int sum = prev1+arr[i];
            max = Math.max(sum,prev2);
            
            prev1=prev2;
            prev2=max;
        }
        
        if(max==0)
        {
            return Math.max(prev1, prev2);
        }
        
        return max;
    }
}
