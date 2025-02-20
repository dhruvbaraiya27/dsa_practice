class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        // code here
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int n=arr.length;
        for(int i=0;i<n-3;i++)
        {
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n-2;j++)
            {
                if(j > i+1 && arr[j]==arr[j-1]) continue;
                int l=j+1;
                int r=n-1;
                
                while(l<r)
                {
                    long sum = arr[i]+arr[j]+arr[l]+arr[r];
                    
                    if(sum==target)
                    {
                        list.add(new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[l],arr[r])));
                        while(l<r && arr[l]==arr[l+1]) l++;
                        while(l<r && arr[r]==arr[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(sum<target) l++;
                    else r--;
                    
                }
                
            }
        }
        return list;
    }
}
