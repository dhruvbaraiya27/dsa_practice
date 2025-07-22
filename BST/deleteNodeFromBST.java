/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private TreeNode findMin(TreeNode root)
    {
        TreeNode curr = root;
        while(curr.left!=null) curr= curr.left;

        return curr;
    }
    private TreeNode findMax(TreeNode root)
    {
        TreeNode curr = root;
        while(curr.right!=null) curr= curr.right;

        return curr;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)  return null;
        if(key < root.val)
        {
            root.left = deleteNode(root.left, key);
        }
        else if(key > root.val)
        {
            root.right = deleteNode(root.right, key);
        }
        else
        {
            if(root.left==null && root.right == null)   return null;
            else if(root.right == null) return root.left;
            else if(root.left==null)    return root.right;
            else
            {
                // TreeNode minNode = findMin(root.right);
                // root.val = minNode.val;
                // root.right = deleteNode(root.right, minNode.val);
                TreeNode maxNode = findMax(root.left);
                root.val = maxNode.val;
                root.left = deleteNode(root.left, maxNode.val);
            }
        }

        return root;
    }
}
