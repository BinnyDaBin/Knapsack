import java.util.ArrayList;

public class BreadthFirstBB {

	//items each with 3 numbers: item number(index 0), profit(index 1), weight (index 2)
	// index correspond to item number
	// I changed the item id in the sample.dad file so it'll start from 0.
	ArrayList<Item> items;
	// n: number of items
	int n;
	// W: total weight limit.
	int W;
		
	BreadthFirstBB(String filename)
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
		
		for (int i = 0; i< n; i++)
		{
			System.out.println(items.get(i).getP_over_W());
			
		}
		
	}
	
	/**
	 * 
	 *  SORTS IN NON INCREASING ORDER!!
	 * @param n
	 * @param S
	 * @return
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
	 * This function merges two sorted arrays into one sorted array.
	 * This function is based on the pseudo-code given in 
	 * our textbook.
	 * 
	 * SORTS IN NON INCREASING ORDER!!
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
