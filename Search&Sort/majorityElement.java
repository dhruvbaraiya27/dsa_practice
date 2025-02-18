class Solution {
    static int majorityElement(int arr[]) {
        // your code here
       int count =0;
       int n=arr.length;
       int candidate=-1;
       
       //step 1: varifty candidate
       for(int i:arr)
       {
           if(count==0)
           {
               candidate=i;
               count=1;
           }
           
           else if(i==candidate)
           {
               count++;
           }
           else
           {
               count--;
           }
       }
       
       //step2: count candidate
       count=0;
       for(int i:arr)
       {
           if(i==candidate)
           {
               count++;
           }
       }
       
       if(count > n/2)
       {
           return candidate;
       }
       else 
       {
           return -1;
       }
    }
}
