class Solution {
    // Function to find two elements in array
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here]
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        long sumN = (long) n* (n+1)/2;
        long squareSumN = (long) n * (n+1) * (2*n+1)/6;
        
        long sumA=0;
        long sqaureSumA=0;
        
        for(int i:arr)
        {
            sumA+=i;
            sqaureSumA+=(long) i*i;
        }
        
        long diff = sumN-sumA;
        long sum = (squareSumN - sqaureSumA)/diff;
        
        int missing = (int) (sum + diff)/2;
        int repeating = (int) (sum - missing);
        list.add(repeating);
        list.add(missing);
        
        return list;
    }
}
