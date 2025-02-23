class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        // Add code here
        if(head==null || head.next==null)
        {
            return false;
        }
        
        Node fast=head;
        Node slow = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast)
            {
                return true;
            }
        }
        return false;
    }
}
