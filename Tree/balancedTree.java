/* A binary tree node class
class Node
{
    int data;
    Node left,right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} */

class Solution {
    private static class Pair{
        boolean isBalanced;
        int height;
        Pair(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height=height;
            
        }
    }
    private Pair isBalancedFast(Node root)
    {
        if(root==null)  return new Pair(true, 0);
        
        Pair left = isBalancedFast(root.left);
        Pair right = isBalancedFast(root.right);
        
        boolean isLeftBalanced = left.isBalanced;
        boolean isRightBlanced = right.isBalanced;
        boolean heightDiff = Math.abs(left.height - right.height) <=1;
        
        boolean isCurrBalanced = isLeftBalanced && isRightBlanced && heightDiff;
        int currHeight = Math.max(left.height, right.height) +1;
        
        return new Pair(isCurrBalanced, currHeight);
    }
    public boolean isBalanced(Node root) {
        // code here
        return isBalancedFast(root).isBalanced;
    }
}
