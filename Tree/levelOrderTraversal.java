class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        // Your code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            int levelSize = queue.size();
            ArrayList<Integer> result = new ArrayList<>();
            for(int i=0;i<levelSize;i++)
            {
                Node temp = queue.poll();
                result.add(temp.data);
                
                if(temp.left!=null)
                {
                    queue.add(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.add(temp.right);
                }
            
            }
            list.add(result);
        }
        return list;
    }
}
