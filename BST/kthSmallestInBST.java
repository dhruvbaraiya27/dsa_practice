// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution {
    
    private int count=0;
    private int result=-1;
    // Return the Kth smallest element in the given BST
    private void inorder(Node root, int k)
    {
        if(root == null)    return;
        inorder(root.left, k);
        count++;
        if(count==k){
            result = root.data;
            return;
        }
        inorder(root.right, k);
    }
    public int kthSmallest(Node root, int k) {
        // Write your code here
        inorder(root, k);
        return result;
    }
}
