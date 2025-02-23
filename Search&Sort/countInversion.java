class Solution {
    
    private static int mergeSortAndCount(int arr[], int left, int right)
    {
        int count =0;
        if(left>=right)
        {
            return count;
        }
        int mid = left+(right-left)/2;
        
        count +=mergeSortAndCount(arr,left,mid);
        count +=mergeSortAndCount(arr,mid+1,right);
        
        count += mergeAndCount(arr,left,mid,right);
        
        return count;
        
    }
    
    private static int mergeAndCount(int arr[], int left, int mid, int right)
    {
        int n1 = mid-left+1;
        int n2 = right-mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        int k = left;
        for(int i=0;i<n1;i++)
        {
            leftArr[i]=arr[k++];
        }
        for(int i=0;i<n2;i++)
        {
            rightArr[i]=arr[k++];
        }
        
        int i=0,j=0;
        k=left;
        
        int count =0;
        
        while(i<n1 && j< n2)
        {
            if(leftArr[i]<=rightArr[j])
            {
                arr[k++]=leftArr[i++];
            }
            else
            {
                arr[k++]=rightArr[j++];
                count+=(n1-i);
            }
        }
        while(i<n1)
        {
            arr[k++]=leftArr[i++];
        }
         while(j<n2)
        {
            arr[k++]=rightArr[j++];
        }
        
        return count;
        
        
    }
    
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
       int n = arr.length;
       return mergeSortAndCount(arr,0,n-1);
    }
}
