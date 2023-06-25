package dynamic_programming;

import javax.management.RuntimeErrorException;

public class BellmanFord {

	private static final int INF = Integer.MAX_VALUE;

	public static void bellmanFord(int[][] grafo, int verticeFuente) {
		int numeroVertices = grafo.length;
		int[] distancias = new int[numeroVertices];
		int[] verticesPrevios = new int[numeroVertices];

		// Consideramos un grafo numero ascendentemente desde 0
		// Por dicho motivo, verticeFuente es el propio indice del verticeFuente
		distancias[verticeFuente] = 0;
		verticesPrevios[verticeFuente] = -1;

		for (int i = 0; i < numeroVertices; i++) {
			if (i != verticeFuente) {
				distancias[i] = INF;
				verticesPrevios[i] = -1;
			}
		}

		for (int i = 0; i < numeroVertices - 1; i++) {
			for (int j = 0; j < numeroVertices; j++) {
				for (int k = 0; k < numeroVertices; k++) {
					// Compruebo si es una arista
					if (grafo[j][k] != INF) {
						// Encuentro el camino minimo
						if (distancias[j] != INF && distancias[j] + grafo[j][k] < distancias[k]) {
							distancias[k] = distancias[j] + grafo[j][k];
							verticesPrevios[k] = j;
						}
					}
				}
			}
		}

		for (int j = 0; j < numeroVertices; j++) {
			for (int k = 0; k < numeroVertices; k++) {
				// Compruebo si es una arista
				if (grafo[j][k] != INF) {
					// Encuentro el camino minimo
					if (distancias[j] != INF && distancias[j] + grafo[j][k] < distancias[k]) {
						throw new RuntimeException("Ciclo negativo");
					}
				}
			}
		}

		System.out.println("Vertice fuente");
		System.out.println("--------------\n");
		System.out.println(verticeFuente + "\n");

		System.out.println("Vector de distancias");
		System.out.println("--------------------\n");

		for (int i = 0; i < numeroVertices; i++) {
			System.out.println(i + " --> " + distancias[i]);
		}

		System.out.println("\nVector de vertices previos");
		System.out.println("----------------------------");

		for (int i = 0; i < numeroVertices; i++) {
			System.out.println(i + " --> " + verticesPrevios[i]);
		}

	}

	public static void main(String[] args) {
/*	
	   int graph[][] = {
						{ INF,  -1,   4, INF, INF },
		        		{ INF, INF,   3,   2,   2 },
		        		{ INF, INF, INF, INF, INF },
		        		{ INF,   1,   5, INF, INF },
		        		{ INF, INF, INF,  -3, INF } }; 
*/	

				int graph[][] = {
						{   0,   6, INF, INF,   7 },
		        		{ INF,   0,   5,  -4, INF },
		        		{ INF,  -2,   0, INF, INF },
		        		{   2, INF,   7,   0, INF },
		        		{ INF,   8,  -3,   9,   0 } };

/*
				int graph[][] = {
						{ INF,   4, INF, INF,   2 },
		        		{ INF, INF,   2,   3,   3 },
		        		{ INF, INF, INF, INF, INF },
		        		{ INF, INF,  -5, INF, INF },
		        		{ INF,   1,   4,   5, INF } };
*/
/*
				int graph[][] = {
						{ INF,   2,   2, INF, INF },
		        		{ INF, INF, INF,   3, INF },
		        		{ INF, INF, INF,   6,   4 },
		        		{ INF, INF, INF, INF, INF },
		        		{ INF, INF, INF,  -5, INF } };
*/		
/*
				int graph[][] = {
						{ INF,  -5, INF, INF, INF },
		        		{ INF, INF,   1, INF, INF },
		        		{ INF, INF, INF,   4, INF },
		        		{ INF, INF, INF, INF,   1 },
		        		{  -7, INF, INF, INF, INF } };
*/
/*
				int graph[][] = {
						{ INF, INF, INF, INF,   2, INF, INF, INF },
						{   1, INF,   1, INF, INF, INF, INF, INF },
						{ INF, INF, INF,   3, INF, INF, INF, INF },
						{ INF, INF, INF, INF,  -1, INF, INF, INF },
						{ INF,  -2, INF, INF, INF, INF, INF, INF },
						{  -4, INF, INF, INF,  -1, INF, INF, INF },
						{ INF, INF, INF, INF, INF,   1, INF, INF },
						{  10, INF, INF, INF, INF, INF,   8, INF }, };
*/
		
		bellmanFord(graph, 0);
	}
}
