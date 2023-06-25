package divide_and_conquer;

public class Search_Max_Min_Iterative {

	public static int[] search_max_min(int[] coleccion) {
		int max = coleccion[0];
		int min = coleccion[0];
		
		for (int i = 1; i < coleccion.length; i++) {
			if (coleccion[i] > max) {
				max = coleccion[i];
			}
			else if (coleccion[i] < min) {
				min = coleccion[i];
			}
		}
		return new int [] {max, min};
	}

	public static void main(String[] args) {
		int [] numeros = {-22,10,6,8,0,20};
		int [] max_min = search_max_min(numeros);
		System.out.println("El maximo es: " +  max_min[0]);
		System.out.println("El minimo es: " +  max_min[1]);
	}
}
