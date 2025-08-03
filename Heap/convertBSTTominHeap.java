import java.util.* ;
import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure:

    class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	
	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	   }
    }

*************************************************************/

public class Solution {

	private static int countNodes(BinaryTreeNode root)
	{
		if(root == null)	return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	private static void inorder(BinaryTreeNode root, List<Integer> list)
	{
		if(root == null)	return;
		inorder(root.left, list);
		list.add(root.data);
		inorder(root.right, list);
	}
	private static void preorderFill(BinaryTreeNode root, List<Integer> list, int[] index)
	{
		if(root==null)	return;
		root.data = list.get(index[0]);
		index[0]++;
		preorderFill(root.left, list, index);
		preorderFill(root.right, list, index);

	}
	public static BinaryTreeNode convertBST(BinaryTreeNode root) {
		// Write your code here.
		List<Integer> list = new ArrayList<>();

		inorder(root, list);
		int[] index = {0};
		preorderFill(root,list,index);
		return root;


	}
}

