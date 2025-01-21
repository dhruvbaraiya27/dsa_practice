// User function Template for Java

// User function Template for Java

class Solution {
    private static class Pair{
        private int index;
        private int data;
        
        Pair(int index, int data)
        {
            this.index = index;
            this.data = data;
        }
    }
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
       int n = arr.length;
       ArrayList<Pair> l = new ArrayList<>();
       for(int i=0;i<n;i++)
       {
           l.add(new Pair(i,arr[i]));
       }
       l.sort(Comparator.comparingInt(p -> p.data));
       
       List<List<Integer>> result = new ArrayList<>();
       
       for(int i=0;i<n-2;i++)
       {
           if(i>0 && l.get(i).data==l.get(i-1).data)
           {
               continue;
           }
           int left = i+1;
           int right=n-1;
           
           while(left<right)
           {
               int sum = l.get(i).data + l.get(left).data + l.get(right).data;
               if(sum==0)
               {
                   List<Integer> tripletIndex = new ArrayList<>();
                   tripletIndex.add(l.get(i).index);
                   tripletIndex.add(l.get(left).index);
                   tripletIndex.add(l.get(right).index);
                   
                   Collections.sort(tripletIndex);
                   result.add(tripletIndex);
                   
                   left++;
                   right--;
                   
                   while(left<right && l.get(left).data==l.get(left-1).data)
                   {
                       left++;
                   }
                   while(left<right && l.get(right).data==l.get(right+1).data)
                   {
                       right--;
                   }
               }
               else if(sum<0) left++;
               else right--;
           }
       }
       return result;
    }
}
