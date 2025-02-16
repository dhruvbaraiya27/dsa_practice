class Solution {
    public static int maxSubStr(String str) {
       //Write your code here
       int count0=0;
       int count1=0;
       
       int splitCount=0;
       
       for(char c: str.toCharArray())
           {
           if(c=='0')
           {
               count0++;
           }
           else if(c=='1')
           {
               count1++;
           }
           if(count0==count1)
           {
               splitCount++;
           }
           
       }
       
       if(count0!=count1)
       {
           return -1;
       }
       
       return splitCount;
    }
}
