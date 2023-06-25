package greedy;

public class Prim {
	
	public static void printARCMPrim (int[][] grafo, int[]padres) {
		int tamano = padres.length;
		int contador = 0;
		
		for (int i = 0; i < tamano; i++) {
			int distancia = grafo[i][padres[i]];
			if (distancia != 0) {
				System.out.println(padres[i] + " - " + i + "     ==>    " + distancia);
				contador += distancia;
			}
		}
		
		System.out.println("\nEl peso total es: " + contador);
	}
	
	public static int minDistanciaPadre(int numeroVertices, int[]distanciasPadres, boolean[]haSidoProcesado) {
		int minDistancia = Integer.MAX_VALUE;
		int minIndexVertice = -1;
		for (int i = 0; i < numeroVertices; i++) {
			if (!haSidoProcesado[i] && distanciasPadres[i] < minDistancia) {
				minDistancia = distanciasPadres[i];
				minIndexVertice = i;
			}
		}
		return minIndexVertice;
	}
	
	//Se considerara un grafo numerado desde 0 siguiendo un orden ascendente
	//Como resultado, indexVerticeFuente es considerado el propio verticeFuente
	//Si el grafo fuera numerado desde 1 siguiendo un orden ascendete, se tiene que verticeFuente = indexVerticeFuente + 1
	public static void prim(int[][] grafo) { 
		//Tener en cuenta que cuando se declara y se define el tamaño de una estructura de datos estatica (coleccion, matriz...) 
		//sus valores se inicializan a 0 (Cuando la estructura almacena datos de tipo boolean sus valores se inicializan a false)
		int numeroVertices = grafo.length;
		int indexVerticeFuente = (int) (Math.random() * numeroVertices);
		int[] padres = new int[numeroVertices];
		int[] distanciasPadres = new int[numeroVertices];
		boolean[] haSidoProcesado = new boolean[numeroVertices];
		
		padres[indexVerticeFuente] = indexVerticeFuente;
		distanciasPadres[indexVerticeFuente] = 0;
		
		for (int i = 0; i < numeroVertices; i++) {
			if (i != indexVerticeFuente) {
				padres[i] = -1;
				distanciasPadres[i] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < numeroVertices - 1; i++) {
			int v = minDistanciaPadre(numeroVertices, distanciasPadres, haSidoProcesado);
			//Por definicion, el ARCM solo se encuentra en grafos no orientados, es decir, un vertice siempre sera adyacente a otro
			//Por tanto, es imposible que v[1] sea -1
			haSidoProcesado[v] = true;
			//v es padre de ciertos j. Lo apuntamos
			for (int j = 0; j < numeroVertices; j++) {
				if (!haSidoProcesado[j] && grafo[v][j] != 0 && grafo[v][j] < distanciasPadres[j]) {
					padres[j] = v;
					distanciasPadres[j] = grafo[v][j];
				}
			}
		}
		
		System.out.println("Indice fuente seleccionado: " + indexVerticeFuente + "\n");
		System.out.println("ARCM:\n");
		System.out.println("Vertices       Pesos");
		printARCMPrim(grafo, padres);
	}

	public static void main(String[] args) {
		int grafo[][] = new int [][]
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
		
		prim(grafo);
	}
}
