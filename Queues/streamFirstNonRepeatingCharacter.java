class Solution {
    public String FirstNonRepeating(String s) {
        // code here
        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            q.offer(ch);
            
            while(!q.isEmpty())
            {
                if(map.get(q.peek()) > 1)
                {
                    q.poll();
                }
                else
                {
                    sb.append(q.peek());
                    break;
                }
            }
            if(q.isEmpty()) sb.append('#');
        }
        return sb.toString();
    }
}
