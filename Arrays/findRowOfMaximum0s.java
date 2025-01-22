class Solution {
    private int lastOccurOfZero(int arr[][], int row)
    {
        int low =0;
        int high = arr[0].length-1;
        
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(arr[row][mid]==0)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return high;
    }
    
    public int rowWithMax1s(int arr[][]) {
        // code here
        int rows = arr.length;
        int cols = arr[0].length;
        int bestIndex=cols;
        int row=0;
        for(int i=0;i<rows;i++)
        {
            int j = lastOccurOfZero(arr,i);
            
            if(j==-1)
            {
                return i;
            }
            
            if(j<bestIndex)
            {
                bestIndex=j;
                row = i;
            }
        }
        return row;
    }
}
