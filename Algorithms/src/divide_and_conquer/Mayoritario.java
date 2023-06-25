package divide_and_conquer;

import java.util.*;

public class Mayoritario {

	public static boolean findMayoritarioIterative(int[] coleccion, int inicio, int fin) {
		int tamanoColeccion = (fin - inicio) + 1;
		int contador;
		ArrayList<Integer> usados = new ArrayList<Integer>();

		for (int i = inicio; i < tamanoColeccion; i++) {
			contador = 0;
			if (!usados.contains(coleccion[i])) {
				usados.add(coleccion[i]);
				contador += 1;
				for (int j = i + 1; j < tamanoColeccion; j++) {
					if (coleccion[i] == coleccion[j]) contador++;
				}
				
				if (contador > tamanoColeccion / 2) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean findMayoritarioDyV(int[] coleccion, int inicio, int fin) {
	
		int mitad = (fin + inicio) / 2;
		int contador;
		TreeMap<Integer, Boolean> elementoXusado = new TreeMap<>();
		TreeMap<Integer, Integer> elementoXcontador = new TreeMap<>();
		
		
		for (int i = inicio; i <= mitad + 1; i++) {
			if (!elementoXusado.containsKey(coleccion[i])) {
				contador = 0;
				elementoXusado.put(coleccion[i], true);
				contador += 1;
				for (int j = i + 1; j <= mitad + 1; j++) {
					if (coleccion[i] == coleccion[j]) {
						contador++;
					}
				}
				if (contador > ((fin - inicio) + 1)/2) {
					return true;
				}
				elementoXcontador.put(coleccion[i], contador);
			}
		}
		
		for (int i = mitad + 2; i <= fin; i++) {
			if (elementoXusado.containsKey(coleccion[i]) && elementoXusado.get(coleccion[i]) == true) {
				elementoXusado.put(coleccion[i], false);
				int lastContador = elementoXcontador.get(coleccion[i]);
				lastContador+=1;
				for (int j = i + 1; j <= fin; j++) {
					if (coleccion[i] == coleccion[j]) {
						lastContador++;
					}
				}
				if (lastContador > ((fin - inicio) + 1)/2) {
					return true;
				}
			}
		}
		
		return false;

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 1, 2, 3 };

		boolean resultado = findMayoritarioIterative(arr, 0, arr.length - 1);

		System.out.println(resultado);
		
		resultado = findMayoritarioDyV(arr, 0, arr.length - 1);

		System.out.println(resultado);
	}
}
