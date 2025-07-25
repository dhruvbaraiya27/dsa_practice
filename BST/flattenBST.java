// User function Template for Java
class Solution {
    ArrayList<Integer> list;
    private void inorder(Node root)
    {
        if(root==null)  return;
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
    public Node flattenBST(Node root) {
        // Code here
        list = new ArrayList<>();
        inorder(root);
        int n = list.size();
        
        Node newRoot = new Node(list.get(0));
        Node curr = newRoot;
        for(int i=1;i<n;i++)
        {
            Node temp = new Node(list.get(i));
            curr.left = null;
            curr.right = temp;
            curr = curr.right;
            
        }
        curr.left = null;
        curr.right=null;
        
        return newRoot;
        
        
    }
}
