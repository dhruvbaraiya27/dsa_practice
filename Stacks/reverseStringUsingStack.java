class Solution {
    
    public String reverse(String S){
        //code here
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray())
        {
            stack.push(c);
        }
        for(int i=0;i<S.length();i++)
        {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }

}
