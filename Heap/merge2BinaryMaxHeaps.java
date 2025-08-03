// User function Template for Java

class Solution {
    private void heapify(int[] arr, int i, int n)
    {
        
        int l = 2*i + 1;
        int r = 2*i + 2;
        int largest = i;
        
        if(l<n && arr[l] > arr[largest])    largest = l;
        if(r<n && arr[r] > arr[largest])    largest = r;
        
        if(largest!=i)
        {
            int temp = arr[largest];
            arr[largest]=arr[i];
            arr[i] = temp;
            heapify(arr, largest, n);
        }
    }
    private void buildHeap(int[] arr, int n)
    {
        int startIndex = n/2 - 1;
        for(int i=startIndex;i>=0;i--)
        {
            heapify(arr, i, n);
        }
    }
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        int[] ans = new int[n+m];
        for(int i=0;i<n;i++)
        {
            ans[i]=a[i];
        }
        for(int i=0;i<m;i++)
        {
            ans[i+n] = b[i];
        }
        
        buildHeap(ans, n+m);
        return ans;
        
        
    }
}
