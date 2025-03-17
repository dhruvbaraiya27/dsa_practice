class Solution {
    
    // Returns area of the largest rectangle with all 1s in mat[][]
    private static int[] nextSmaller(int row[])
    {
        
        int n=row.length;
        int[] next = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i=n-1;i>=0;i--)
        {
            int curr=row[i];
            while(stack.peek()!=-1 && curr<=row[stack.peek()])
            {
                stack.pop();
            }
            next[i] = stack.peek();
            stack.push(i);
            
        }
        return next;
    }
    private static int[] prevSmaller(int row[])
    {
        
        int n=row.length;
        int[] prev = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i=0;i<n;i++)
        {
            int curr=row[i];
            while(stack.peek()!=-1 && curr<=row[stack.peek()])
            {
                stack.pop();
            }
            prev[i] = stack.peek();
            stack.push(i);
            
        }
        return prev;
    }
    private static int largestArea(int row[])
    {
        int next[] = nextSmaller(row);
        int prev[] = prevSmaller(row);
        int area = Integer.MIN_VALUE;
        for(int i=0;i<row.length;i++)
        {
            int length=row[i];
            if(next[i]==-1)
            {
                next[i]=row.length;
            }
            int breadth = next[i]-prev[i]-1;
            area = Math.max(area,length*breadth);
        }
        return area;
    }
    
    static int maxArea(int mat[][]) {
        // Your code here
        int area = largestArea(mat[0]);
        int rows=mat.length;
        int cols = mat[0].length;
        
        for(int i=1;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(mat[i][j] !=0)
                    mat[i][j]+=mat[i-1][j];
                else
                    mat[i][j]=0;
            }
            area = Math.max(area, largestArea(mat[i]));
        }
        return area;
        
    }
}
