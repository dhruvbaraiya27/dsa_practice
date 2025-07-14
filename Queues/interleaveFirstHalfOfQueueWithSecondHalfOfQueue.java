class Solution {
    public Queue<Integer> rearrangeQueue(Queue<Integer> q) {
        // code here
        Queue<Integer> firstHalf = new LinkedList<>();
        int half = q.size()/2;
        
        for(int i=0;i<half;i++)
        {
            firstHalf.offer(q.poll());
        }
        
        while(!firstHalf.isEmpty())
        {
            q.offer(firstHalf.poll());
            q.offer(q.poll());
        }
        return q;
    }
}
