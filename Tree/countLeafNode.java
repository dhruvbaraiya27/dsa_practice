public class Solution {

  private static int inOrder(BinaryTreeNode<Integer> root)
  {
    if(root==null)
    {
      return 0;
    }
    if(root.left==null && root.right==null)
    {
      return 1;
    }
    

    int count = inOrder(root.left) + inOrder(root.right);
    return count;
  }

	public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
    // Write your code here.

    return inOrder(root);
    
	}
}
