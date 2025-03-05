class Solution {
    public Node rotateDLL(Node head, int p) {
        // code here..
        if(head==null || head.next==null || p<=0)
        {
            return head;
        }
        
        Node curr = head;
        
        while(curr.next!=null)
        {
            curr = curr.next;
        }
        curr.next=head;
        head.prev=curr;
        
        while(p>0)
        {
            head = head.next;
            p--;
        }
        while(curr.next!=head)
        {
            curr=curr.next;
        }
        curr.next=null;
        head.prev=null;
        
        return head;
    }
}
