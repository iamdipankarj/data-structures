public class TreeNode {
	
	// Member variables
	public int data;
	public TreeNode left;
	public TreeNode right;
	public int height;
	
	// Constructor
	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
		height = 1;
	}
}
