class Solution {
    int middle(int a, int b, int c) {
        // code here
        if(a>b && a>c)
        {
            return b>c?b:c;
        }
        else if(b>c && b>a)
        {
            return a>c?a:c;
        }
        else
        {
            return a>b?a:b;
        }
    }
}
