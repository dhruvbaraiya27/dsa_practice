class Solution {
    
    static class NodeContainer {
        Node head;
        Node tail;
        
        NodeContainer() {
            head = null;
            tail = null;
        }
    }
    static void insertAtTail(NodeContainer container, int digit)
    {
        Node temp = new Node(digit);
        
        if(container.head == null)
        {
            container.head = temp;
            container.tail = temp;
            return;
        }
        
        container.tail.next = temp;
        container.tail=temp;
    }
    
    static Node add(Node num1, Node num2)
    {
        int carry=0;
        
        NodeContainer result = new NodeContainer();
        
        while(num1!=null && num2!=null)
        {
            int sum = carry + num1.data + num2.data;
            int digit = sum%10;
            insertAtTail(result, digit);
            
            carry = sum/10;
            
            num1 = num1.next;
            num2 = num2.next;
        }
        
        while(num1!=null)
        {
            int sum = carry + num1.data;
            int digit = sum%10;
            insertAtTail(result, digit);
            
            carry = sum/10;
            
            num1 = num1.next;
        }
        while(num2!=null)
        {
            int sum = carry + num2.data;
            int digit = sum%10;
            insertAtTail(result, digit);
            
            carry = sum/10;
            
            num2 = num2.next;
        }
        
        while(carry!=0)
        {
            int sum = carry;
            int digit = sum%10;
            insertAtTail(result, digit);
            carry = sum/10;
            
        }
        
        return result.head;
    }
    
    static Node reverse(Node head)
    {
        Node curr = head;
        Node prev = null;
        Node next1 = null;
        
        while(curr != null)
        {
            next1=curr.next;
            curr.next = prev;
            prev = curr;
            curr = next1;
        }
        
        return prev;
    }
    // Function to add two numbers represented by linked list.
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        // return head of sum list
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node ans = add(num1, num2);
        
        ans = reverse(ans);
        
        return ans;
    }
}
