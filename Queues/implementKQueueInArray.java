package org.example;

public class kQueue {
    int arr[];
    int front[];
    int rear[];
    int next[];
    int k;
    int n;
    int freeSpot;

    kQueue(int n, int k)
    {
        this.n = n;
        this.k = k;
        arr = new int[n];
        next = new int[n];
        front = new int[k];
        rear = new int[k];
        freeSpot = 0;

        for(int i = 0; i < k; i++)
        {
            front[i] = -1;
            rear[i] = -1;
        }

        for(int i = 0; i < n-1; i++)
        {
            next[i] = i+1;
        }
        next[n-1] = -1;
        freeSpot=0;
    }
    public void enqueue(int data, int qn)
    {
        if(freeSpot==-1)
        {
            System.out.println("Queue is full");
            return;
        }

        int index = freeSpot;
        freeSpot = next[index];

        if(front[qn-1] == -1)
        {
            front[qn-1] = index;
        }
        else {
            next[rear[qn-1]] = index;
        }
        next[index] = -1;
        rear[qn-1] = index;
        arr[index] = data;
    }
    public int dequeue(int qn)
    {
        if(front[qn-1] == -1)
        {
            System.out.println("Queue is empty");
            return -1;
        }
        int index = front[qn-1];
        front[qn-1] = -1;
        next[index]=freeSpot;
        freeSpot = index;
        return arr[index];
    }

}
