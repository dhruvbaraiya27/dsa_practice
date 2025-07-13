import java.util.* ;
import java.io.*; 
public class Deque 
{
    int size;
    int arr[];
    int front;
    int rear;
    // Initialize your data structure.
    public Deque(int n) 
    {
        // Write your code here.
        size =n;
        arr =new int[size];
        front=rear=-1;
    }

    // Pushes 'X' in the front of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushFront(int x) 
    {
        // Write your code here.
        if(isFull())  return false;

        if(isEmpty())   rear=front=0;
        else if(front==0)   front=size-1;
        else front = (front-1 + size) % size;

        arr[front]=x;
        return true;
    }

    // Pushes 'X' in the back of the deque. Returns true if it gets pushed into the deque, and false otherwise.
    public boolean pushRear(int x) 
    {
        // Write your code here.
        if(isFull())    return false;
        if(isEmpty())   rear=front=0;
        else if(rear==size-1)   rear=0;
        else rear = (rear+1) % size;

        arr[rear]=x;
        return true;
    }

    // Pops an element from the front of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popFront() 
    {
        // Write your code here.
        if(isEmpty())   return -1;
        int ans = arr[front];
        arr[front]=-1;

        if(front==rear)
        {
            front=-1;
            rear=-1;
        }
        else
        {
            front = (front +1)% size;
        }
        return ans;
    }

    // Pops an element from the back of the deque. Returns -1 if the deque is empty, otherwise returns the popped element.
    public int popRear() 
    {
        // Write your code here.
        if(isEmpty())   return -1;
        int ans = arr[rear];
        arr[rear]=-1;

        if(front==rear)
        {
            front=-1;
            rear=-1;
        }
        else{
            rear = (rear-1 + size)%size;
        }
        return ans;

    }

    // Returns the first element of the deque. If the deque is empty, it returns -1.
    public int getFront() 
    {
        // Write your code here.
        if(isEmpty())   return -1;
        return arr[front];
    }

    // Returns the last element of the deque. If the deque is empty, it returns -1.
    public int getRear() 
    {
        // Write your code here.
        if(isEmpty())   return -1;
        return arr[rear];
    }

    // Returns true if the deque is empty. Otherwise returns false.
    public boolean isEmpty() 
    {
        // Write your code here.
        return front==-1;
    }

    // Returns true if the deque is full. Otherwise returns false.
    public boolean isFull() 
    {
        // Write your code here.
        return ( (rear+1) % size == front);
    }
}
