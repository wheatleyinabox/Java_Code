package assignment4;

public class GraphDriver {

	public static void main(String[] args)
	{
		AdjacencyListGraph graph = new AdjacencyListGraph();
		
		graph.addNode(new Node('A')); // 0
		graph.addNode(new Node('B')); // 1
		graph.addNode(new Node('C')); // 2
		graph.addNode(new Node('D')); // 3
		graph.addNode(new Node('E')); // 4
		graph.addNode(new Node('F')); // 5
		graph.addNode(new Node('G')); // 6
		graph.addNode(new Node('H')); // 7
		graph.addNode(new Node('I')); // 8
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		
		graph.addEdge(1, 4);
		
		graph.addEdge(2, 1);
		
		graph.addEdge(3, 6);
		
		graph.addEdge(4, 5);
		graph.addEdge(4, 7);
		
		graph.addEdge(5, 2);
		graph.addEdge(5, 7);
		
		graph.addEdge(6, 7);
		
		graph.addEdge(7, 8);
		
		graph.addEdge(8, 5);
		
		
		System.out.println("-= ENTIRE GRAPH =-");
		graph.print();
		
		System.out.println();
		
		System.out.println("-= VERTEX E =-");
		graph.print(graph.neighbor(4), new Node('E'));
	}

}
