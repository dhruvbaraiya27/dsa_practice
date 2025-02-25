class Solution {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        if(head==null || head.next==null)
        {
            return new ArrayList<>();
        }
        Node tail=head;
        while(tail.next!=null)
        {
            tail=tail.next;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        while(head!=tail && head.prev!=tail)
        {
            if(head.data + tail.data ==target)
            {
               ArrayList<Integer> pair =new ArrayList<>();
               pair.add(head.data);
               pair.add(tail.data);
               list.add(pair);
                head=head.next;
                tail=tail.prev;
            }
            else if(head.data + tail.data > target)
            {
                tail=tail.prev;
            }
            else head=head.next;
        }
        return list;
    }
}
