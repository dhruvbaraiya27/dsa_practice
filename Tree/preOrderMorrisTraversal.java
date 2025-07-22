class Solution {
    // Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        Node curr=root;
        
        while(curr != null)
        {
            if(curr.left==null)
            {
                list.add(curr.data);
                curr=curr.right;
            }
            else
            {
                Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                
                if(prev.right ==null)
                {
                    list.add(curr.data);
                    prev.right = curr;
                    curr = curr.left;
                }
                else
                {
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return list;
        
    }
}
