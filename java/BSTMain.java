//import java.util.*;

public class BSTMain {
	
	static void preorder(TreeNode root) {
		if ( root != null ) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	static TreeNode insert(TreeNode root, int key) {
		if (root == null) return new TreeNode(key);
		if (key < root.data)
			root.left = insert(root.left, key);
		else
			root.right = insert(root.right, key);
		return root;
	}
	
	static TreeNode min(TreeNode root) {
		TreeNode temp = root;
		while(temp.left != null)
			temp = temp.left;
		return temp;
	}
	
	static TreeNode delete(TreeNode root, int key) {
		if ( root == null ) return root;
		
		// 1. Search where the element is
		if ( key < root.data )
			root.left = delete(root.left, key);

		else if ( key > root.data )
			root.right = delete(root.right, key);
		
		// If the key is same as root's key then this is the node
		else {
			
			// 1. if node has only right child
			if ( root.left == null ) {
				TreeNode temp = root.right;
				root = null;
				return temp;
			}
			// 2. if node has only left child
			else if ( root.right == null ) {
				TreeNode temp = root.left;
				root = null;
				return temp;
			}
			
			// 3. If node has two children
			TreeNode temp = min(root.right);
			
			root.data = temp.data;
			
			root.right = delete(root.right, temp.data);
		}
		return root;
	}
	
	static int getBalance(TreeNode root) {
		if ( root == null ) return 0;
		return height(root.left) - height(root.right);
	}
	
	static TreeNode rightRotate(TreeNode y) {
		TreeNode x = y.left;
	    TreeNode T2 = x.right;
	 
	    // Perform rotation
	    x.right = y;
	    y.left = T2;
	 
	    // Update heights
	    y.height = Math.max(height(y.left), height(y.right))+1;
	    x.height = Math.max(height(x.left), height(x.right))+1;
	 
	    // Return new root
		
		return x;
	}
	
	static TreeNode leftRotate(TreeNode x) {
		TreeNode y = x.right;
	    TreeNode T2 = y.left;
	 
	    // Perform rotation
	    y.left = x;
	    x.right = T2;
	 
	    //  Update heights
	    x.height = Math.max(height(x.left), height(x.right))+1;
	    y.height = Math.max(height(y.left), height(y.right))+1;
	 
	    // Return new root
	    return y;
	}
	
	static int height(TreeNode root) {
		if ( root == null ) return 0;
		return root.height;
	}
	
	static TreeNode avlInsert(TreeNode node, int key) {
		
		/* 1.  Perform the normal BST rotation */
	    if (node == null)
	        return new TreeNode(key);
	 
	    if (key < node.data)
	        node.left  = insert(node.left, key);
	    else
	        node.right = insert(node.right, key);
	 
	    /* 2. Update height of this ancestor node */
	    node.height = Math.max(height(node.left), height(node.right)) + 1;
	 
	    /* 3. Get the balance factor of this ancestor node to check whether
	       this node became unbalanced */
	    int balance = getBalance(node);
	 
	    // If this node becomes unbalanced, then there are 4 cases
	 
	    // Left Left Case
	    if (balance > 1 && key < node.left.data)
	        return rightRotate(node);
	 
	    // Right Right Case
	    if (balance < -1 && key > node.right.data)
	        return leftRotate(node);
	 
	    // Left Right Case
	    if (balance > 1 && key > node.left.data)
	    {
	        node.left =  leftRotate(node.left);
	        return rightRotate(node);
	    }
	 
	    // Right Left Case
	    if (balance < -1 && key < node.right.data)
	    {
	        node.right = rightRotate(node.right);
	        return leftRotate(node);
	    }
	 
	    /* return the (unchanged) node pointer */
	    return node;
	}
	
	public static void main(String[] args) {
		TreeNode root = null;
		root = new TreeNode(10);
		avlInsert(root, 20);
		avlInsert(root, 30);
		avlInsert(root, 40);
		avlInsert(root, 50);
		avlInsert(root, 25);
		
		preorder(root);
		
//		System.out.println(root.data);
	}

}
