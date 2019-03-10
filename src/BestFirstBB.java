import java.util.ArrayList;
import java.util.PriorityQueue;

// Based on algorithm 6.2
/**
 *@author Allegra Allgeier, Binny Lee, Jane Delmonico
 *
 *
 */
public class BestFirstBB {

	ArrayList<Item> items;
	// n: number of items
	int n;
	// W: total weight limit.
	int W;
	
	BestFirstBB(String filename)
	{
		InputReader reader = new InputReader("sample.dat");
		ArrayList<int[]> data = reader.readData();
		n = data.get(0)[0];
		W = data.get(1)[0];
		
		items = new ArrayList<Item>();
		for (int i = 0; i < n; i++)
		{
			items.add(new Item(data.get(i+2)[0], data.get(i+2)[1], data.get(i+2)[2]));	
		}
		
		// sort items according to p_over_w in non-increasing order
		items = mergesort(n, items);
		
	}
	
	/**
	 * 
	 * Performs mergesort to sort Item objects according to
	 * profit/weight in non-decreasing order.
	 * 
	 * @param n - number of items
	 * @param S - arraylist of items to be sorted
	 * @return sorted arraylist 
	 */
	private ArrayList<Item> mergesort(int n, ArrayList<Item> S)
	{
		if (n > 1)
		{
			int h = n/2;
			int m = n - h;
			ArrayList<Item> U = new ArrayList<Item>();
			ArrayList<Item> V = new ArrayList<Item>();
			
			// copy the first h elements of S to U
			for (int i = 0; i < h; i++)
			{
				U.add(S.get(i));		
			}
			
			// copy the rest of the elements of S to V
			for (int i = 0; i < m; i++)
			{
				V.add(S.get(i+h));			
			}
						
			U = mergesort(h, U);
			V = mergesort(m, V);
			return merge(h, m, U, V, S);
						
		}
		
		
		return S;
		
	}
	
	/**
	 * 
	 * This function merges two sorted arrays into one sorted array.
	 * 
	 * ++++Tested++++
	 * @param h - number of elements in U
	 * @param m - number of elements in V
	 * @param U - sorted list
	 * @param V - sorted list
	 * @param S - list merging U and V
	 */
	private ArrayList<Item> merge (int h, int m,  ArrayList<Item> U,  ArrayList<Item> V, ArrayList<Item> S)
	{
		ArrayList<Item> R = new ArrayList<Item>();
		int i, j;
		i = 0; j= 0;
		
		while (i < h && j < m)
		{
			if (U.get(i).getP_over_W() < V.get(j).getP_over_W())
			{
				R.add(V.get(j)); 
				j++;
			}
			
			else
			{
				R.add(U.get(i)); 
				i++;		
			}
			
		}
		
		// if all the elements of U get put into S, copy all of the remaining
		// elements in V to S.
		if (h <= i)
		{			
			int a = m-j;
			for (int p = 0; p < a; p++)
			{
				R.add(V.get(p+j));
			}
		}
		
		// if all the elements of V get put into S, copy all of the remaining 
		// elements in U to S.
		else
		{
			int b = h - i;
			for (int q = 0; q < b; q++)
			{
				R.add(U.get(i+q));
			}
			
		}	
		return R;			
	}
	
	
	
	
	
}
