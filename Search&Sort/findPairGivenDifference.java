class Solution {
    public boolean findPair(int[] arr, int x) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        
        int i=0,j=1;
        
        while(i<n && j<n)
        {
            int diff = arr[j]-arr[i];
            
            if(diff ==x && i!=j)
            {
                return true;
            }
            else if(diff < x )
            {
                j++;
            }
            else
            {
                i++;
            }
        }
        return false;
        
    }
}
