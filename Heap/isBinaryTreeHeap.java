/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution {
    private int countNodes(Node root)
    {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private boolean isCBT(Node root, int i, int cnt)
    {
        if(root == null)    return true;
        if(i>=cnt)  return false;
        else{
            boolean left = isCBT(root.left, 2*i+1, cnt);
            boolean right = isCBT(root.right , 2*i+2, cnt);
            
            return (left&&right);
        }
    }
    private boolean isMaxHeap(Node root)
    {
        if(root.left == null && root.right == null) return true;
        else if(root.right==null)    return ((root.data >= root.left.data) && isMaxHeap(root.left));
        else{
            boolean left = isMaxHeap(root.left);
            boolean right = isMaxHeap(root.right);
            
            return (root.data >= root.left.data && root.data >= root.right.data) && left && right;
        }
    }
    boolean isHeap(Node tree) {
        // code here
        if(tree == null)    return true;
        int nodeCounts = countNodes(tree);
        int index=0;
        return isCBT(tree, index, nodeCounts) && isMaxHeap(tree);
    }
}
