/*
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        left=null;
        right=null;
    }
}
*/
class Solution {
    private int count =0;
    private int result =-1;
    
    private void reverseInorder(Node root, int k)
    {
        if(root == null || count >=k)   return;
        
        reverseInorder(root.right, k);
        count++;
        if(count == k)
        {
            result = root.data;
            return;
        }
        reverseInorder(root.left, k);
    }
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Your code here
        reverseInorder(root,k);
        return result;
        
    }
}
