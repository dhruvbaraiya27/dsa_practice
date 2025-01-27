class Solution {
    // Function to check if brackets are balanced or not.
    static boolean isParenthesisBalanced(String s) {
        // code here
        if(s.length()<=1)
        {
            return false;
        }
       Stack<Character> stack = new Stack<>();
       
       for(char c: s.toCharArray())
       {
           if(c=='(' || c=='{' || c=='[')
           {
               stack.push(c);
           }
           else 
           {
               if(!stack.isEmpty())
               {
                   if(c==')' && stack.pop()!='(' || c=='}' && stack.pop()!='{' || c==']' && stack.pop()!='[')
                   {
                       return false;
                   }
               }
               else
               {
                   return false;
               }
           }
       }
       
       return stack.isEmpty();
    }
}
