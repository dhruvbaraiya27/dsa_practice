/*
Structure of Node class is:

class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/

class Solution {
    private int findKthAncestor(Node root, int node, int[] kValue)
    {
        if(root == null)    return -1;
        if(root.data == node)   return root.data;
        
        int left = findKthAncestor(root.left, node , kValue);
        int right = findKthAncestor(root.right, node, kValue);
        
        if(left!=-1 || right!=-1)
        {
            kValue[0]--;
            if(kValue[0]==0)    return root.data;
            return left!=-1 ? left : right;
        }
        return -1;
    }
    public int kthAncestor(Node root, int k, int node) {
        // Write your code here
        int[] kValue = new int[]{k};
        int result = findKthAncestor(root, node, kValue);
        return kValue[0] > 0 ? -1 : result;
    }
}
