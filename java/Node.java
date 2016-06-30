import java.util.*;

public class Node {	
	public String data;
	public State state;
	public LinkedList<Node> adjacent;
	
	public Node(String data) {
		this.data = data;
		this.adjacent = new LinkedList<>();
		this.state = State.unvisited;
	}
	
	public Node addAdjacentNode(Node node) {
		this.adjacent.add(node); // Directed graph
//		node.adjacent.add(this); // Undirected graph
		return this;
	}
	
	public LinkedList<Node> getAdjacent() {
		return adjacent;
	}
}