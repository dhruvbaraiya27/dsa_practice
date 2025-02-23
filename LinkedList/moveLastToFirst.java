class Solution {
    public static Node moveToFront(Node head) {
        
        if(head==null || head.next==null)
        {
            return head;
        }
       Node prev=null;
       Node curr=head;
       
       while(curr.next!=null)
       {
           prev=curr;
           curr=curr.next;
       }
       curr.next=head;
       prev.next=null;
       head =curr;
       return head;
    }
}
