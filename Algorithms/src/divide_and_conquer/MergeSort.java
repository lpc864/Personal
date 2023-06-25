package divide_and_conquer;

public class MergeSort {
	
	public static void printColeccion(int[] coleccion) {
		for (int i = 0; i < coleccion.length; i++) {
			System.out.print(coleccion[i] + " ");
		}
		System.out.println();
	}
	
	public static void combinar (int coleccion[], int inicio, int mitad, int fin) {
		int tamanoColeccionIzquierda = (mitad - inicio) + 1;
		int tamanoColeccionDerecha = (fin - (mitad + 1)) + 1;
		
		int[]coleccionIzquierda = new int[tamanoColeccionIzquierda];
		int[]coleccionDerecha = new int[tamanoColeccionDerecha];
		
		
		int iterador = inicio;
		
		for (int i = 0; i < tamanoColeccionIzquierda; i++) {
			coleccionIzquierda[i] = coleccion[iterador];
			iterador++;
		}
		
		for (int j = 0; j < tamanoColeccionDerecha; j++) {
			coleccionDerecha[j] = coleccion[iterador];
			iterador++;
		}
		
		int i = 0, j = 0, k = inicio;
		
		while (i < tamanoColeccionIzquierda && j < tamanoColeccionDerecha) {
			if (coleccionIzquierda[i] < coleccionDerecha[j]) {
				coleccion[k] = coleccionIzquierda[i];
				i++;
			}
			else {
				coleccion[k] = coleccionDerecha[j];
				j++;
			}
			k++;
		}
		
		while (i < tamanoColeccionIzquierda) {
			coleccion[k] = coleccionIzquierda[i];
			i++;
			k++;
		}
		
		while (j < tamanoColeccionDerecha) {
			coleccion[k] = coleccionDerecha[j];
			j++;
			k++;
		}
		
	}
	
	public static void mergeSort(int[] coleccion, int inicio, int fin) {
		if (inicio < fin) {
			int mitad = (inicio + fin) / 2;
			mergeSort(coleccion, inicio, mitad);
			mergeSort(coleccion, mitad + 1, fin);
			combinar(coleccion, inicio, mitad, fin);
		}
	}
	
	
	public static void main(String[] args) {
		int arr[] = { 12, 11, 13, 5, 6, 7, 10, 4, 9 };
		  
        System.out.println("Given Array");
        printColeccion(arr);
  
        mergeSort(arr, 0, arr.length - 1);
  
        System.out.println("\nSorted array");
        printColeccion(arr);
	}
}
