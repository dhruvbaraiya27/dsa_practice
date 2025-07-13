import java.util.* ;
import java.io.*; 
public class Queue {
    int arr[];
    int size;
    int qfront;
    int rear;

    Queue() {
        // Implement the Constructor
        size = 100001;
        arr = new int[size];
        qfront=rear=0;
    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return qfront==rear;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        if(rear==size)  return;
        arr[rear++]=data;
    }

    int dequeue() {
        // Implement the dequeue() function
        if(isEmpty())   return -1;
        return arr[qfront++];
        
    }

    int front() {
        // Implement the front() function
        if(isEmpty())   return -1;
        return arr[qfront];
    }

}
