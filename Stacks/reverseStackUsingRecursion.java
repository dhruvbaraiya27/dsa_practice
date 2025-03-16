class Solution
{ 
    private static void insertAtBottom(Stack<Integer> s, int num)
    {
        if(s.isEmpty())
        {
            s.push(num);
            return;
        }
        int x=s.pop();
        insertAtBottom(s,num);
        s.push(x);
    }
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if(s.isEmpty())
        {
            return;
        }
        int num = s.pop();
        reverse(s);
        
        insertAtBottom(s, num);
        
    }
}
