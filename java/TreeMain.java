import java.util.*;

public class TreeMain {
	
	static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
	
	static TreeNode maxOf(TreeNode t1, TreeNode t2) {
		if (t1.data > t2.data)
			return t1;
		return t2;
	}
	
	static int maxOf(int ... args) {
		int max = Integer.MIN_VALUE;
		for(int arg : args) {
			if (arg > max)
				max = arg;
		}
		return max;
	}
	
	static TreeNode findMax(TreeNode root) {
		TreeNode max = root;
		if (root != null) {
			if (root.left != null)
				max = maxOf(max, findMax(root.left));
			if (root.right != null)
				max = maxOf(max, findMax(root.right));
		}
		return max;
	}
	
	static TreeNode maxNode(TreeNode root) {
		if (root == null) return null;
		
		TreeNode temp, max = root;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			if (temp.data > max.data)
				max = temp;
			
			if (temp.left != null) {
				q.add(temp.left);
			}
			
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
		return max;
	}
	
	static TreeNode deepest(TreeNode root) {
		if (root == null) return null;
		TreeNode temp = null;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			
			if (temp.left != null)
				q.add(temp.left);
			
			if (temp.right != null)
				q.add(temp.right);
		}
		return temp;
	}
	
	static void levelorder(TreeNode root) {
		if (root == null) return;
		
		TreeNode temp;
		Queue<TreeNode> q = new LinkedList<>();
		
		q.add(root);
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			System.out.print(temp.data + " ");
			
			if (temp.left != null) {
				q.add(temp.left);
			}
			
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
	}
	
	static TreeNode search(TreeNode root, int key) {
		TreeNode temp;
		if (root == null)
			return null;
		else {
			if (key == root.data)
				return root;
			else {
				temp = search(root.left, key);
				if (temp != null)
					return temp;
				else return search(root.right, key);
			}
		}
	}
	
	static TreeNode searchUsingLevel(TreeNode root, int key) {
		if (root == null) return null;
		
		TreeNode temp;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			if (temp.data == key) {
				return temp;
			}
			if (temp.left != null) {
				q.add(temp.left);
			}
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
		return null;
	}
	
	static void insert(TreeNode root, int key) {
		if (root == null) return;
		
		TreeNode temp;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while ( ! q.isEmpty() ) {
			temp = q.poll();
			
			if (temp.left == null) {
				temp.left = new TreeNode(key);
				return;
			} else {
				q.add(temp.left);
			}
			
			if (temp.right == null) {
				temp.right = new TreeNode(key);
				return;
			} else {
				q.add(temp.right);
			}
		}
	}
	
	static int size(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + size(root.left) + size(root.right);
	}
	
	static int sizeUsinglevel(TreeNode root) {
		if (root == null) return 0;
		TreeNode temp;
		int count = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			if (temp != null)
				count++;
			if (temp.left != null) {
				q.add(temp.left);
			}
			
			if (temp.right != null) {
				q.add(temp.right);
			}
		}
		return count;
	}
	
	static void levelReverse(TreeNode root) {
		if (root == null) return;
		TreeNode temp;
		Queue<TreeNode> q = new LinkedList<>();
		Stack<TreeNode> s = new Stack<>();
		q.add(root);
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			if (temp.right != null)
				q.add(temp.right);
			
			if (temp.left != null)
				q.add(temp.left);
			
			s.push(temp);
		}

		while( ! s.isEmpty() )
			System.out.print(s.pop().data + " ");

	}
	
	static int height(TreeNode root) {
		int leftHeight, rightHeight;
		if (root == null)
			return 0;
		else {
			leftHeight = height(root.left);
			rightHeight = height(root.right);
			
			if (leftHeight > rightHeight)
				return leftHeight + 1;
			else
				return rightHeight + 1;
		}
	}
	
	static int heightUsingLevel(TreeNode root) {
		if (root == null)
			return 0;
		
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode temp;
		q.add(root);
		int level = 0;
		
		// End of first level
		q.add(null);
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			
			if (temp == null) {
				if ( ! q.isEmpty() )
					q.add(null);
				level++;
			} else {
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return level;
	}
	
	static int countLeavesLevel(TreeNode root) {
		if (root == null) return 0;
		int count = 0;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		TreeNode temp;
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			
			if (temp.left == null && temp.right == null)
				count++;
			else {
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return count;
	}
	
	static boolean isIdentical(TreeNode t1, TreeNode t2) {
		if (t1.data != t2.data || t1 == null || t2 == null) {
			return false;
		}
		return t1.data == t2.data && isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
	}
	
	static int diameter(TreeNode root) {
		if (root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);
		
		int ldiameter = diameter(root.left);
		int rdiameter = diameter(root.right);
		
		return Math.max(lheight + rheight + 1, Math.max(ldiameter, rdiameter));
	}
	
	static int maxLevelSum(TreeNode root) {
		if (root == null) return -1;
		int level = 0, maxLevel = 0, currentSum = 0, maxSum = 0;
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode temp;
		q.add(root);
		q.add(null);
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			
			if (temp == null) {
				if (currentSum > maxSum) {
					maxSum = currentSum;
					maxLevel = level;
				}
				// reset current sum
				currentSum = 0;
				
				if ( ! q.isEmpty() ) {
					q.add(null);
				}
				level++;
			}
			else {
				currentSum += temp.data;
				if (temp.left != null)
					q.add(temp.left);
				if (temp.right != null)
					q.add(temp.right);
			}
		}
		return maxLevel;
	}
	
	static void printArray(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	static void printPathsHelper(TreeNode root, int[] path, int pathLen) {
		if (root == null)
			return;
		// append this to the path array
		path[pathLen] = root.data;
		pathLen++;
		if (root.left == null && root.right == null)
			printArray(path, pathLen);
		else {
			printPathsHelper(root.left, path, pathLen);
			printPathsHelper(root.right, path, pathLen);
		}
	}
	
	static void printPaths(TreeNode root) {
		int path[] = new int[1000];
		if (root == null)
			return;
		printPathsHelper(root, path, 0);
	}
	
	static boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return sum == 0;
		else {
			int remainingSum = sum - root.data;
			if ((root.left != null && root.right != null ) ||
					(root.left == null && root.right == null )) {
				return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
			} else if (root.left != null) {
				return hasPathSum(root.left, remainingSum);
			} else {
				return hasPathSum(root.right, remainingSum);
			}
		}
	}
	
	static int getSum(TreeNode root) {
		if (root == null)
			return 0;
		return root.data + getSum(root.left) + getSum(root.right);
	}
	
	static int sumUsingLevel(TreeNode root) {
		if (root == null) return 0;
		TreeNode temp;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int sum = 0;
		
		while( ! q.isEmpty() ) {
			temp = q.poll();
			sum += temp.data;
			
			if (temp.left != null)
				q.add(temp.left);
			
			if (temp.right != null)
				q.add(temp.right);
		}
		return sum;
	}
	
	static void toMirror(TreeNode root) {
		TreeNode temp;
		if (root != null) {
			toMirror(root.left);
			toMirror(root.right);
			
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
	
	static TreeNode lca(TreeNode root, TreeNode a, TreeNode b) {
		 
		if (root == null)
			return root;
		
		if (root == a || root == b)
			return root;
		
		TreeNode left = lca(root.left, a, b);
		TreeNode right = lca(root.right, a, b);
		
		if (left != null && right != null)
			return root;
		else
			return (left != null) ? left : right;
	}
	
	static void zigzag(TreeNode root) {
		// Base case
		if (root == null) return;
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		
		TreeNode temp;
		s1.push(root);
		
		while ( ! s1.isEmpty() || ! s2.isEmpty() ) {
			
			while ( ! s1.isEmpty() ) {
				temp = s1.pop();
				System.out.print(temp.data + " ");
				
				if (temp.right != null)
					s2.push(temp.right);
				
				if (temp.left != null)
					s2.push(temp.left);
			}
			
			while ( ! s2.isEmpty() ) {
				temp = s2.pop();
				System.out.print(temp.data + " ");
				
				if (temp.left != null)
					s1.push(temp.left);
				
				if (temp.right != null)
					s1.push(temp.right);
			}			
		}
	}
	
	static void traverseSpecial(TreeNode root) {
		if (root == null) return;
		
		// print root
		System.out.print(root.data + " ");
		
		// and next level
		System.out.print(root.left.data + " " + root.right.data + " ");
	
		// Main queue
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root.left);
		q.add(root.right);
		
		TreeNode first, second;
		while ( ! q.isEmpty() ) {
			first = q.poll();
			second = q.poll();
			
			System.out.print(first.left.data + " " + second.right.data + " ");
			System.out.print(first.right.data + " " + second.left.data + " ");
			
			if (first.left.left != null) {
				q.add(first.left);
				q.add(second.right);
				q.add(first.right);
				q.add(second.left);
			}
		}
	}
	
	static boolean isSumproperty(TreeNode root) {
		int left_data = 0, right_data = 0;
		if (root == null || root.left == null && root.right == null) {
			return true;
		} else {
			if (root.left != null) {
				left_data = root.left.data;
			}
			if (root.right != null) {
				right_data = root.right.data;
			}
			if (root.data == left_data + right_data && isSumproperty(root.left) && isSumproperty(root.right)) {
				return true;
			}
		}
		return false;
	}
	
	static int leftLeavesSum(TreeNode root) {
		int res = 0;
		if (root != null) {
			if (isLeaf(root.left))
				res += root.left.data;
			else
				res += leftLeavesSum(root.left);
			res += leftLeavesSum(root.right);
		}
		return res;
	}
	
	static boolean isLeaf(TreeNode node) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null)
			return true;
		return false;
	}
	
	static void increment(TreeNode root, int diff) {
		if (root.left != null) {
			root.left.data = root.left.data + diff;
			// Recursion to fix left
			increment(root.left, diff);
		} else if(root.right != null) {
			root.right.data = root.right.data + diff;
			
			// Recursion to fix right
			increment(root.right, diff);
		}
	}
	
	static void convertTree(TreeNode root) {
		int left_data = 0, right_data = 0, diff;
		
		if (root == null || isLeaf(root))
			return;
		else {
			convertTree(root.left);
			convertTree(root.right);
			
			// Get left data
			if (root.left != null)
				left_data = root.left.data;
			
			// Get right data
			if (root.right != null)
				right_data = root.right.data;
			
			diff = left_data + right_data - root.data;
			
			if (diff > 0)
				root.data = root.data + diff;
			
			if (diff < 0)
				increment(root, -diff);
		}
	}
	
	static boolean isBalanced(TreeNode root) {
		int lh, rh;
		
		if (root == null) return true;
		
		lh = height(root.left);
		rh = height(root.right);
		
		if (Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;
		return false;
	}
	
	static int getMaxWidth(TreeNode root) {
		int maxWidth = 0, width, h = height(root);
		
		for(int i = 1; i <= h; i++) {
			width = getWidth(root, i);
			if (width > maxWidth)
				maxWidth = width;
		}
		return maxWidth;
	}
	
	static int getWidth(TreeNode root, int level) {
		if (root == null)
			return 0;
		
		if (level == 1)
			return 1;
		
		else if (level > 1)
			return getWidth(root.left, level-1) + getWidth(root.right, level-1);
		return -1;
	}
	
	static int getLevelUtil(TreeNode root, int data, int level) {
		if (root == null) return 0;
		if (root.data == data) return level;
		
		int downlevel = getLevelUtil(root.left, data, level + 1);
		if (downlevel != 0)
			return downlevel;
		
		downlevel = getLevelUtil(root.right, data, level + 1);
		return downlevel;
	}
	
	static int getLevel(TreeNode root, int data) {
		return getLevelUtil(root, data, 1);
	}
	
	static boolean isIsomorphic(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;

		if (a == null || b == null)
			return false;
		
		if (a.data != b.data)
			return false;
		
		return ( isIsomorphic(a.left, b.left) && isIsomorphic(a.right, b.right) ) ||
				( isIsomorphic(a.left, b.right) && isIsomorphic(a.right, b.left) );
	}
	
	static void doubleTree(TreeNode root) {
		TreeNode oldLeft;
		
		if (root == null)
			return;
		
		doubleTree(root.left);
		doubleTree(root.right);
		
		oldLeft = root.left;
		root.left = new TreeNode(root.data);
		root.left.left = oldLeft;
	}
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.left.left = new TreeNode(4);
	    root.left.right = new TreeNode(5);
	    root.right.left = new TreeNode(6);
	    root.right.right = new TreeNode(7);
	    root.left.left.left = new TreeNode(8);
	    root.left.left.right = new TreeNode(9);
	    root.left.right.left = new TreeNode(10);
	    root.left.right.right = new TreeNode(11);
	    root.right.left.left = new TreeNode(12);
	    root.right.left.right = new TreeNode(13);
	    root.right.right.left = new TreeNode(14);
	    root.right.right.right = new TreeNode(15);
	    
	    TreeNode tuna = new TreeNode(10);
	    tuna.left = new TreeNode(8);
	    tuna.right = new TreeNode(2);
	    tuna.left.left = new TreeNode(3);
	    
	    TreeNode tuna2 = new TreeNode(10);
	    tuna2.left = new TreeNode(2);
	    tuna2.right = new TreeNode(8);
	    tuna2.left.left = new TreeNode(3);
	    
	    doubleTree(tuna);
	    
	    inorder(tuna);
	    
	}

}