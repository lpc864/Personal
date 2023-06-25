package divide_and_conquer;

import java.util.Comparator;

public class MergeSort_Generic {

	public static <T> void combinar(T[] coleccion, int inicio, int mitad, int fin, Comparator<T> comparador) {
		int tamanoColeccionIzquierda = (mitad - inicio) + 1;
		int tamanoColeccionDerecha = (fin - (mitad + 1)) + 1;

		T[] coleccionIzquierda = (T[]) new Object[tamanoColeccionIzquierda];
		T[] coleccionDerecha = (T[]) new Object[tamanoColeccionDerecha];

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
			if (comparador.compare(coleccionIzquierda[i], coleccionDerecha[j]) < 0) {
				coleccion[k] = coleccionIzquierda[i];
				i++;
			} else {
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

	public static <T> void mergeSort(T[] coleccion, int inicio, int fin, Comparator<T> comparador) {
		if (inicio < fin) {
			int mitad = (inicio + fin) / 2;
			mergeSort(coleccion, inicio, mitad, comparador);
			mergeSort(coleccion, mitad + 1, fin, comparador);
			combinar(coleccion, inicio, mitad, fin, comparador);
		}
	}

	public static void main(String[] args) {
	        Integer[] arr = {5, 2, 8, 1, 9};
	        // Comparador por defecto (orden ascendente)
	        Comparator<Integer> comparador = Integer::compareTo; 
	        mergeSort(arr, 0, arr.length - 1, comparador);

	        // Imprimir el arreglo ordenado
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
}
