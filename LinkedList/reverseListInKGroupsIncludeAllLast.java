class Solution {
    public static Node reverseKGroup(Node head, int k) {
        // code here
        if(head==null || k<=1)
        {
            return head;
        }
        int count=0;
        Node prev=null;
        Node forward = null;
        Node curr=head;
        
        while(curr!=null && count<k)
        {
            forward = curr.next;
            curr.next=prev;
            prev=curr;
            curr=forward;
            count++;
        }
        
        if(forward!=null)
        {
            head.next = reverseKGroup(forward,k);
        }
        
        return prev;
    }
}
