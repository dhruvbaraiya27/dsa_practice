class Solution {
    
    private int[] nextSmaller(int[] heights)
    {

        int n=heights.length;
        int next[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i=n-1;i>=0;i--)
        {
            int curr = heights[i];
            while(stack.peek()!=-1 && heights[stack.peek()]>=curr)
            {
                stack.pop();
            }
            next[i] = stack.peek();
            stack.push(i);
        }
        return next;
    }
    private int[] prevSmaller(int[] heights)
    {

        int n=heights.length;
        int prev[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for(int i=0;i<n;i++)
        {
            int curr = heights[i];
            while(stack.peek()!=-1 && heights[stack.peek()]>=curr)
            {
                stack.pop();
            }
            prev[i] = stack.peek();
            stack.push(i);
        }
        return prev;
    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int next[] = nextSmaller(heights);
        int prev[] = prevSmaller(heights);
        int area = Integer.MIN_VALUE;


        for(int i=0;i<n;i++)
        {
            int length = heights[i];
            if(next[i]==-1)
            {
                next[i]=n;
            }
            int breadth = next[i] - prev[i]-1;
            area = Math.max(area, length*breadth);

        }
        return area;
    }
}
