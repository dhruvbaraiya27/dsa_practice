class Solution{
    
    long killinSpree(long n)
    {
        // Code Here
        long i=1;
        while( i *(i+1) *(2*i +1)/6<=n)
        {
            i++;
        }
        return i-1;
    }
}
