/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    ArrayList<Integer> list;
    private void inorder(Node root)
    {
        if(root == null)    return;
        inorder(root.left);
        list.add(root.data);
        inorder(root.right);
    }
    boolean findTarget(Node root, int target) {
        // Write your code here
        list = new ArrayList<>();
        inorder(root);
        
        int i=0, j= list.size()-1;
        
        while(i<j)
        {
            int sum = list.get(i) + list.get(j);
            if(sum == target)   return true;
            else if(sum < target)   i++;
            else j--;
        }
        return false;
        
    }
}
