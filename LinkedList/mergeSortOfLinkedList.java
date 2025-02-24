class Solution {
    
    
    private static Node getMiddle(Node head)
    {
        Node slow=head;
        Node fast = head.next;
        
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    
    private static Node merge(Node left, Node right)
    {
        Node temp = new Node(-1);
        Node tail=temp;
        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        
        while(left!=null && right!=null)
        {
            if(left.data<=right.data)
            {
                tail.next = new Node(left.data);
                tail=tail.next;
                left=left.next;
            }
            else
            {
                tail.next = new Node(right.data);
                tail=tail.next;
                right=right.next;
            }
            
        }
        while(left!=null)
        {
            tail.next = new Node(left.data);
            tail=tail.next;
            left=left.next;
        }
        while(right!=null)
        {
            tail.next = new Node(right.data);
            tail=tail.next;
            right=right.next;
        }
        
        return temp.next;
    }
    // Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head) {
        // add your code here
        
    if(head==null || head.next==null)
    {
        return head;
    }
      Node middle = getMiddle(head);
      
      Node left=head;
      Node right = middle.next;
      
      middle.next =null;
      
      left = mergeSort(left);
      right = mergeSort(right);
      
      Node ans = merge(left, right);
      return ans;
    }
}
