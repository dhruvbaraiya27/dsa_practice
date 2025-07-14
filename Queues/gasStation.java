class Solution {
    public int startStation(int[] gas, int[] cost) {
        // Your code here
        if(gas.length!=cost.length) return -1;
        
        int balance=0;
        int deficit=0;
        int start=0;
        
        for(int rear=0;rear<gas.length;rear++)
        {
            balance += gas[rear]-cost[rear];
            if(balance<0)
            {
                deficit+=balance;
                start=rear+1;
                balance=0;
            }
        }
        
        if(balance + deficit>=0)
        {
            return start;
        }
        return -1;
    }
}
