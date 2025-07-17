/*
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    // Function to find the height of a binary tree.
    int height(Node root) {
        // code here
        if(root==null)  return -1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return Math.max(leftHeight, rightHeight)+1;
        
    }
}
