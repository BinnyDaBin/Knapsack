
/**
 * Node storing the total weight of the knapsack, the total profit of the knapsack, and 
 * the bound value representing the potential value of the children of the tree.
 *
 * @author Jane Delmonico
 * @author Binny Lee
 * @author Allegra Allgeier
 * @version 7 March 2019
 */
public class Node
{
    // instance variables - replace the example below with your own
    private int totalw;
    private int totalp;
    private int bound;

    /**
     * Constructor for objects of class Node
     */
    public Node(int totalWeight, int totalProfit, int boundValue)
    {
        // initialise instance variables
        totalw = totalWeight;
        totalp = totalProfit;
        bound = boundValue;
    }

    /**
     * Retrieves the total Weight of the node
     * @return int
     */
    public int getWeight()
    {
        return totalw;
    }
    
    
    /**
     * Retrieves the total Profit of the node
     * @return int 
     */
    public int getProfit()
    {
        return totalp;
    }
    
    /**
     * Retrieves the bound value of the node
     * @return int 
     */
    public int getBound()
    {
        return bound;
    }
    
}
