class GfG {
    private void insertEleSorted(Stack<Integer> s, int num)
    {
        if(s.isEmpty() || (!s.isEmpty() && s.peek() < num))
        {
            s.push(num);
            return;
        }
        int x = s.pop();
        insertEleSorted(s,num);
        s.push(x);
    }
    private void solve(Stack<Integer> s)
    {
        if(s.isEmpty()) return;
        int num = s.pop();
        solve(s);
        insertEleSorted(s,num);
    }
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        solve(s);
        return s;
    }
}
