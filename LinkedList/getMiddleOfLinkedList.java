class Solution {
    public ListNode middleNode(ListNode head) {
      ListNode slow =head;
      //if you want 2nd middle element in even then use this fast=head
      //but if you want 1st middle element in even then use this fast=head.next
      ListNode fast = head;

      while(fast!=null && fast.next != null)
      {
        slow=slow.next;
        fast = fast.next.next;
      }  
      return slow;
    }
}
