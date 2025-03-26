class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for(ListNode node: lists)
        {
            if(node!=null)
            pq.offer(node);
        }
        ListNode newNode = new ListNode(-1);
        ListNode curr=newNode;

        while(!pq.isEmpty())
        {
            ListNode node1 = pq.poll();
            curr.next = node1;
            curr=curr.next;

            if(node1.next!=null)
            {
                pq.offer(node1.next);
            }
        }
        return newNode.next;
    }
}
