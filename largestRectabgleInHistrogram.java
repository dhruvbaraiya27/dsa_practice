class Solution {
    private static int[] nextSmaller(int arr[])
    {
        int n= arr.length;
        int[] next = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i=n-1;i>=0;i--)
        {
            int curr = arr[i];
            while(stack.peek()!=-1 && curr <=arr[stack.peek()])
            {
                stack.pop();
            }
            next[i] = stack.peek();
            stack.push(i);
        }
        return next;
    }
    private static int[] prevSmaller(int arr[])
    {
        int n= arr.length;
        int[] prev = new int[n];
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i=0;i<n;i++)
        {
            int curr = arr[i];
            while(stack.peek()!=-1 && curr <=arr[stack.peek()])
            {
                stack.pop();
            }
            prev[i] = stack.peek();
            stack.push(i);
        }
        return prev;
    }
    public static int getMaxArea(int arr[]) {
        // your code here
        int n=arr.length;
        int next[] = nextSmaller(arr);
        int prev[] = prevSmaller(arr);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int length = arr[i];
            if(next[i]==-1)
            {
                next[i]=n;
            }
            int breadth = next[i]-prev[i]-1;
            
            maxArea = Math.max(maxArea, length*breadth);
            
        }
        return maxArea;
    }
}
