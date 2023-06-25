package divide_and_conquer;

import java.util.Arrays;

public class BinarySearch {
	
	private static int binarySearch (int[] coleccion, int inicio, int fin, int elementToSearch) {
		int mitad = (inicio + fin) / 2;
		
		if (inicio <= fin) {
			if (elementToSearch < coleccion[mitad]) {
				return binarySearch(coleccion, inicio, mitad - 1, elementToSearch);
			}
			else if (elementToSearch > coleccion[mitad]) {
				return binarySearch(coleccion, mitad + 1, fin, elementToSearch);
			}
			else {
				return mitad;
			}
		}
		else {
			return -1;
		}
	}
	
	public static int binarySearch (int[] coleccion, int elementToSearch) {
		Arrays.sort(coleccion);
		return binarySearch(coleccion, 0, coleccion.length - 1, elementToSearch);
	}
	
	public static void main(String[] args) {
		int arr[] = { 2, 3, 4, 10, 40 };
		int key = 5;
		
		int result = binarySearch(arr, key);
		
		if (result == -1) {
			System.out.println("(R) Element not present");
		}
			
		else {
			System.out.println("(R) Element found at index " + result);
		}
		
		
	}
}
