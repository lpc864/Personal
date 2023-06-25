package dynamic_programming;

public class Floyd_Warshall {

	public static final int INF = Integer.MAX_VALUE;
	
	public static void printSolution(int[][] distancias, int[][]verticesPrevios) {
		int numeroVertices = distancias.length;
		for (int verticeSeleccionado = 0; verticeSeleccionado < numeroVertices; verticeSeleccionado++) {
			System.out.println("Vertice " + verticeSeleccionado);
			System.out.println("---------");
			System.out.println();
			for (int i = 0; i < numeroVertices; i++) {
				if (i != verticeSeleccionado) continue;
				for (int j = 0; j < numeroVertices; j++) {
					if (distancias[i][j] != INF) {
						System.out.println("From " + i + " To " + j + " the distance is " + distancias[i][j] + " (Previous vertex is " + verticesPrevios[i][j] + ")");
					} else {
						System.out.println("From " + i + " To " + j + " the distance is INF (Previous vertex is " + verticesPrevios[i][j] + ")");
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void floyd_warshall(int[][] grafo) {
		int numeroVertices = grafo.length;
		int[][]distancias = new int[numeroVertices][numeroVertices];
		int[][]verticesPrevios = new int[numeroVertices][numeroVertices];
		
		//Inicializo las matrices.
		//A diferencia de algoritmos anteriores, la matriz que se pasa define de por si dos vertices
		//son adyacentes de forma que si no lo son, su arista vale INF; si lo son, vale su valor 
		//correspondiente; y si es con respecto a el mismo, vale cero
		for (int i = 0; i < numeroVertices; i++) {
			for (int j = 0; j < numeroVertices; j++) {
				int distancia = grafo[i][j];
				distancias[i][j] = distancia;
				verticesPrevios[i][j] = (distancia != INF) ? i : -1;
			}
		}
		
		//Nos basamos en el concepto de vertice intermedio para ir completando las matrices
		//Basicamente, nos preguntamos si la distancia de un vertice i a un vertice j puede ser acortado pasando
		//previamente por un vertice intermedio.
		//Se trata de un algoritmo de programacion dinamica porque se emplean estructura de datos para evitar realizar
		//calculos previamente realizados
		//verticeFuente ==> i
		//verticeIntermedio ==> k
		//verticeDestino ==> j
		//Se ha puesto a condicion de ik < INF && kj < INF porque si ambos son infinitos, en teoria, infinito mas infinito es infinito, pero en Java
		//se pone -infinito, lo cual nos arruinaria todo nuestro codigo. Una forma de solucionarlo sin el condicial es definir INF como MAX_Integer/2, asi la suma
		//si daria "Infinito" y no daria problemas
		for(int k = 0; k < numeroVertices; k++) {
			for (int i = 0; i < numeroVertices; i++) {
				for (int j = 0; j < numeroVertices; j++) {
					int ik = distancias[i][k];
					int kj = distancias[k][j];
					int ij = distancias[i][j];
					if (ik < INF && kj < INF && (ik + kj) < ij) {
						distancias[i][j] = ik + kj;
						verticesPrevios[i][j] = k;
					}
				}
			}
		}
		
		printSolution(distancias, verticesPrevios);
		
	}

	public static void main(String[] args) {
		int grafo[][] = { {   0,   4,  11, INF, INF },
        				  { INF,   0, INF,   6,   2 },
        				  { INF,   3,   0,   6, INF },
        				  { INF, INF, INF,   0, INF },
        				  { INF, INF,   5,   3,   0 } };
		
		floyd_warshall(grafo);
	}
}
