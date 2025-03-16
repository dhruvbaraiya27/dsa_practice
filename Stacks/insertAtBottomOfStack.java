class Solution {
    private void solve(Stack<Integer> st, int x)
    {
        if(st.isEmpty())
        {
            st.push(x);
            return;
        }
        int num = st.pop();
        solve(st,x);
        st.push(num);
    }
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        solve(st,x);
        return st;
    }
}
