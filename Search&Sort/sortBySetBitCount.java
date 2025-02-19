class Compute  
{ 
    private static int countBit(int num)
    {
        int count=0;
        while(num>0)
        {
            count+= num &1;
            num >>=1;
        }
        return count;
    }
   
    static void sortBySetBitCount(Integer arr[], int n)
    { 
        
        Arrays.sort(arr,(a,b)-> {
            int countA = countBit(a);
            int countB = countBit(b);
            
            if(countA!=countB)
            {
                return countB-countA;
            }
            return 0;
            
        });
        
    } 
}
