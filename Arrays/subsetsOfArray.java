class Solution {

    private void solve(int[] nums,List<List<Integer>> ans, List<Integer> output, int index)
    {
        if(index>=nums.length)
        {
            ans.add(new ArrayList<>(output));
            return;
        }

        //exclude
        solve(nums,ans,output,index+1);

        int ele = nums[index];
        output.add(ele);
        solve(nums,ans,output,index+1);
        output.remove(output.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> output = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int index=0;

        solve(nums,ans,output,index);

        return ans;

        
    }
}
