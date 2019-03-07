import java.util.ArrayList;

public class DynamicKnapsack {
	
	//items each with 3 numbers: item number(index 0), profit(index 1), weight (index 2)
	// index correspond to item number
	// I changed the item id in the sample.dad file so it'll start from 0.
	ArrayList<Item> items;
	// n: number of items
	int n;
	// W: total weight limit.
	int W;
	
	
	DynamicKnapsack(String filename)
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
		
	}
	
	
	/**
	 * 
	 * @return
	 */
	int solveKnapsack()
	{
		int[][] P = new int[n][W];
		
		// set P[0][w] and P[i][0] to 0
		for (int i = 0; i < n; i++)
		{
			P[0][i] = 0;
		}
		for (int i = 0; i < n; i++)
		{
			P[i][0] = 0;
		}
		
		int pi, wi;
		for (int i = 1; i < n; i++)
		{
			for (int w = 1; w < W; w++)
			{
				pi = items.get(i).getProfit();
				wi = items.get(i).getWeight();
				
				if (wi <= w)
				{
					if (P[i-1][w] > pi + P[i-1][w-wi])
					{
						P[i][w] = P[i-1][w];
					}
					
					else 
					{
						P[i][w] = pi + P[i-1][w-wi];
					}
					
				}
				
				else
				{
					P[i][w] = P[i-1][w];
				}
							
			}
	
		}
		
				
		return P[n-1][W-1];
				
	}
	
}
