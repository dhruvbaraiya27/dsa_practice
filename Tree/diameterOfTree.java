/*
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    
    
    class Pair{
        int diameter;
        int height;
        
        Pair(int diameter, int height)
        {
            this.diameter = diameter;
            this.height = height;
        }
    }
    private Pair diameterFast(Node root)
    {
        if(root==null)  return new Pair(0,0);
        
        Pair left = diameterFast(root.left);
        Pair right = diameterFast(root.right);
        
        int op1 = left.diameter;
        int op2 = right.diameter;
        int op3 = left.height+right.height+1;
        
        int diameter = Math.max(op1, Math.max(op2, op3));
        int height = Math.max(left.height, right.height)+1;
        
        return new Pair(diameter, height);
    }
    int diameter(Node root) {
        // Your code here
        return diameterFast(root).diameter-1;
        
    }
}
