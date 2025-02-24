class Solution {
    
    private Node reverse(Node head)
    {
        Node curr=head;
        Node prev=null;
        Node forw=null;
        
        while(curr!=null)
        {
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
    
    public Node addOne(Node head) {
        // code here.
        head = reverse(head);
        Node curr=head;
        Node prev=null;
        
        int carry=1;
        
        while(curr!=null)
        {
            int sum = curr.data+carry;
            curr.data = sum%10;
            carry=sum/10;
            prev=curr;
            curr=curr.next;
        }
        
        if(carry > 0)
        {
            prev.next = new Node(carry);
            
        }
        head = reverse(head);
        return head;
        
    }
}
