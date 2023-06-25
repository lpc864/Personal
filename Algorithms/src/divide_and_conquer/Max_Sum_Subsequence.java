package divide_and_conquer;

public class Max_Sum_Subsequence {
	
	public static int[] sumMiddleSubsequence(int[]coleccion, int inicio, int mitad, int fin) {
		int max_suma_izquierda = Integer.MIN_VALUE;
		int suma = 0;
		int indice_inicio = mitad;
		
		for (int i = mitad; i >= inicio; i--) {
			suma += coleccion[i];
			if (suma > max_suma_izquierda) {
				max_suma_izquierda = suma;
				indice_inicio = i;
			}
		}
		
		int max_suma_derecha = Integer.MIN_VALUE;
		suma = 0;
		int indice_fin = mitad + 1;
		
		for (int i = mitad + 1; i <= fin; i++) {
			suma += coleccion[i];
			if (suma > max_suma_derecha) {
				max_suma_derecha = suma;
				indice_fin = i;
			}
		}
		
		suma = max_suma_izquierda + max_suma_derecha;
		
		return suma < 0 ? new int[] {0, 0, 0} : new int[] {indice_inicio, indice_fin, suma};
	}
	
	public static int[] maxSumSubsequence(int[]coleccion, int inicio, int fin) {
		if (coleccion.length == 0) {
			return new int[] {0,0,0};
		}
		
		if(inicio == fin) {
			return new int[]{inicio, fin, coleccion[inicio]};
		}
		
		
		int mitad = (inicio + fin) / 2;
		int[] coleccion_izquierda = maxSumSubsequence(coleccion, inicio, mitad);
		int[] coleccion_derecha = maxSumSubsequence(coleccion, mitad + 1, fin);
		int[] coleccion_medio = sumMiddleSubsequence(coleccion, inicio, mitad, fin);
		
		
		return (coleccion_izquierda[2] > coleccion_derecha[2]) ? (coleccion_izquierda[2] > coleccion_medio[2] ? coleccion_izquierda : coleccion_medio) 
															   : (coleccion_derecha[2] > coleccion_medio[2] ? coleccion_derecha : coleccion_medio);
	}
	
	public static void main (String[] args) {
		int[] datosCasino = {29, -7, 14, 31, 1, -47, 30, 7, -39, 23, -20, -36, -41, 27, 15, -34, 48, 35, -46, -16, 32, 18, 5, -33, 27, -28, -22, 12, 11, -42, 13};
		int[] datos1 = {-2, 11, -4, 13, -5, 2};
		int[] datos2 = {1, -3, 4, -2, -1, 6};
		int[] datos3 = {4, -3, 5, -2, -1, 2, 6, -2};
		int[] datos4 = {-1, -4, -7, -9, -1, -6, -4};
		int[] datos5 = {};
		int[] temp;
		
		temp = maxSumSubsequence(datosCasino, 0, datosCasino.length - 1);
		System.out.println("Inicio: " + temp[0] + ", Fin: " + temp[1] + ", Suma: " + temp[2]);
		temp = maxSumSubsequence(datos1, 0, datos1.length - 1);
		System.out.println("Inicio: " + temp[0] + ", Fin: " + temp[1] + ", Suma: " + temp[2]);
		temp = maxSumSubsequence(datos2, 0, datos2.length - 1);
		System.out.println("Inicio: " + temp[0] + ", Fin: " + temp[1] + ", Suma: " + temp[2]);
		temp = maxSumSubsequence(datos3, 0, datos3.length - 1);
		System.out.println("Inicio: " + temp[0] + ", Fin: " + temp[1] + ", Suma: " + temp[2]);
		temp = maxSumSubsequence(datos4, 0, datos4.length - 1);
		System.out.println("Inicio: " + temp[0] + ", Fin: " + temp[1] + ", Suma: " + temp[2]);
		temp = maxSumSubsequence(datos5, 0, datos5.length - 1);
		System.out.println("Inicio: " + temp[0] + ", Fin: " + temp[1] + ", Suma: " + temp[2]);
		
		
	}
}
