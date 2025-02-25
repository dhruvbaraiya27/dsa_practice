public class Solution {
	public static int countAllTripletSum(Node head, int x) {
		if(head==null || head.next==null || head.next.next ==null)
        {
            return 0;
        }

        Node tail=head;
        while(tail.next!=null)
        {
            tail=tail.next;
        }
        int count=0;
        while(head!=null)
        {
            Node left = head.next;
            Node right = tail;

            while(left!=right && right.next!=left && left!=null && right!=null)
            {
                int sum = head.data + left.data + right.data;
                if(sum==x)
                {
                    count++;
                    left=left.next;
                    right = right.prev;
                }
                else if(sum>x)
                {
                    right=right.prev;
                }
                else left=left.next;
            }
            head=head.next;
        }
        return count;
	}
}
