import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Solution {

    private static void solve(String str, ArrayList<String> res,String output, int index)
    {
        if(index>=str.length())
        {
            if(output.length()>0)
            {
                res.add(output);
            }
            return;
        }

        solve(str, res, output, index+1);
        char c = str.charAt(index);
        solve(str,res,output+c,index+1);
    }
    public static ArrayList<String> subsequences(String str) {
        // Write your code here
       int index=0;
       ArrayList<String> res = new ArrayList<>();
       String output="";

       solve(str,res,output,index);

       return res;
    }
}
