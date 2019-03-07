
public class Tree {
	
	TreeNode root;
	
	// constructor
	public Tree()
	{
		root = null;
	}

	/**
	 * Inserts a node to the Tree in 
	 * the correct place.
	 * 
	 * @param element: key of the node to be inserted
	 */
	public void addElement(int element) 
	{
		root = add(root, element);
	}

}
