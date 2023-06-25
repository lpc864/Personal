package divide_and_conquer;

public class SelectionProblem_DyV {
	
	public static void swap (int[]coleccion, int i, int j) {
		int temporal = coleccion[i];
		coleccion[i] = coleccion[j];
		coleccion[j] = temporal;
	}
	
	public static int reorganiza(int[] coleccion, int inicio, int fin) {
		int pivot = coleccion[fin];
		int i = inicio - 1; //Indice del ultimo elemento inferior al pivote
		
		for (int j = inicio; j <= fin - 1; j++) {
			if (coleccion[j] < pivot) {
				i++;
				swap(coleccion, i, j);
			}
		}
		swap(coleccion, i + 1, fin);
		return i + 1;
	}

	public static int seleccion(int[] coleccion, int inicio, int fin, int indexElement) {
		
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
	
	private static int seleccion (int[] coleccion, int indexElement) {
		return seleccion(coleccion, 0, coleccion.length - 1, indexElement);
	}
	
	public static void main(String[] args) {
		int [] arr = {55, 88, 22, 66, 44, 11, 33, 77, 66};
		System.out.println(seleccion(arr, 4));
	}
}
