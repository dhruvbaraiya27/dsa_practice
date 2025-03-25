class Solution {
    //optimal approach
    
    public String minWindow(String s, String t) {
       int m = t.length();
       int n = s.length();
       int[] tFreq = new int[128];

       for(char c: t.toCharArray())
       {
        tFreq[c]++;
       }
       int left = 0, right=0, sIndex=-1, count=0;
       int minLen = Integer.MAX_VALUE;
       while(right < n)
       {
        char c = s.charAt(right);
        if(tFreq[c] > 0)
            count++;
        tFreq[c]--;

        while(count==m)
        {
            if(right-left+1 <minLen)
            {
                minLen = right-left+1;
                sIndex=left;
            }
            char j = s.charAt(left);
            tFreq[j]++;
            if(tFreq[j]>0)
                count--;
            left++;

        }
        right++;
       }
       return sIndex==-1? "" : s.substring(sIndex, sIndex+minLen);


    }
}
