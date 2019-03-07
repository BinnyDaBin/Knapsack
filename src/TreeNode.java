
public class TreeNode {

	TreeNode leftchild;
	TreeNode rightchild;
	
	int totprofit;
	int totweight;
	int totbound;
	
	int depth;
	int position_FromLeft;
	TreeNode(Item item)
	{
		
		
	}
	public TreeNode getLeftchild() {
		return leftchild;
	}
	public void setLeftchild(TreeNode leftchild) {
		this.leftchild = leftchild;
	}
	public TreeNode getRightchild() {
		return rightchild;
	}
	public void setRightchild(TreeNode rightchild) {
		this.rightchild = rightchild;
	}
	public int getTotprofit() {
		return totprofit;
	}
	public void setTotprofit(int totprofit) {
		this.totprofit = totprofit;
	}
	public int getTotweight() {
		return totweight;
	}
	public void setTotweight(int totweight) {
		this.totweight = totweight;
	}
	public int getTotbound() {
		return totbound;
	}
	public void setTotbound(int totbound) {
		this.totbound = totbound;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getPosition_FromLeft() {
		return position_FromLeft;
	}
	public void setPosition_FromLeft(int position_FromLeft) {
		this.position_FromLeft = position_FromLeft;
	}
	
	
	
	
}
