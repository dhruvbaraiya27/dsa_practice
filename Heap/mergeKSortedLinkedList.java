/*class Node
{
    int data;
    Node next;

    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// arr is an array of Nodes of the heads of linked lists

class Solution {
    // Function to merge K sorted linked list.
    Node mergeKLists(List<Node> arr) {
        // Add your code here.
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.data));
        
        for(Node node: arr)
        {
            if(node!=null)  minHeap.offer(node);
        }
        
        Node dummy = new Node(-1);
        Node tail = dummy;
        
        while(!minHeap.isEmpty())
        {
            Node curr = minHeap.poll();
            tail.next = curr;
            tail = tail.next;
            if(curr.next!=null)
            {
                minHeap.offer(curr.next);
            }
        }
        return dummy.next;
    }
    
}
