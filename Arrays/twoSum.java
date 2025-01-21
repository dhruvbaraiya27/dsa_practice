class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
       Set<Integer> set = new HashSet<>();
       for(int num: arr)
       {
           if(set.contains(target - num))
           {
               return true;
           }
           set.add(num);
       }
       return false;
    }
}
