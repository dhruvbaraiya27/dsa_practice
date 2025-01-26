class Solution {
    private void swap(char[] chars,int i, int j)
    {
        char temp = chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
    private void solve(char[] chars, ArrayList<String> res, int index)
    {
        HashSet<Character> seen = new HashSet<>();
        if(index>=chars.length)
        {
            res.add(new String(chars));
            return;
        }
        
        for(int i=index;i<chars.length;i++)
        {
            if(seen.contains(chars[i]))
            {
                continue;
            }
            seen.add(chars[i]);
            swap(chars,i,index);
            solve(chars,res,index+1);
            swap(chars,i,index);
            
        }
    }
    public ArrayList<String> findPermutation(String s) {
        // Code here
        char[] chars= s.toCharArray();
        ArrayList<String> res = new ArrayList<>();
        int index=0;
        solve(chars,res,index);
        Collections.sort(res);
        
        return res;
    }
}
