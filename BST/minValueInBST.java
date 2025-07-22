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
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        // code here
        Node curr = root;
        while(curr.left!=null)
        {
            curr= curr.left;
        }
        return curr.data;
    }
}
