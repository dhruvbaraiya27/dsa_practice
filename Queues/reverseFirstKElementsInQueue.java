class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here
        if (q == null || q.isEmpty() || k <= 0 || k > q.size()) return q;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<k;i++)
        {
            stack.push(q.poll());
        }
        
        while(!stack.isEmpty())
        {
            q.add(stack.pop());
            
        }
        
        int t = q.size() - k;
        
        while(t-- > 0)
        {
            q.add(q.poll());
        }
        return q;
}
}
