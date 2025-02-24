class Solution {
    private static Node reverse(Node head)
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
    private static Node getMiddle(Node head)
    {
        Node slow=head;
        Node fast=head.next;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            
        }
        return slow;
    }
    // Function to check whether the list is palindrome.
    static boolean isPalindrome(Node head) {
        // Your code here
        if(head==null || head.next==null)
        {
            return true;
        }
        Node middle= getMiddle(head);
        
        Node temp = middle.next;
        middle.next = reverse(temp);
        Node head2 = middle.next;
        
       Node head1=head;
       
       while(head2!=null)
       {
           if(head1.data!=head2.data)
           return false;
           
           head1=head1.next;
           head2=head2.next;
       }
       return true;
    }
}
