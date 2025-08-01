import java.util.* ;
import java.io.*; 
public class Solution
{
	private static void heapify(int[] arr, int n, int i) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;

        if (l < n && arr[l] < arr[smallest]) smallest = l;
        if (r < n && arr[r] < arr[smallest]) smallest = r;

        if (smallest != i) {
            int temp = arr[smallest];
            arr[smallest] = arr[i];
            arr[i] = temp;

            heapify(arr, n, smallest);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        int startIndex = n / 2 - 1;
        for (int i = startIndex; i >= 0; i--) {
            heapify(arr, n, i); // ? use i, not startIndex
        }
    }

    public static int[] buildMinHeap(int[] arr) {
        int n = arr.length;
        buildHeap(arr, n);
        return arr;
    }
}

