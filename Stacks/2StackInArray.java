class twoStacks {
    int arr[];
    int top1, top2;
    
    
    twoStacks() {
        arr = new int[100];
        top1=-1;
        top2 = 100;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        if(top2 - top1 > 1)  arr[++top1] = x;
        else return;
        
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        // code here
        if(top2-top1 > 1) arr[--top2] = x;
        else return;
    }

    // Function to remove an element from top of the stack1.
    int pop1() {
        // code here
        if(top1>=0) return arr[top1--];
        return -1;
    }

    // Function to remove an element from top of the stack2.
    int pop2() {
        // code here
        if(top2<100) return arr[top2++];
        return -1;
    }
}
