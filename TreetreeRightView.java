/*Complete The Function Provided
Given Below is The Node Of Tree
class Node
{
    int data;
    Node left, right;
    public Node(int data)
    {
        this.data = data;
         left = right = null;
    }
}*/

class Solution {
    // Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node root) {
        // add code here.
        if(root==null)  return new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        
        ArrayList<Integer> list = new ArrayList<>();
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            
            for(int i=0;i<size; i++)
            {
                Node temp = q.poll();
                if(i==size-1)   list.add(temp.data);
                
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null)    q.add(temp.right);
            }
        }
        return list;
    }
}
