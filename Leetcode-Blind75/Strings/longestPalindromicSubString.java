class Solution {
    private void expandArroundCenter(String s, int left, int right, int[] resLen, String[] res)
    {
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            if(right-left+1 > resLen[0])
            {
                resLen[0]=right-left+1;
                res[0] = s.substring(left,right+1);
            }
            left--;
            right++;
        }
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n<1)
            return "";
        String[] res = new String[1];
        res[0]="";
        int[] resLen =new int[1];
        resLen[0]=0;

        for(int i=0;i<n;i++)
        {
            expandArroundCenter(s,i,i,resLen,res);
            expandArroundCenter(s,i,i+1,resLen, res);

        }
        return res[0];
    }
}
