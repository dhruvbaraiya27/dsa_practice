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
}
*/
class Solution {
    private static class Pair{
        boolean isSumTree;
        int sum;
        
        Pair(boolean isSumTree, int sum)
        {
            this.isSumTree = isSumTree;
            this.sum=sum;
        }
    }
    private Pair isSumTreeFast(Node root)
    {
        if(root==null)  return new Pair(true, 0);
        if(root.left==null && root.right==null) return new Pair(true,root.data);
        
        Pair left = isSumTreeFast(root.left);
        Pair right = isSumTreeFast(root.right);
        
        boolean leftTrue = left.isSumTree;
        boolean rightTrue = right.isSumTree;
        
        boolean cond = root.data == left.sum + right.sum;
        
        boolean isSumAvl = leftTrue && rightTrue && cond;
        int totalSum = root.data + left.sum + right.sum;
        
        return new Pair(isSumAvl, totalSum);
    }
    boolean isSumTree(Node root) {
        // Your code here
        return isSumTreeFast(root).isSumTree;
    }
}
