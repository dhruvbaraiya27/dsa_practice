class Solution {
    long countTriplets(int n, int sum, long arr[]) {
        
        Arrays.sort(arr);
        long ans=0;
        
        for(int i=0;i<n-2;i++)
        {
            if(i>0 && arr[i]==arr[i-1]) continue;
            int left=i+1;
            int right=n-1;
            
            while(left < right)
            {
                long countSum = arr[i]+arr[left]+arr[right];
                
                if(countSum<sum)
                {
                    ans+= (right-left);
                    left++;
                }
                else right--;
            }
        }
        return ans;
    }
}
