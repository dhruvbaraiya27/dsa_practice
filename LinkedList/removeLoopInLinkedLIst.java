private static Node detectLoop(Node head)
    {
        Node slow=head;
        Node fast = head;
        
        while(fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast)
            {
                return slow;    
            }
        }
        
        return null;
    }
