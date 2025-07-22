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
    private int solve(Node root, int k, ArrayList<Integer> path)
    {
        if(root == null)    return 0;
        path.add(root.data);
        int count=0;
        int sum=0;
        count += solve(root.left,k,path);
        count += solve(root.right, k, path);
        for(int i=path.size()-1;i>=0;i--)
        {
            sum +=path.get(i);
            if(sum==k)  count++;
        }
        path.remove(path.size()-1);
        
        return count;
        
    }
    public int sumK(Node root, int k) {
        // code here
        
        return solve(root, k, new ArrayList<>());
    }
}
