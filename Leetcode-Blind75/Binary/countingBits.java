class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0]=0;
        for(int i=1;i<n+1;i++)
        {
            ans[i]=ans[i>>1] + (i&1);
            //i>>1 means i=i/2 and
            //i&1 means i%2==1(odd)
        }
        return ans;
    }
}
