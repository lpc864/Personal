package divide_and_conquer;

import java.util.Arrays;

public class SelectionProblem_DyV_Improved {
	
	public static void swap (int[] coleccion, int i, int j) {
		int temporal = coleccion[i];
		coleccion[i] = coleccion[j];
		coleccion[j] = temporal;
	}
	
	public static int reorganiza(int[] coleccion, int inicio, int fin) {
		int pivot = coleccion[fin];
		int i = inicio - 1; 
		
		for (int j = inicio; j < fin; j++) {
			if (coleccion[j] < pivot) {
				i++;
				swap(coleccion, i, j);
			}
		}
		swap(coleccion, i + 1, fin);
		return i + 1;
	}
	
	public static int findPseudoMediana (int[] coleccion, int inicio, int fin) {
		Arrays.sort(coleccion, inicio, fin + 1);
		int medianaIndex  = (fin + inicio) / 2;
		return coleccion[medianaIndex];

	}
	
	public static int seleccion(int[] coleccion, int inicio, int fin, int indexElement) {
		if (indexElement >= inicio && indexElement <= fin) {
			
			int coleccion_length = (fin - inicio) + 1;
			int tamanoGrupo = 5;
			int numeroGrupos = (coleccion_length + 4) / tamanoGrupo;
			int[] mediana = new int[numeroGrupos];
			int mediana_lenght = mediana.length; //Se puede eliminar: en el bucle for se sustituye por numeroGrupos
			int i; // Indica el grupo sobre el cual me encuentro iterando

			for (i = 0; i < mediana_lenght; i++) {

				int inicioSubarreglo = inicio + (i * 5);
				int finSubarreglo = (i != mediana_lenght - 1) ? inicioSubarreglo + 4 : (inicioSubarreglo + (coleccion_length % 5)) - 1;
		
				mediana[i] = findPseudoMediana(coleccion, inicioSubarreglo, finSubarreglo);

			}
			
			int medianaDeMedianas = (mediana_lenght == 1) ? mediana[0] : findPseudoMediana(mediana, 0, mediana_lenght - 2); 
			
			int j;
			for (j = inicio; j < fin; j++) {
				if (coleccion[j] == medianaDeMedianas) {
					break;
				}
			}
			
			swap(coleccion, j, fin);
			
			int right_pivot_index = reorganiza(coleccion, inicio, fin);
			
			if (indexElement < right_pivot_index) {
				return seleccion(coleccion, inicio, right_pivot_index - 1, indexElement);
			}
			else if (indexElement > right_pivot_index) {
				return seleccion(coleccion, right_pivot_index + 1, fin, indexElement);
			}
			else {
				return coleccion[right_pivot_index];
			}
			
		}

		return Integer.MAX_VALUE;
	}

	private static int seleccion(int[] coleccion, int indexElement) {
		return seleccion(coleccion, 0, coleccion.length - 1, indexElement);
	}

	public static void main(String[] args) {
		int [] arr = {55, 88, 22, 66, 44, 11, 33, 77, 66};
		for (int i = 0; i <= 8; i++) {
			System.out.println(seleccion(arr, i));
		}
		
	}
}
