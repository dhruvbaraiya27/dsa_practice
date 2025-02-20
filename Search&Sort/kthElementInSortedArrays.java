class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int left=a.length-1;
        int right=0;
        
        while(left>=0 && right<b.length)
        {
            if(a[left]>=b[right])
            {
                int temp = a[left];
                a[left]=b[right];
                b[right]=temp;
                
                left--;
                right++;
            }
            else break;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
        if(k<=a.length)
        {
            return a[k-1];
        }
        else
        {
            return b[k-1-a.length];
        }
    }
}
