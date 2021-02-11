package myGraph;

import java.util.*;

public class WeightedGraph {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter vertices: ");
        int vertices = sc.nextInt();
        Graphh graph = new Graphh(vertices);
        System.out.print("Enter edges: ");
        int edges = sc.nextInt();
        for(int i=0; i<edges; i++) {
        	System.out.print("Enter details of edge no "+(i+1)+" (source, destination, weight): ");
        	int source = sc.nextInt();
        	int destination = sc.nextInt();
        	int weight = sc.nextInt();
        	graph.addEgde(source, destination, weight);
        }
        graph.printGraph();
    }

}

class Edge {
    int source;
    int destination;
    int weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graphh {
    int vertices;
    LinkedList<Edge> [] adjacencylist;

    @SuppressWarnings("unchecked")
	Graphh(int vertices) {
        this.vertices = vertices;
        adjacencylist = new LinkedList[vertices];
        for (int i = 0; i <vertices ; i++) {
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEgde(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjacencylist[source].addFirst(edge); 
    }

    public void printGraph(){
        for (int i = 0; i <vertices ; i++) {
            LinkedList<Edge> list = adjacencylist[i];
            for (int j = 0; j <list.size() ; j++) {
                System.out.println("vertex-" + i + " is connected to " +
                        list.get(j).destination + " with weight " +  list.get(j).weight);
            }
        }
    }
}
