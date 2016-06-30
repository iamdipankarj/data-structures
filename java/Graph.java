import java.util.*;

public class Graph {
	public ArrayList<Node> nodes = new ArrayList<>();
	public ArrayList<Node> getNodes() { return nodes; }
	
	public static void bfs(Graph g, Node start) {
		LinkedList<Node> q = new LinkedList<>();
		
		for (Node u : g.getNodes()) {
			u.state = State.unvisited;
		}
		
		start.state = State.visited;
		q.add(start);
		
		Node u;
		
		while( ! q.isEmpty() ) {
			u = q.removeFirst();
			System.out.print(u.data + " ");
			
				for( Node v : u.getAdjacent() ) {
					if (v.state == State.unvisited ) {
						v.state = State.visited;
						q.add(v);
					}
				}
		}
	}
	
	public static boolean isConnected(Graph g, Node start, Node end) {	
		LinkedList<Node> q = new LinkedList<>();
		
		// Make all states unvisited
		for (Node u : g.getNodes()) {
			u.state = State.unvisited;
		}
		start.state = State.visiting;
		q.add(start);
		Node u;
		
		while( ! q.isEmpty() ) {
			u = q.removeFirst();
			if (u != null) {
				for (Node v : u.getAdjacent()) {
					if (v.state == State.unvisited) {
						if ( v == end ) {
							return true;
						} else {
							v.state = State.visiting;
							q.add(v);
						}
					}
				}
			}
			u.state = State.visited;
		}
		
		return false;
	}
	
	public static void dfsVisit(Graph g, Node u) {
		u.state = State.visited;
		System.out.print(u.data + " ");
		for( Node v : u.getAdjacent() ) {
			if ( v.state == State.unvisited ) {
				dfsVisit(g, v);
			}
		}
	}
	
	public static void dfs(Graph g) {
		for ( Node u : g.getNodes() ) {
			u.state = State.unvisited;
		}
		
		for ( Node u : g.getNodes() ) {
			if ( u.state == State.unvisited ) {
				dfsVisit(g, u);
			}
		}
	}
	
	public static boolean hasCycleUtil(Graph g, Node u, HashMap<Node, Boolean> table) {
		u.state = State.visited;
		table.put(u, true);
		for ( Node v : u.getAdjacent() ) {
			if ( v.state == State.unvisited ) {
				if ( hasCycleUtil(g, v, table) )
					return true;
			} else if ( table.containsKey(v) ) {
				return true;
			}
		}
		table.remove(u);
		return false;
	}
	
	public static boolean hasCycle(Graph g) {
		for ( Node u : g.getNodes() ) {
			u.state = State.unvisited;
		}
		
		HashMap<Node, Boolean> table = new HashMap<>();
		
		for ( Node u : g.getNodes() ) {
			if ( u.state == State.unvisited ) {
				if (hasCycleUtil(g, u, table) ) return true;
			}
		}
		return false;
	}
	
	public static void toposortUtil(Graph g, Node u, Stack<Node> s) {
		u.state = State.visited;
		for ( Node v : u.getAdjacent() ) {
			if ( v.state == State.unvisited ) {
				toposortUtil(g, v, s);
			}
		}
		s.push(u);
	}
	
	public static void toposort(Graph g) {
		Stack<Node> s = new Stack<>();
		for ( Node u :g.getNodes() ) {
			u.state = State.unvisited;
		}
		
		for ( Node u :g.getNodes() ) {
			if ( u.state == State.unvisited ) {
				toposortUtil(g, u, s);
			}
		}
		// Print contents of the stack
		while ( ! s.isEmpty() ) {
			System.out.print(s.pop().data + " ");
		}
	}
}



