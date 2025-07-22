/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
    private static class Pair{
        int maxLength;
        int maxSum;
        
        Pair(int maxLength, int maxSum)
        {
            this.maxLength = maxLength;
            this.maxSum = maxSum;
        }
    }
    private void solve(Node root, int len, int sum, Pair result)
    {
        if(root==null)
        {
            if(len > result.maxLength)
            {
                result.maxLength = len;
                result.maxSum = sum;
            }
            if(len == result.maxLength)
            {
               result.maxSum = Math.max(sum, result.maxSum);
            }
            return;
        }
        sum += root.data;
        solve(root.left, len+1, sum, result);
        solve(root.right, len+1, sum, result);
    }
    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        Pair result = new Pair(0,0);
        int len=0, sum=0;
        solve(root, len, sum, result);
        
        return result.maxSum;
        
    }
}
