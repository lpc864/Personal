package divide_and_conquer;

public class Search_Max_Min_DyV {

	public static int[] who_is_max_min(int[] coleccion_izquierda, int[] coleccion_derecha) {
		int max = coleccion_izquierda[0] > coleccion_derecha[0] ? coleccion_izquierda[0] : coleccion_derecha[0];
		int min = coleccion_izquierda[1] < coleccion_derecha[1] ? coleccion_izquierda[1] : coleccion_derecha[1];
		return new int[] { max, min };
	}
	
	public static int[] search_max_min(int[] coleccion, int indice_inicio, int indice_fin) {
		
		if (coleccion.length == 0) {
	        throw new RuntimeException("La colección no puede estar vacía");
	    }
		
		if (indice_inicio == indice_fin) {
			return new int[] { coleccion[indice_inicio], coleccion[indice_fin] };
		}

		int mitad = (indice_inicio + indice_fin) / 2;

		int[] max_min_izq = search_max_min(coleccion, indice_inicio, mitad);
		int[] max_min_der = search_max_min(coleccion, mitad + 1, indice_fin);

		return who_is_max_min(max_min_izq, max_min_der);
	}

	public static void main(String[] args) {
		int[] numeros = { 12, 17, 5, 21, 8, 34, 16, 1 };
		int[] max_min = search_max_min(numeros, 0, numeros.length - 1);
		System.out.println("El maximo es: " + max_min[0]); 
		System.out.println("El minimo es: " + max_min[1]); 

		System.out.println();
		
		int[] numeros2 = { -10, 0, 100, 50, -20, 30 };
		int[] max_min2 = search_max_min(numeros2, 0, numeros2.length - 1);
		System.out.println("El maximo es: " + max_min2[0]); 
		System.out.println("El minimo es: " + max_min2[1]); 

		System.out.println();
		
		int[] numeros3 = { 5 };
		int[] max_min3 = search_max_min(numeros3, 0, numeros3.length - 1);
		System.out.println("El maximo es: " + max_min3[0]); 
		System.out.println("El minimo es: " + max_min3[1]); 
		
		System.out.println();
	   
		/*
	    int [] numeros4 = {};
	    int [] max_min4 = search_max_min(numeros4, 0, numeros4.length - 1);
	    System.out.println("El maximo es: " +  max_min4[0]); 
	    System.out.println("El minimo es: " +  max_min4[1]); 
		*/
		
	}
}
