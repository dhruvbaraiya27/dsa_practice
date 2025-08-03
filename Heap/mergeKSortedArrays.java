import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	private static class Element{
		int value;
		int row;
		int col;
		Element(int value, int row, int col)
		{
			this.value = value;
			this.row = row;
			this.col = col;
		}
	}
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));

		for(int i=0;i<kArrays.size();i++)
		{
			if(!kArrays.get(i).isEmpty())
			{
				minHeap.offer(new Element(
					kArrays.get(i).get(0),
					i,
					0
				));
			}
		}

		while(!minHeap.isEmpty())
		{
			Element current = minHeap.poll();
			result.add(current.value);

			int nextCol = current.col + 1;
			if(nextCol < kArrays.get(current.row).size())
			{
				minHeap.offer(new Element(
					kArrays.get(current.row).get(nextCol),
					current.row,
					nextCol
				));
			}
		}
		return result;
	}
}
