class Solution {
    Node reverseList(Node head) {
        // code here
        Node prev =null;
        Node curr = head;
        Node forward = null;
        
        while(curr!=null)
        {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        
        return prev;
        
    }
}
