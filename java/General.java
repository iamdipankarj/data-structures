//import java.util.*;

public class General {
	
	static boolean isMazeSolvable(char[][] maze) {		
		int x = 0, y = 0, startX = -1, startY = -1;
		
		for (x = 0; x < 8; x++) {
			for(y = 0; y < 8; y++) {
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
				
		// If we did find start exploring from that point
		return exploreMaze(maze, startX, startY, visited);
	}
	
	static boolean exploreMaze(char[][] maze, int x, int y, boolean[][] visited) {
		
		// base case
		if (y > 7 || y < 0 || x < 0 || x > 7) return false;
		visited[x][y] = true;
		if (maze[x][y] == '*') return false;
		if (maze[x][y] == 'E') return true;

		if ( ! visited[x][y-1] && exploreMaze(maze, x, y-1, visited) ) return true;
		if ( ! visited[x][y+1] && exploreMaze(maze, x, y+1, visited) ) return true;
		if ( ! visited[x-1][y] && exploreMaze(maze, x-1, y, visited) ) return true;
		if ( ! visited[x+1][y] && exploreMaze(maze, x+1, y, visited) ) return true;
		
		return false;
	}

	public static void main(String[] args) {
		
	}

}



