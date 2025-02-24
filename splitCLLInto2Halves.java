class Solution {
    public Pair<Node, Node> splitList(Node head) {
        // Code here
        Node slow=head;
        Node fast=head.next;
        
        while(fast!=head && fast.next!=head)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        Node head2 = slow.next;
        Node temp=head2;
        slow.next=head;
        
        while(temp.next!=head)
        {
            temp=temp.next;
        }
        temp.next=head2;
        
        return new Pair(head,head2);
        
    }
}
