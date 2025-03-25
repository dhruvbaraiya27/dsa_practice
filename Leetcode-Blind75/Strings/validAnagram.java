class Solution {
    public boolean isAnagram(String s, String t) {
     int n=s.length();
     int m = t.length();

     int[] freq = new int[26];

     if(n!=m)
        return false;
    for(char c: s.toCharArray())
        freq[c-'a']++;
    for(char c: t.toCharArray())
        freq[c-'a']--;
    for(int count: freq)
        if(count!=0) return false;
    return true;


    }
}
