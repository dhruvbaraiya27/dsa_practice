/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // code here
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
                if(i==0)   list.add(temp.data);
                
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null)    q.add(temp.right);
            }
        }
        return list;
    }
}
