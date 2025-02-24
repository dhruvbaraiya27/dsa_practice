class Solution {
    // Function to reverse a circular linked list
    Node reverse(Node head) {
        // code here
        Node curr=head;
        Node prev=null;
        Node forw=null;
        
        do{
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        while(curr!=head);
        curr.next = prev;
        return prev;
    }

    // Function to delete a node from the circular linked list
    Node deleteNode(Node head, int key) {
        // code here
        Node curr=head;
        Node prev=null;
        
        do{
            if(curr.data ==key)
            {
                if(prev!=null)
                {
                    prev.next=curr.next;
                }
                else
                {
                    Node tail = head;
                    while(tail.next!=head)
                    {
                        tail=tail.next;
                    }
                    head=head.next;
                    tail.next=head;
                    
                }
                return head;
            }
            prev=curr;
            curr=curr.next;
        }
        while(curr!=head);
        return head;
        
    }
