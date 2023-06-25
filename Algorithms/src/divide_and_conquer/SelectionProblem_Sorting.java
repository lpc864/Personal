package divide_and_conquer;

public class SelectionProblem_Sorting {
	
	public static int selectionProblem (int [] coleccion, int inicio, int fin, int indexElement) {
		
		if (coleccion.length == 0) {
	        throw new RuntimeException("La colección no puede estar vacía");
	    }
		
		QuickSort.quickSort(coleccion, inicio, fin);
		return coleccion[indexElement];
	}
	
	public static void main (String [] args) {
		int [] arr = {55, 88, 22, 66, 44, 11, 33, 77, 66};
		int number = selectionProblem(arr, 0, arr.length - 1, 2);
		System.out.println(number);
	}
}
