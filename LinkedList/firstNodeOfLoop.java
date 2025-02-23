class Solution {
    
    private static Node detectLoop(Node head)
    {
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast)
            {
                return slow;
            }
        }
        return null;
    }
    
    public static Node findFirstNode(Node head) {
        // code here
        Node intersectNode = detectLoop(head);
        if(intersectNode==null)
        {
            return null;
        }
        
        Node slow=head;
        Node fast=intersectNode;
        
        while(slow!=fast)
        {
            slow=slow.next;
            fast=fast.next;
            
            
        }
        
        return slow;
    }
}
