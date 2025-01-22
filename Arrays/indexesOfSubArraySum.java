class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int n=arr.length;
        int start=0;
        int currSum=0;
        for(int end=0;end<n;end++)
        {
            currSum+=arr[end];
            while(currSum>target && start<=end)
            {
                currSum-=arr[start];
                start++;
            }
            if(currSum==target)
            {
                list.add(start+1);
                list.add(end+1);
                return list;
            }
            
        }
        list.add(-1);
            return list;
    }
}
