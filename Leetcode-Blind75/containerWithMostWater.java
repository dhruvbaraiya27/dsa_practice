class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int area=0;
        int left=0,right=n-1;
        while(left< right)
        {
            area = Math.max(area, Math.min(height[left],height[right]) * (right-left));
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return area;
    }
}
