class Solution {

    private ListNode reverse(ListNode head)
    {
        ListNode curr= head;
        ListNode prev = null;
        ListNode forw = null;

        while(curr!=null)
        {
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

     ListNode curr= head;
     ListNode prev = null;
     ListNode forw = null;
     int count =0;

     while(curr!=null && count < k)
     {
        forw = curr.next;
        curr.next = prev;
        prev=curr;
        curr=forw;
        count++;
     }  
     if(forw!=null)
     {
        head.next = reverseKGroup(forw,k);
     }
     if(count<k)
     {
        return reverse(prev);
     }

     return prev;
        
    }
}
