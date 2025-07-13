import java.util.* ;
import java.io.*; 
public class CircularQueue {
	int size;
	int arr[];
	int qfront;
	int rear;
	// Initialize your data structure.
	public CircularQueue(int n) {
		size=n;
		arr= new int[size];
		qfront=rear=-1;
		
	}

	/*
	   Enqueues 'X' into the queue. Returns true if it gets pushed into the stack,
	   and false otherwise.
	*/
	public boolean enqueue(int value) {
		// Write your code here.
		if( (rear+1) % size == qfront )	return false;
		if( qfront == -1 )
		{
			qfront=0;
			rear=0;
		}
		else	rear = (rear+1) % size;
		arr[rear]=value;
		return true;
		
	}

	/*
	  Dequeues top element from queue. Returns -1 if the stack is empty, otherwise
	  returns the popped element.
	*/
	public int dequeue() {
		// Write you code here.
		if(qfront==-1)	return -1;
		int ans = arr[qfront];
		arr[qfront]=-1;
		if(qfront==rear)
		{
			qfront=rear=-1;
		}
		else	qfront = (qfront+1)%size;
		return ans;
	}
};
