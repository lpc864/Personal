package greedy;

public class Kruskal {
	
	public static void union(int[] padres, int verticePadre, int verticeHijo) {
		int verticeA = find(padres, verticePadre);
		int verticeB = find(padres, verticeHijo);
		
		padres[verticeB] = verticeA;
	}
	
	
	public static int find (int[] padres, int vertice) {
		while (padres[vertice] != vertice) {
			vertice = padres[vertice];
		}
		return vertice;
	}
	
	public static void kruskal (int[][] grafo) {
		int numeroVertices = grafo.length;
		int[] padres = new int[numeroVertices];
		
		//Inicialmente, cada vertice se considera un subgrafo de cero aristas dentro del grafo
		for (int i = 0; i < numeroVertices; i++) {
			padres[i] = i;
		}
		
		int mincost = 0;
		int edge_count = 0;
		
		//En cada iteracion se unen dos subgrafos
		//Restriccion: los vertices que se seleccionan deben tener, evidentemente, padres distintos
		for (int i = 0; i < numeroVertices - 1; i++) {
			//Inicialmente, se desconoce los vertices ha ser seleccionados como el peso de su arista
			int verticePadre = -1, verticeHijo = -1;
			int minimaDistancia = Integer.MAX_VALUE;
			//Itero sobre cada vertice encontrando su arista de menor peso
			//Restricciones: la indicada en la cabecera y ser la arista minima entre todas
			for (int j = 0; j < numeroVertices; j++) {
				for (int k = j + 1; k < numeroVertices; k++) {
					if (find(padres, j) != find(padres, k) && grafo[j][k] < minimaDistancia) {
						verticePadre = j;
						verticeHijo = k;
						minimaDistancia = grafo[j][k];
					}
				}
			}
			//Una vez encontrado, unimos los subgrafos
			union(padres, verticePadre, verticeHijo);	
			
		System.out.printf("Edge %d:(%d, %d) cost:%d \n", edge_count++, verticePadre, verticeHijo, minimaDistancia);
		mincost += minimaDistancia;
		}
		System.out.println(mincost);
	}

	public static void main(String[] args) {
		Integer INF = Integer.MAX_VALUE;
		int grafo[][] = new int[][] { { INF, 4, INF, INF, INF, INF, INF, 8, INF },
			{ 4, INF, 8, INF, INF, INF, INF, 11, INF },
			{ INF, 8, INF, 7, INF, 4, INF, INF, 2 },
			{ INF, INF, 7, INF, 9, 14, INF, INF, INF },
			{ INF, INF, INF, 9, INF, 10, INF, INF, INF },
			{ INF, INF, 4, 14, 10, INF, 2, INF, INF },
			{ INF, INF, INF, INF, INF, 2, INF, 1, 6 },
			{ 8, 11, INF, INF, INF, INF, 1, INF, 7 },
			{ INF, INF, 2, INF, INF, INF, 6, 7, INF } };
 
				   
		kruskal(grafo);
	}
}

