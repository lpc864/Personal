package backtracking;

public class TSP {
	
	private static int vertexNumber;
	private static int[] solutionPath;
	private static boolean[] haveBeenVisited;
	private static int solutionPathCost;
	private static int[] actualPath;
	private static int actualPathCost;
	private static int minEdgeCost;
	
	private static void printTSP(int[] path, int vertexNumber, int actualPathCost) {
		System.out.println("Solution");
		System.out.println("--------");
		System.out.println();
		
		for (int i = 0; i < vertexNumber; i++) {
			System.out.print(path[i] + " --> ");
		}
		
		System.out.println(path[0]);
		System.out.println("The cost is " + actualPathCost);
	}
	
	public static int findMaxEdgeCost (int graph[][]) {
		int minEdgeCost = 0;
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[0].length; j++) {
				if (i != j && graph[i][j] != 0 && graph[i][j] < minEdgeCost) {
					minEdgeCost = graph[i][j];
				}
			}
		}
		
		return minEdgeCost;
	}
	
	//Literalmente, casi el mismo codigo de HamiltonianCycle solo que he añadido poda y ciertas 
	//mejoras para mejorar la eficiencia del pasado (P.E. haveBeenVisited)
	private static void TSP (int[][] graph, int vertexNumber, int[] actualPath, boolean[] haveBeenVisited, int pivot) {
		int pastVertex = actualPath[pivot - 1];
		
		//Base case
		if (pivot == vertexNumber) {
			if (graph[pastVertex][actualPath[0]] != 0 && (actualPathCost + graph[pastVertex][actualPath[0]])  < solutionPathCost) {
				solutionPath = actualPath.clone();
				solutionPathCost = actualPathCost + graph[pastVertex][actualPath[0]];
			}
		}
		
		//Recursive case
		for (int vertex = 1; vertex < vertexNumber; vertex++ ) {
			if (graph[pastVertex][vertex] != 0 && !haveBeenVisited[vertex]) {
				actualPath[pivot] = vertex;
				haveBeenVisited[vertex] = true;
				actualPathCost += graph[pastVertex][vertex];
				
				int estimatedCost = actualPathCost + ((vertexNumber - (pivot + 1)) * minEdgeCost);
				if (estimatedCost < solutionPathCost) {
					TSP(graph, vertexNumber, actualPath, haveBeenVisited, pivot + 1);
				}
				
				haveBeenVisited[vertex] = false;
				actualPathCost -= graph[pastVertex][vertex];
			}
		}
		
	
	}
	
	public static void TSP (int[][] graph) {
		vertexNumber = graph.length;
		solutionPath = new int[vertexNumber];
		solutionPathCost = Integer.MAX_VALUE;
		actualPath = new int[vertexNumber];
		actualPathCost = 0;
		haveBeenVisited = new boolean[vertexNumber];
		minEdgeCost = findMaxEdgeCost(graph);
		
		solutionPath[0] = 0;
		actualPath[0] = 0;
		haveBeenVisited[0] = true;
		for (int i = 1; i < vertexNumber; i++) {
			solutionPath[i] = -1;
			actualPath[i] = -1;
			haveBeenVisited[i] = false;
		}
		
		TSP(graph, vertexNumber, actualPath, haveBeenVisited, 1);
		
		if (solutionPath[1] == -1) {
			System.out.println("It doesn't exist solution");
			return;
		}
		
		printTSP(solutionPath, vertexNumber, solutionPathCost);
	}
	
	public static void main (String[] args) {
		int[][] graph = {
        		{    0, 2451,  713, 1018, 1631, 1374, 2408,  213, 2571,  875, 1420, 2145, 1972 },
        		{ 2451,    0, 1745, 1524,  831, 1240,  959, 2596,  403, 1589, 1374,  357,  579 },
        		{  713, 1745,    0,  355,  920,  803, 1737,  851, 1858,  262,  940, 1453, 1260 },
        		{ 1018, 1524,  355,    0,  700,  862, 1395, 1123, 1584,  466, 1056, 1280,  987 },
        		{ 1631,  831,  920,  700,    0,  663, 1021, 1769,  949,  796,  879,  586,  371 },
        		{ 1374, 1240,  803,  862,  663,    0, 1681, 1551, 1765,  547,  225,  887,  999 },
        		{ 2408,  959, 1737, 1395, 1021, 1681,    0, 2493,  678, 1724, 1891, 1114,  701 },
        		{  213, 2596,  851, 1123, 1769, 1551, 2493,    0, 2699, 1038, 1605, 2300, 2099 },
        		{ 2571,  403, 1858, 1584,  949, 1765,  678, 2699,    0, 1744, 1645,  653,  600 },
        		{  875, 1589,  262,  466,  796,  547, 1724, 1038, 1744,    0,  679, 1272, 1162 },
        		{ 1420, 1374,  940, 1056,  879,  225, 1891, 1605, 1645,  679,    0, 1017, 1200 },
        		{ 2145,  357, 1453, 1280,  586,  887, 1114, 2300,  653, 1272, 1017,    0,  504 },
        		{ 1972,  579, 1260,  987,  371,  999,  701, 2099,  600, 1162, 1200,  504,    0 }
        };
		
		TSP(graph);
	}
}
