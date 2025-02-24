class Solution {
    boolean isCircular(Node head) {
        // Your code here
        if(head==null)
        {
            return false;
        }
        Node temp=head;
        
        while(temp!=null)
        {
            temp=temp.next;
            if(temp==head)
            {
                return true;
            }
        }
       return false; 
        
    }
}
