/*
class Node
{
    int data;
    Node right, left;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/

class Solution {
    ArrayList<Integer> list;
    private void inorder(Node root)
    {
        if(root == null)    return;
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
    private Node inorderToBST(int start, int end)
    {
        if(start > end) return null;
        
        int mid = (start + end)/2;
        
        Node root = new Node(list.get(mid));
        root.left = inorderToBST(start, mid-1);
        root.right = inorderToBST(mid+1, end);
        
        return root;
    }
    Node balanceBST(Node root) {
        // Add your code here.
        list = new ArrayList<>();
        inorder(root);
        Node newRoot = inorderToBST(0, list.size()-1);
        return newRoot;
        
    }
}
