// User function Template for Java

/*
class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    int i;
    private Node preorderToBST(int pre[], int size, long max)
    {
        if(i >= size)    return null;
        int key = pre[i];
        if( key > max)    return null;
        Node root = new Node(pre[i++]);
        root.left = preorderToBST(pre, size, root.data);
        root.right = preorderToBST(pre, size, max);
        
        return root;
    }
    // Function that constructs BST from its preorder traversal.
    public Node Bst(int pre[], int size) {
        // code here
        i=0;
        return preorderToBST(pre, size, Long.MAX_VALUE);
        
    }
}
