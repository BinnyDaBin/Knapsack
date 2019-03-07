
public class Item {

	int id;
	int profit;
	int weight;
	double p_over_w;
	
	Item(int id, int profit, int weight)
	{
		this.id = id;
		this.profit = profit;
		this.weight = weight;
		this.p_over_w = (double)profit/ (double) weight;
	}

	public int getId() {
		return id;
	}

	public int getProfit() {
		return profit;
	}

	public int getWeight() {
		return weight;
	}

	public double getP_over_W() {
		return p_over_w;
	}
	
	
}
