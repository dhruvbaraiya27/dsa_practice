class Solution {
    public static Node findIntersection(Node head1, Node head2) {
        // code here.
        Node newNode = new Node(-1);
        Node tail= newNode;
        
        Node curr1=head1;
        Node curr2 = head2;
        
        while(curr1!=null && curr2!=null)
        {
            if(curr1.data == curr2.data)
            {
                tail.next = new Node(curr1.data);
                tail=tail.next;
                curr1=curr1.next;
                curr2=curr2.next;
            }
            else if(curr1.data < curr2.data)
            {
                curr1=curr1.next;
            }
            else
            {
                curr2=curr2.next;
            }
        }
        return newNode.next;
    }
}
