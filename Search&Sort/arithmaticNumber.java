class Solution {
    static int inSequence(int a, int b, int c) {
        // code here
        // b = a + kc
        //k=b-a/c
        
        if(c==0)
        {
            return a==b?1:0;
        }
        else
        {
            if((b-a)%c == 0 && (b-a)/c >=0)
            {
                return 1;
            }
        }
        return 0;
    }
}
