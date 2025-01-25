class Solution {
    private static void expandAroundCenter(String s, int left, int right, String[] res, int[] resLen)
    {
        int n=s.length();
        while(left>=0 && right<n && s.charAt(left)==s.charAt(right))
        {
            if(right-left+1 > resLen[0])
            {
                res[0] = s.substring(left,right+1);
                resLen[0]=right-left+1;
            }
            left--;
            right++;
        }
    }
    // Static method to find the longest palindromic substring
    static String longestPalindrome(String s) {
        // code here
        //o(n^2) tc 
        if (s.length() < 1) return "";
        
        String[] res=new String[1];
        res[0]="";
        int[] resLen = new int[1];
        resLen[0]=0;
        for(int i=0;i<s.length();i++)
        {
            //for odd length
            expandAroundCenter(s,i,i,res,resLen);
            //for even length
            expandAroundCenter(s,i,i+1,res,resLen);
        }
        return res[0];
    }
}
