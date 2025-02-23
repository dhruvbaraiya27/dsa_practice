class Solution {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        // Your code here
        if(head ==null || head.next==null)
        {
            return head;
        }
        Node curr=head;
        
        while(curr!=null && curr.next!=null)
        {
            if(curr.data == curr.next.data)
            {
                curr.next = curr.next.next;
            }
            else
            {
                curr=curr.next;
            }
        }
        return head;
    }
}
