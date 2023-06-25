package divide_and_conquer;

public class QuickSort {

	public static void swap(int[] coleccion, int i, int j) {
		int temporal = coleccion[i];
		coleccion[i] = coleccion[j];
		coleccion[j] = temporal;
	}

	public static int reorganiza(int[] coleccion, int inicio, int fin) {
		int pivot = coleccion[fin];

		// index of the last element less than the pivot
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

	public static void quickSort(int[] coleccion, int inicio, int fin) {
		if (inicio < fin) {
			int right_pivot_index = reorganiza(coleccion, inicio, fin);

			quickSort(coleccion, inicio, right_pivot_index - 1);
			quickSort(coleccion, right_pivot_index + 1, fin);

		}
	}

	public static void printArray(int[] coleccion) {
		for (int i = 0; i < coleccion.length; i++) {
			System.out.print(coleccion[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7, 10, 4, 9, 15, 1 };

		System.out.println("Given Array");
		printArray(arr);

		quickSort(arr, 0, arr.length - 1);
		
		System.out.println("\nSorted array");
		printArray(arr);
	}

}
