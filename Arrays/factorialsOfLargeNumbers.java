import java.math.BigInteger;
class Solution {
    
    private static BigInteger getFactorial(int n)
    {
        if(n==0 || n==1)
        {
            return BigInteger.ONE;
        }
        
        BigInteger k = BigInteger.valueOf(n).multiply(getFactorial(n-1));
        
        return k;
    }
    public static ArrayList<Integer> factorial(int n) {
        // code here
        BigInteger fact = getFactorial(n);
        String s = fact.toString();
        ArrayList<Integer> list =new ArrayList<>();
        
        for(char ch : s.toCharArray())
        {
            list.add(ch - '0');
        }
        
        return list;
        
    }
}
