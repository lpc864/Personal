package backtracking;

import java.util.TreeMap;

public class HamiltonianCycle {
	
	private static int vertexNumber;
	private static int[] path;
	private static TreeMap<Integer, int[]> allPath;
	private static int solutionsNumber;

	public static boolean isSafe(int[][] graph, int[] path, int pivot, int vertex) {
		//Are they adjacent?
		if (graph[path[pivot - 1]][vertex] == 0) return false;
		
		//Does the path already contain the vertex?
		for (int i = 0; i < pivot; i++) {
			if (path[i] == vertex) return false;
		}
		
		return true;
	}
	
	public static void printAllHamiltonianCycle() {
		System.out.println("Solution");
		System.out.println("--------");
		System.out.println();
		
		int i = 0;
		for (int[] paths : allPath.values()) {
			System.out.print((i+1) + ". ");
			for (int j = 0; j < paths.length; j++) {
				System.out.print(paths[j] + " --> ");
			}
			System.out.println(paths[0]);
			i++;
		}
	}
	
	private static void allHamiltonianCycle(int[][] graph, int vertexNumber, int[] path, int pivot) {
		//Base case
		if (pivot == vertexNumber) {
			if (graph[path[pivot - 1]][path[0]] != 0) {
				allPath.put(solutionsNumber++, path.clone());
			}
			return;
		}
		
		//Recursive case
		for (int vertex = 1; vertex < vertexNumber; vertex++) {
			if (isSafe(graph, path, pivot, vertex)) {
				path[pivot] = vertex;
				
				allHamiltonianCycle(graph, vertexNumber, path, pivot + 1);
			
				path[pivot] = -1;
			}
		}
	}
	
	public static void allHamiltonianCycle(int[][] graph) {
		vertexNumber = graph.length;
		path = new int[vertexNumber];	
		allPath = new TreeMap<Integer, int[]>();
		solutionsNumber = 0;
		
		path[0] = 0;
		for (int i = 1; i < vertexNumber; i++) {
			path[i] = -1;
		}
		
		allHamiltonianCycle(graph, vertexNumber, path, 1);
		
		if (allPath.isEmpty()) {
			System.out.println("It doesn't exist a Hamiltonian Cycle");
			return;
		}
		
		printAllHamiltonianCycle();
		
		
	}
	
	public static void printHamiltonianCycle(int[] path, int vertexNumber) {
		System.out.println("Solution");
		System.out.println("--------");
		System.out.println();
		
		for (int i = 0; i < vertexNumber; i++) {
			System.out.print(path[i] + " --> ");
		}
		
		System.out.println(path[0]);
	}
	
	private static boolean hamiltonianCycle(int[][] graph, int vertexNumber, int[] path, int pivot) {
		// Base case
		if (pivot == vertexNumber) {
			if (graph[path[pivot - 1]][path[0]] == 1) return true;
			return false;
		}
		
		// Recursive case
		for (int vertex = 1; vertex < vertexNumber; vertex++) {
			if (isSafe(graph, path, pivot, vertex)) {
				path[pivot] = vertex;
				
				if (hamiltonianCycle(graph, vertexNumber, path, pivot + 1)) return true;
				path[pivot] = -1;
			}
		}
		return false;
	}

	public static void hamiltonianCycle(int[][] graph) {
		vertexNumber = graph.length;
		path = new int[vertexNumber];

		path[0] = 0;
		for (int i = 1; i < vertexNumber; i++) {
			path[i] = -1;
		}

		if (!hamiltonianCycle(graph, vertexNumber, path, 1)) {
			System.out.println("The graph doesn't contain a hamiltonian cycle!");
			return;
		}

		printHamiltonianCycle(path, vertexNumber);

	}

	public static void main(String[] args) {
		int graph1[][] = {
				{0, 1, 0, 1, 0},
				{1, 0, 1, 1, 1},
				{0, 1, 0, 0, 1},
				{1, 1, 0, 0, 1},
				{0, 1, 1, 1, 0},
		};
		
		int graph2[][] = {
				{0, 1, 0, 1, 0},
				{1, 0, 1, 1, 1},
				{0, 1, 0, 0, 1},
				{1, 1, 0, 0, 0},
				{0, 1, 1, 0, 0},
		};
		
		//hamiltonianCycle(graph1);
		allHamiltonianCycle(graph2);
	}
}
