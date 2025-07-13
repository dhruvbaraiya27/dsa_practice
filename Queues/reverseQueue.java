class Solution {
    // Function to reverse the queue.
    public Queue<Integer> reverseQueue(Queue<Integer> queue) {
        // code here.
        if(queue.isEmpty()) return queue;
        int ele = queue.poll();
        reverseQueue(queue);
        queue.add(ele);
        
        return queue;
    }
}
