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
    
    // Helper class to store information for each subtree
    private static class Info {
        int maxi;         // Maximum value in the subtree
        int mini;         // Minimum value in the subtree
        boolean isBST;    // Flag to indicate if the subtree is a BST
        int size;         // Total number of nodes in the current subtree
        int maxBSTSize;   // Size of the largest BST found so far

        Info(int maxi, int mini, boolean isBST, int size, int maxBSTSize) {
            this.maxi = maxi;
            this.mini = mini;
            this.isBST = isBST;
            this.size = size;
            this.maxBSTSize = maxBSTSize;
        }
    }

    // Recursive function to process each node and return Info object
    private static Info solve(Node root) {
        // Base case: null node is a valid BST of size 0
        if (root == null) {
            return new Info(Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0, 0);
        }

        // Recurse on left and right subtrees
        Info left = solve(root.left);
        Info right = solve(root.right);

        // Create a new Info object for the current node
        Info curr = new Info(0, 0, false, left.size + right.size + 1, 0);

        // Check if the current subtree is a BST
        if (left.isBST && right.isBST && root.data > left.maxi && root.data < right.mini) {
            curr.isBST = true;
            curr.maxi = Math.max(root.data, right.maxi);     // update max from right
            curr.mini = Math.min(root.data, left.mini);      // update min from left
            curr.maxBSTSize = curr.size;                     // current BST is valid, update max
        } else {
            curr.isBST = false;
            curr.maxBSTSize = Math.max(left.maxBSTSize, right.maxBSTSize); // pass largest found
        }

        return curr;
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        Info ans = solve(root);  // call the helper function
        return ans.maxBSTSize;   // return the result
    }
}
