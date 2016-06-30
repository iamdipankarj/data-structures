public class DPMain {
	
	static int min(int x, int y, int z)	{
	   if (x < y)
	      return (x < z) ? x : z;
	   else
	      return (y < z) ? y : z;
	}
	
	/**
	 * Minimum number of steps to reach 1
	 * @param n
	 * @return
	 */
	static int getMinSteps(int n) {
		// Bas case
		if ( n == 1 ) return 0;		
		int r = 1 + getMinSteps(n-1);
		
		if ( n%2 == 0 )
			r = Math.min(r, 1 + getMinSteps(n/2));
		
		if ( n%3 == 0 )
			r = Math.min(r, 1 + getMinSteps(n/3));
		
		return r;
	}

	static int getMinStepsDP(int n) {
		int[] dp = new int[n+1];
		// Trivial Case
		dp[1] = 0;
		
		for ( int i = 2; i <= n; i++ ) {
			dp[i] = 1 + dp[i-1];
			if ( i%2 == 0 ) dp[i] = Math.min(dp[i], 1 + dp[i/2]);
			if ( i%3 == 0 ) dp[i] = Math.min(dp[i], 1 + dp[i/3]);
		}
		return dp[n];
	}
	
	static int minCost(int cost[][], int m, int n) {
		if ( n < 0 || m < 0 )
			return Integer.MAX_VALUE;
		else if ( m == 0 && n == 0 )
			return cost[m][n];
		return cost[m][n] + min(minCost(cost, m-1, n-1), minCost(cost, m-1, n), minCost(cost, m, n-1));
	}
	
	static int minCostDP(int cost[][], int m, int n) {
		int[][] dp = new int[m+1][n+1];
		
		// Base case. If we have no values at all
		dp[0][0] = cost[0][0];
		
	
		for ( int i = 1; i <= m; i++ ) {
			dp[i][0] = dp[i-1][0] + cost[i][0];
		}
		
		
		for (int j = 1; j <= n; j++) {
			dp[0][j] = dp[0][j-1] + cost[0][j];
		}
		
		Maze.printMatrix(dp);
		System.out.println();
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = cost[i][j] + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
				Maze.printMatrix(dp);
				System.out.println();
			}
		}
		return dp[m][n];
	}
	
	/**
	 * Numeric keypad problem
	 * @param args
	 */
	static int getCountUtil(char[][] keypad, int startRow, int startCol, int[] row, int[] col, int n) {
		if (n <= 0) return 0;
		if (n == 1) return 1;
		
		int ro = 0, co = 0, count = 0;
		for (int move = 0; move < 5; move++) {
			ro = startRow + row[move];
			co = startCol + col[move];
			if (ro >= 0 && ro <= 3 && co >= 0 && co <= 2 && keypad[ro][co] != '#' && keypad[ro][co] != '*') {
				count += getCountUtil(keypad, ro, co, row, col, n-1);
			}
		}
		return count;
	}
	
	static int getCount(char[][] keypad, int n) {
		if ( n <= 0 )
			return 0;
		if ( n == 1 )
			return 10;
		int count = 0;
		int row[] = {0, 0, -1, 0, 1};
		int col[] = {0, -1, 0, 1, 0};
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				if ( keypad[i][j] != '#' && keypad[i][j] != '*' ) {
					count += getCountUtil(keypad, i, j, row, col, n);
				}
			}
		}
		return count;
	}
	
	
	
	public static void main(String[] args) {
		
		/*char keypad[][] = {
							{'1','2','3'},
			                {'4','5','6'},
			                {'7','8','9'},
			                {'*','0','#'}
			               };
		
		int[][] cost = {
						{1, 2, 3},
		                {4, 8, 2},
		                {1, 5, 3}
		               };*/
		
	}

}



