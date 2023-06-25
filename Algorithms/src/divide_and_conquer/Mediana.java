package divide_and_conquer;

import java.util.Arrays;

public class Mediana {

	public static double encontrarMediana(int[] coleccion, int inicio, int fin, int indexElement) {

		if (coleccion.length == 0) {
			throw new RuntimeException("La colección no puede estar vacía");
		}

		QuickSort.quickSort(coleccion, inicio, fin);

		int coleccion_length = fin + 1;

		if (coleccion_length % 2 == 0) {
			int a = coleccion[indexElement - 1];
			int b = coleccion[indexElement];
			return (double) (a + b) / 2;
		} else {
			return (double) coleccion[indexElement];
		}

	}

	public static void main(String[] args) {

		int[] coleccion1 = { 5, 2, 9, 1, 5, 6 };
		double mediana = encontrarMediana(coleccion1, 0, coleccion1.length - 1, coleccion1.length / 2);
		System.out.println("La mediana es: " + mediana);

		System.out.println();

		int[] coleccion2 = { 7, 3, 1, 10, 9, 8, 5 };
		mediana = encontrarMediana(coleccion2, 0, coleccion2.length - 1, coleccion2.length / 2);
		System.out.println("La mediana es: " + mediana);

		System.out.println();

		int[] coleccion3 = { 2, 4, 1, 3 };
		mediana = encontrarMediana(coleccion3, 0, coleccion3.length - 1, coleccion3.length / 2);
		System.out.println("La mediana es: " + mediana);

		System.out.println();

		int[] coleccion4 = { 6, 1, 8, 4, 2, 5 };
		mediana = encontrarMediana(coleccion4, 0, coleccion4.length - 1, coleccion4.length / 2);
		System.out.println("La mediana es: " + mediana);

		System.out.println();

		int[] coleccion5 = { 11, 3, 7, 9, 6 };
		mediana = encontrarMediana(coleccion5, 0, coleccion5.length - 1, coleccion5.length / 2);
		System.out.println("La mediana es: " + mediana);

		System.out.println();
	}
}
