class Solution {
    public static int checkRedundancy(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c=='(' || c=='+' || c=='-' || c=='*' || c=='/')
            {
                st.push(c);
            }
            else
            {
                if(c==')')
                {
                    int isRedundant=1;
                    while(st.peek()!='(')
                    {
                        char top = st.peek();
                        if(top == '+' || top=='-' || top=='/' || top == '*')
                        {
                            isRedundant=0;
                        }
                        st.pop();
                    }
                    if(isRedundant==1) return 1;
                    st.pop();
                }
            }
        }
        return 0;
    }
}
  
