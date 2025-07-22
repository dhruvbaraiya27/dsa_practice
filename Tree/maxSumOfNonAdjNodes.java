/*class Node
{
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

class Solution {
    
    private static class Pair{
        int first;
        int second;
        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    private Pair solve(Node root)
    {
        if(root == null)    return new Pair(0,0);
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        
        Pair ans = new Pair(root.data + left.second + right.second , Math.max(left.first, left.second) + Math.max(right.first, right.second));
        return ans;
    }
    // Function to return the maximum sum of non-adjacent nodes.
    public int getMaxSum(Node root) {
        // code here
        Pair ans = solve(root);
        return Math.max(ans.first, ans.second);
    }
}
