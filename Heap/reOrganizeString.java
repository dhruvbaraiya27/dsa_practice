class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray())
        {
            freq[c-'a']++;
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> freq[b - 'a'] - freq[a - 'a']);
        for(char c='a';c<='z';c++)
        {
            if(freq[c - 'a'] >0)    maxHeap.offer(c);
        }
        
        Queue<Character> waitQueue = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        
        while(!maxHeap.isEmpty())
        {
            Character current = maxHeap.poll();
            result.append(current);
            freq[current - 'a']--;
            
            waitQueue.offer(current);
            if(waitQueue.size() >=2)
            {
                char front = waitQueue.poll();
                if(freq[front - 'a'] >0)    maxHeap.offer(front);
            }
        }
        
        return result.length() == s.length() ? result.toString() :"";
    }
}
