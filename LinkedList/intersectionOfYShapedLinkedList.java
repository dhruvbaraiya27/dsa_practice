class Intersect {
    // Function to find intersection point in Y shaped Linked Lists.
    static Node intersectPoint(Node head1, Node head2) {
        // code here
        
        if(head1==null || head2==null)
        {
            return null;
        }
        
        Node temp1=head1;
        Node temp2= head2;
        
        while(temp1 != temp2)
        {
            temp1=temp1.next;
            temp2=temp2.next;
            if(temp1 == temp2)
            {
                return temp1;
            }
            
            if(temp1 == null)
            {
                temp1=head2;
            }
            
            if(temp2==null)
            {
                temp2=head1;
            }
            
        }
        return null;
    }
}
