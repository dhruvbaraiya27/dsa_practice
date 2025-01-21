class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int prefixXOR = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele: arr)
        {
            prefixXOR ^= ele;
            if(prefixXOR == k)
            {
                count++;
            }
            int requireXOR = prefixXOR^k;
            
            if(map.containsKey(requireXOR))
            {
                count += map.get(requireXOR);
            }
            map.put(prefixXOR, map.getOrDefault(prefixXOR,0)+1);
            
        }
        return count;
        
    }
}
