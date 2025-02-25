class Solution {
    public DLLNode reverseDLL(DLLNode head) {
        // Your code here
        DLLNode curr=head;
        DLLNode forw=null;
        DLLNode prev1=null;
        
        while(curr!=null)
        {
            forw=curr.next;
            curr.prev = curr.next;
            curr.next = prev1;
            prev1=curr;
            curr=forw;
        }
        return prev1;
    }
}
