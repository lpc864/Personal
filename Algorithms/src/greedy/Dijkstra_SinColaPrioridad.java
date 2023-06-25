package greedy;

public class Dijkstra_SinColaPrioridad {
	
	
	private static void printPath (int verticeFuente, int verticeDestino, int[][]resultado) {
		if (verticeDestino == verticeFuente) {
			System.out.print(verticeFuente);
		} else {
			int verticeIntermediario = resultado[1][verticeDestino - 1];
			printPath(verticeFuente, verticeIntermediario, resultado);
			System.out.print(" --> " + verticeDestino);
		}
	}
	
	public static void printPathWeight (int verticeFuente, int verticeDestino, int[][]resultado) {
		int distanciaFuenteDestino = resultado[0][verticeDestino - 1];
		if (distanciaFuenteDestino == Integer.MAX_VALUE) {
			System.out.print("Desde el " + verticeFuente + " no se puede acceder al " + verticeDestino);
		}
		else {
			printPath(verticeFuente, verticeDestino, resultado);
			System.out.println(" ==> Peso: " + distanciaFuenteDestino);
		}
	}
	
	public static void printSolution(int verticeFuente, int[][]resultado) {
		int tamano = resultado[0].length;
		
		System.out.println("Vertice fuente");
		System.out.println("--------------\n");
		System.out.println(verticeFuente + "\n");
		
		System.out.println("Vector de distancias");
		System.out.println("--------------------\n");
		
		for (int i = 0; i < tamano; i++) {
			System.out.println((i+1) + " --> " + resultado[0][i]);
		}
		
		System.out.println("\nVector de vertices previos");
		System.out.println("----------------------------");
		
		for (int i = 0; i < tamano; i++) {
			System.out.println((i+1) + " --> " + resultado[1][i]);
		}
		
	}
	
	public static int[] minDistancia(int[]distancias, boolean[]haSidoProcesado) {
		int tamanoDistancias = distancias.length;
		int minimaDistancia = Integer.MAX_VALUE;
		int verticeMinimaDistancia = -1;
		for (int i = 0; i < tamanoDistancias; i++) {
			if (haSidoProcesado[i] != true && distancias[i] < minimaDistancia) {
				minimaDistancia = distancias[i];
				verticeMinimaDistancia = i + 1;
			}
		}
		return new int[] {minimaDistancia, verticeMinimaDistancia};
	}
	
	public static int[][] dijkstra (int[][] grafo, int verticeFuente) {
		int indexVertice = verticeFuente - 1;
		int numeroVertices = grafo.length;
		int[] distancias = new int[numeroVertices];
		int[] verticesPrevios = new int[numeroVertices];
		boolean[] haSidoProcesado = new boolean[numeroVertices];
		
		distancias[indexVertice] = 0;
		verticesPrevios[indexVertice] = verticeFuente;
		haSidoProcesado[indexVertice] = true;
		
		for (int i = 0; i < numeroVertices; i++) {
			if (i != indexVertice) {
				int distancia = grafo[indexVertice][i];
				distancias[i] = distancia != 0 ? distancia : Integer.MAX_VALUE;
				verticesPrevios[i] = distancia != 0 ? verticeFuente : -1;
				haSidoProcesado[i] = false;
			}
		}
		
		for (int i = 0; i < numeroVertices - 1; i++) {
			//Colección que almacena la distancia minima junto al vertice en si mismo
			int[] u = minDistancia(distancias, haSidoProcesado);
			int indexU = u[1] - 1;
			
			if (u[1] != -1) {
				haSidoProcesado[indexU] = true;
				//Actualizamos las distancias si fuera necesario
				for (int j = 0; j < numeroVertices; j++) {
					if (!haSidoProcesado[j] && grafo[indexU][j] != 0 && distancias[indexU] + grafo[indexU][j] < distancias[j]) {
						distancias[j] = distancias[indexU] + grafo[indexU][j];
						verticesPrevios[j] = u[1];
					}
				}
			}
		}
		
		int [][] resultado = new int[2][numeroVertices];
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < numeroVertices; j++) {
				resultado[i][j] = (i == 0) ? distancias[j] : verticesPrevios[j];
			}
		}
		
		printSolution(verticeFuente, resultado);
		
		return resultado;
		
	}
	
	public static void main(String[] args) {
		/*int grafo1[][] = new int [][]
				 		 { {0, 50, 30, 100, 10}, 
				 		   {0,  0,  0,   0,  0}, 
				 		   {0,  5,  0,   0,  0}, 
				 		   {0, 20, 50,   0,  0},
				 		   {0,  0,  0,  10,  0} };
		
		int [][] resultado = dijkstra(grafo1, 1);
		System.out.println();
		printPathWeight(1, 2, resultado);
		System.out.println();*/
		
		int grafo2[][] = new int [][]
		 		 { {0,  4,  0,  0,  0,  0,  0,  8, 0},   //0
				   {4,  0,  8,  0,  0,  0,  0, 11, 0},   //1
				   {0,  8,  0,  7,  0,  4,  0,  0, 2},   //2
				   {0,  0,  7,  0,  9, 14,  0,  0, 0},   //3
				   {0,  0,  0,  9,  0, 10,  0,  0, 0},   //4
				   {0,  0,  4, 14, 10,  0,  2,  0, 0},   //5
				   {0,  0,  0,  0,  0,  2,  0,  1, 6},   //6
				   {8, 11,  0,  0,  0,  0,  1,  0, 7},   //7
				   {0,  0,  2,  0,  0,  0,  6,  7, 0} }; //8
                 // 0   1   2   3   4   5   6   7  8
		
		int [][]resultado = dijkstra(grafo2, 1);
		System.out.println();
		//printPathWeight(1, 2, resultado);
		
	}
}
