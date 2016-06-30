public class Knight {
	
	static boolean isSafe(int x, int y, int[][] maze) {
		return ( x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == -1 ) ? true : false;
	}
	
	static void solve(int[][] maze, int n) {
		
		// The available moves a knight can make
		int[] xMove = {  2, 1, -1, -2, -2, -1,  1,  2 };
	    int[] yMove = {  1, 2,  2,  1, -1, -2, -2, -1 };
	    
	    // The knight is initially at the first block
	    maze[0][0] = 0;
	    
	    // Start from 0,0 position to solve the problem
	    solveHelper(0, 0, 1, maze, xMove, yMove, n);
	}
	
	static boolean solveHelper(int x, int y, int movei, int[][] maze, int[] xMove, int[] yMove, int n) {
		
		// Declare next position holder variable
		int next_x, next_y;
		
		// Check for bounds
		if (movei == n*n) return true;
		
		// Try all moves from the current co ordinate
		for (int k = 0; k < 8; k++) {
			
			next_x = x + xMove[k];
			next_y = y + yMove[k];
			// Check if we can move to the next position
			if ( isSafe(next_x, next_y, maze) ) {
				maze[next_x][next_y] = movei;
				
				if ( solveHelper(next_x, next_y, movei+1, maze, xMove, yMove, n) == true ) {
					return true;
				} else {
					maze[next_x][next_y] = -1;
				} 
			}
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] maze = {
						{-1,-1,-1,-1,-1},
						{-1,-1,-1,-1,-1},
						{-1,-1,-1,-1,-1},
						{-1,-1,-1,-1,-1},
						{-1,-1,-1,-1,-1}
					   };
		solve(maze, 5);
		Maze.printMatrix(maze);
	}

}
