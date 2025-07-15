import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static long sumOfMaxAndMin(ArrayList<Integer> nums, int n, int k) {
        // Write your code here.
        long ans = 0;

        Deque<Integer> maxi = new LinkedList<>();
        Deque<Integer> mini = new LinkedList<>();

        for(int i=0;i<k;i++)
        {
            while(!maxi.isEmpty() && nums.get(maxi.peekLast()) <= nums.get(i))
            {
                maxi.pollLast();
            }
            while(!mini.isEmpty() && nums.get(mini.peekLast()) >= nums.get(i))
            {
                mini.pollLast();
            }
            maxi.addLast(i);
            mini.addLast(i);
        }
        ans+= nums.get(maxi.peekFirst())+ nums.get(mini.peekFirst());

        for(int i=k;i<n;i++)
        {
            while(!maxi.isEmpty() && i - maxi.peekFirst() >=k)
            {
                maxi.pollFirst();
            }
            while(!mini.isEmpty() && i - mini.peekFirst() >=k)
            {
                mini.pollFirst();
            }

            while(!maxi.isEmpty() && nums.get(maxi.peekLast())<=nums.get(i))
            {
                maxi.pollLast();
            }
            while(!mini.isEmpty() && nums.get(mini.peekLast()) >= nums.get(i))
            {
                mini.pollLast();
            }
            maxi.addLast(i);
            mini.addLast(i);

            ans+= nums.get(maxi.peekFirst())+ nums.get(mini.peekFirst());

        }


        return ans;
    }
}
