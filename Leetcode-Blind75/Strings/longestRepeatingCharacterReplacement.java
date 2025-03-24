class Solution {
    public int characterReplacement(String s, int k) {
        //optimal approach 
        int start=0;
        int maxLen=0, maxFreq=0;
        int[] freq = new int[26];

        for(int end=0;end<s.length();end++)
        {
            char c= s.charAt(end);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);

            if((end-start+1) - maxFreq > k)
            {
                freq[s.charAt(start)-'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}
