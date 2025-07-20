/*class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}*/

class GFG {
    // Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root) {
        // Add your code here.
        
        if(root ==null) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(root);
        boolean leftToRight=true;
        
        while(!q.isEmpty())
        {
            int size = q.size();
            int ans[] = new int[size];
            for(int i=0;i<size;i++)
            {
                int index = leftToRight?i:size-i-1;
                Node temp = q.poll();
                ans[index] = temp.data;
                
                if(temp.left!=null)q.add(temp.left);
                if(temp.right!=null)q.add(temp.right);
            }
            leftToRight=!leftToRight;
            for(int ele: ans)
            {
                list.add(ele);
            }
        }
        return list;
    }
}
