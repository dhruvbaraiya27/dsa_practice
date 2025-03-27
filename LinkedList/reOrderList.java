/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverse(ListNode head)
    {
        ListNode prev=null;
        ListNode forw=head;

        while(head!=null)
        {
            forw = head.next;
            head.next=prev;
            prev=head;
            head=forw;

        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second = reverse(slow.next);
        slow.next=null;

        ListNode first = head;
        while(second!=null)
        {
            ListNode temp1 = first.next;
            ListNode temp2= second.next;

            first.next = second;
            second.next=temp1;
            first=temp1;
            second = temp2;
        }  
    }
}
