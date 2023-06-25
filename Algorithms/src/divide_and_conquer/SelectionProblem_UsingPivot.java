package divide_and_conquer;

public class SelectionProblem_UsingPivot {

	public static void swap(int[] coleccion, int i, int j) {
		int temporal = coleccion[i];
		coleccion[i] = coleccion[j];
		coleccion[j] = temporal;
	}

	public static int reorganiza(int[] coleccion, int inicio, int fin) {
		int pivot = coleccion[fin];
		int i = inicio - 1;

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
		int right_pivot_index;
		do {

			right_pivot_index = reorganiza(coleccion, inicio, fin);

			if (indexElement < right_pivot_index) {
				fin = right_pivot_index - 1;
			} else if (indexElement > right_pivot_index) {
				inicio = right_pivot_index + 1;
			}

		} while (right_pivot_index != indexElement);

		return coleccion[right_pivot_index];
	}

	public static void main(String[] args) {
		int[] arr = { 55, 88, 22, 66, 44, 11, 33, 77, 66 };
		int number = seleccion(arr, 0, arr.length - 1, 2);
		System.out.println(number);
		
		
	}
}
