package assignment4;

import java.util.ArrayList;
import java.util.LinkedList;

class Node
{
	private char data;
	
	Node(char data)
	{
		this.data = data;
	}
	
	public char getData()
	{
		return data;
	}
}

public class AdjacencyListGraph 
{
	private ArrayList<LinkedList<Node>> adjList;
	
	AdjacencyListGraph()
	{
		adjList = new ArrayList<>();
		
	}
	
	public void addNode(Node node)
	{
		LinkedList<Node> currentList = new LinkedList<>();
		currentList.add(node);
		adjList.add(currentList);
	}
	public void addEdge(int i, int j)
	{
		LinkedList<Node> currentList = adjList.get(i);
		Node jNode = adjList.get(j).get(0);
		currentList.add(jNode);
	}
	
	public Node[] neighbor(int head)
	{
		LinkedList<Node> currentList = adjList.get(head);
		int size = currentList.size();
		Node[] neighbors = new Node[size];
		for (int i = 0; i < neighbors.length; i++)
		{
			neighbors[i] = currentList.get(i);
		}
		return neighbors;
	}
	
	public void print()
	{
		for (LinkedList<Node> currentList : adjList)
		{
			for (Node node : currentList)
			{
				System.out.print(node.getData() + " -> ");
			}
			System.out.println();
		}
	}
	public void print(Node[] neighbors, Node head)
	{
		System.out.print("Neighbors of " + head.getData() + ": ");
		for (Node node : neighbors)
		{
			System.out.print(node.getData() + " -> ");
		}
		System.out.println();
	}
}