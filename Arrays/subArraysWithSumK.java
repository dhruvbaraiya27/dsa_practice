class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);
        int sum=0;
        int count=0;
        for(int i : arr)
        {
            sum+=i;
            if(freqMap.containsKey(sum - k))
            {
                count+=freqMap.get(sum-k);
            }
            freqMap.put(sum, freqMap.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
