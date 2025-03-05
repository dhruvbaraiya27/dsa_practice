public class Solution {

	public static Node<Integer> sortedDll(Node<Integer> head, int k) {
		// Write your code here.
		if(head==null || head.next==null)
		{
			return head;
		}

		PriorityQueue<Node<Integer>> minHead = new PriorityQueue<>((a,b)->a.data - b.data);

		Node<Integer> curr = head;
		for(int i=0;i<=k;i++)
		{
			minHead.add(curr);
			curr=curr.next;
		}

		Node<Integer> newHead = null;
		Node<Integer> last=null;

		while(!minHead.isEmpty())
		{
			Node<Integer> smallest = minHead.poll();
			if(newHead == null)
			{
				newHead = smallest;
				last=smallest;
			}
			else{
				last.next=smallest;
				smallest.prev=last;
				last=smallest;
			}
			if(curr!=null)
			{
				minHead.add(curr);
				curr=curr.next;
			}
			

			
		}
		last.next = null;
		return newHead;


	}

}
