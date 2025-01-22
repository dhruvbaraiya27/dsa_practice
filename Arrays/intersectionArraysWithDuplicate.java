class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // code here
        
        
        HashSet<Integer> set1= new HashSet<>();
        HashSet<Integer> set2= new HashSet<>();
        for(int i : a)
        {
            set1.add(i);
        }
        for(int i:b)
        {
            if(set1.contains(i))
            {
                set2.add(i);
            }
        }
        return new ArrayList<>(set2);
        
    }
}
