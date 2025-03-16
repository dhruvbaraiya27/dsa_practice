class Sol
{
    int countRev (String s)
    {
        Stack<Character> stack = new Stack<>();
        // your code here 
        if(s.length()%2==1) return -1;
        for(char c: s.toCharArray())
        {
            if(c=='{')
            {
                stack.push(c);
            }
            else if(!stack.isEmpty() && stack.peek()=='{')
            {
                stack.pop();
            }
            else stack.push(c);
        }
        int a=0,b=0;
        while(!stack.isEmpty())
        {
            if(stack.pop()=='{') a++;
            else b++;
        }
        
        int ans = (a+1)/2 + (b+1)/2;
        return ans;
    }
}
