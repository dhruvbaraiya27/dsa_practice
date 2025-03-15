class Solution {
    private void solve(Stack<Integer> s, int count, int size)
    {
        if(count==size/2)
        {
            s.pop();
            return;
        }
        int num = s.peek();
        s.pop();
        
        solve(s,count+1,size);
        s.push(num);
    }
    // Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer> s) {
        // code here
        int count=0;
        int size = s.size();
        solve(s,count,size);
    }
}
