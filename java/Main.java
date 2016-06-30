public class Main {	
	
	public static void main(String[] args) {
		
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		Node F = new Node("F");
		Node G = new Node("G");
		Node H = new Node("H");
		Node I = new Node("I");
		Node J = new Node("J");
		
		Graph g = new Graph();
		g.nodes.add(A);
		g.nodes.add(B);
		g.nodes.add(C);
		g.nodes.add(D);
		g.nodes.add(E);
		g.nodes.add(F);
		g.nodes.add(G);
		g.nodes.add(H);
		g.nodes.add(I);
		g.nodes.add(J);
		
		A
			.addAdjacentNode(B)
			.addAdjacentNode(C)
			.addAdjacentNode(E);
		
		B.addAdjacentNode(F);
		F.addAdjacentNode(I);
		I.addAdjacentNode(J);
		
		J
			.addAdjacentNode(E)
			.addAdjacentNode(H);
		
		C
			.addAdjacentNode(G)
			.addAdjacentNode(H);

		H.addAdjacentNode(D);
		
		Graph.bfs(g, A);
		
		Node john = new Node("John");
		Node jane = new Node("Jane");
		Node tuna = new Node("Tuna");
		Node emily = new Node("Emily");
		Node kenze = new Node("Kenze");
		Node dayna = new Node("Dayna");
		
		Graph p = new Graph();
		p.nodes.add(john);
		p.nodes.add(jane);
		p.nodes.add(tuna);
		p.nodes.add(emily);
		p.nodes.add(kenze);
		p.nodes.add(dayna);
		
		john
			.addAdjacentNode(jane)
			.addAdjacentNode(tuna);
		
		jane.addAdjacentNode(dayna);
		tuna.addAdjacentNode(emily);
		emily.addAdjacentNode(dayna);
		kenze.addAdjacentNode(john);
		dayna.addAdjacentNode(kenze);
	
		
	}
}






