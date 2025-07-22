/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        // Code
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = root;
        
        while(curr!=null)
        {
            if(curr.left==null)
            {
                list.add(curr.data);
                curr = curr.right;
            }
            else
            {
                Node prev = curr.left;
                while(prev.right!=null && prev.right!=curr)
                {
                    prev = prev.right;
                }
                if(prev.right==null)
                {
                    prev.right = curr;
                    curr=curr.left;
                }
                else
                {
                    prev.right=null;
                    list.add(curr.data);
                    curr=curr.right;
                }
            }
        }
        return list;
    }
}
