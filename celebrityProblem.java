class Solution {
    private boolean knows(int mat[][], int a, int b)
    {
        if(mat[a][b]==1) return true;
        return false;
    }
    public int celebrity(int mat[][]) {
        // code here
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<mat.length;i++)
        {
            stack.push(i);
        }
        while(stack.size()>1)
        {
            int a = stack.pop();
            int b= stack.pop();
        
            if(knows(mat,a,b))
                stack.push(b);
            else
                stack.push(a);
        }
        
        int candidate = stack.pop();
        int zeroCount=0;
        int oneCount=0;
        for(int i=0;i<mat.length;i++)
        {
            if(mat[candidate][i] ==0) zeroCount++;
            if(mat[i][candidate]==1) oneCount++;
        }
        if((zeroCount==mat.length-1) && (oneCount==mat.length)) return candidate;
        return -1;
        
        
        
    }
}
