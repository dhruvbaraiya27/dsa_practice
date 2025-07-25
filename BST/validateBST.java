class Solution {
    
    boolean isValid(Node curr, long min, long max)
    {
        if(curr == null)    return true;
        if(curr.data <= min || curr.data >=max)   return false;
        return isValid(curr.left, min, curr.data) && isValid(curr.right, curr.data, max);
    }
    
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
        
        
    }
}
