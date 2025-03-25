class Solution {
    /*
    1.	XOR (a ^ b) gives the sum without the carry
	2.	AND (a & b) gives the carry, which needs to be added to the result → so shift it left by 1 ((a & b) << 1)
	3.	Repeat this process until carry becomes 0
    */ 
    public int getSum(int a, int b) {
        while(b!=0)
        {
            int carry = (a&b)<<1; //carry (but not added yet)
            a = a^b;              //partial sum (no carry)
            b=carry;              // new b is carry (to be added in next round)
        }
        return a;
    }
}
