//import java.util.*;

public class Maze {
	
	static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void printMatrix(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static boolean isMazeSolvable(char[][] maze) {		
		int startX = -1, startY = -1;
		
		for (int x = 0; x < 8; x++) {
			for(int y = 0; y < 8; y++) {
				if (maze[x][y] == 'S') {
					startX = x;
					startY = y;
				}
			}
		}
		
		// If starting point unavailable, maze unsolvable
		if (startX == -1 || startY == -1) return false;
		
		// Hashtable for keeping track of visited cells
		boolean[][] visited = new boolean[8][8];
				
		// If we did find then start exploring from that point
		return exploreMaze(maze, startX, startY, visited);
	}
	
	static boolean exploreMaze(char[][] maze, int x, int y, boolean[][] visited) {
		
		// Check for bounds
		if (y > 7 || y < 0 || x < 0 || x > 7) return false;

		// If there is a wall or the cell is already visited
		if (maze[x][y] == '*' || visited[x][y]) return false;
		
		// If this is E we're done.
		if (maze[x][y] == 'E') return true;
		
		// If this cell is not visited, make it visited.
		if ( ! visited[x][y] ) visited[x][y] = true;
		
		if ( exploreMaze(maze, x, y-1, visited) ) return true; // Search up
		if ( exploreMaze(maze, x, y+1, visited) ) return true; // Search down
		if ( exploreMaze(maze, x-1, y, visited) ) return true; // Search left
		if ( exploreMaze(maze, x+1, y, visited) ) return true; // Search right
		
		return false;
	}
	
	static void floodfill(int[][] screen, int x, int y, int newC) {
		int prevC = screen[x][y];
		floodfillHelper(screen, x, y, prevC, newC);
	}
	
	static void floodfillHelper(int[][] screen, int x, int y, int prevC, int newC) {
		// Base cases
		if ( x < 0 || x >= 8 || y < 0 || y >= 8 ) return;
		if ( screen[x][y] != prevC ) return;
		
		// Replace color
		screen[x][y] = newC;
		
		// Recurse for all directions
		floodfillHelper(screen, x+1, y, prevC, newC); // go right
		floodfillHelper(screen, x-1, y, prevC, newC); // go left
		floodfillHelper(screen, x, y+1, prevC, newC); // go up
		floodfillHelper(screen, x, y-1, prevC, newC); // go down
	}

	public static void main(String[] args) {
		
		char[][] maze = {
						{'S','*','E','_','_','_','*','*'},
						{'_','*','*','*','*','_','*','*'},
						{'_','*','*','*','*','_','*','*'},
						{'_','*','_','_','_','_','*','*'},
						{'_','*','_','*','*','*','*','*'},
						{'_','*','_','*','*','*','*','*'},
						{'_','*','_','*','*','*','*','*'},
						{'_','_','_','*','*','*','*','*'}
						};
		
		 int[][] screen = {
						 {1, 1, 1, 1, 1, 1, 1, 1},
		                 {1, 1, 1, 1, 1, 1, 0, 0},
		                 {1, 0, 0, 1, 1, 0, 1, 1},
		                 {1, 2, 2, 2, 2, 0, 1, 0},
		                 {1, 1, 1, 2, 2, 0, 1, 0},
		                 {1, 1, 1, 2, 2, 2, 2, 0},
		                 {1, 1, 1, 1, 1, 2, 1, 1},
		                 {1, 1, 1, 1, 1, 2, 2, 1},
		                 };
		 
		 floodfill(screen, 4, 4, 3);
		 printMatrix(screen);
		
		System.out.println(isMazeSolvable(maze));
		
	}

}