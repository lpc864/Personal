package divide_and_conquer;

public class MatrixMultiplication_Strassen extends MatrixMultiplication_DyV {
	
	public static int[][] matrixMultiplication_Strassen(int[][]matrixA, int[][]matrixB)  {
		if (matrixA[0].length != matrixB.length) {
			throw new RuntimeException("Deben coincidir las columnas de la primera matriz con respecto a las filas de la segunda matriz");
		}
		if (matrixA.length != matrixA[0].length || matrixB.length != matrixB[0].length) {
			throw new RuntimeException("Las matrices deben ser cuadradas");
		}
		if (matrixA.length == 1) {
			return new int[][] {{matrixA[0][0] * matrixB[0][0]}};
		}
		if (matrixA.length % 2 != 0) {
			throw new RuntimeException("Las matrices deben ser potencia de dos");
		}
		
		int splitIndex = matrixA.length / 2;
		
		int[][]matrixA11 = new int[splitIndex][splitIndex];
		int[][]matrixA12 = new int[splitIndex][splitIndex];
		int[][]matrixA21 = new int[splitIndex][splitIndex];
		int[][]matrixA22 = new int[splitIndex][splitIndex];
		
		int[][]matrixB11 = new int[splitIndex][splitIndex];
		int[][]matrixB12 = new int[splitIndex][splitIndex];
		int[][]matrixB21 = new int[splitIndex][splitIndex];
		int[][]matrixB22 = new int[splitIndex][splitIndex];
		
		int[][]subproblema1 = new int[splitIndex][splitIndex];
		int[][]subproblema2 = new int[splitIndex][splitIndex];
		int[][]subproblema3 = new int[splitIndex][splitIndex];
		int[][]subproblema4 = new int[splitIndex][splitIndex];
		int[][]subproblema5 = new int[splitIndex][splitIndex];
		int[][]subproblema6 = new int[splitIndex][splitIndex];
		int[][]subproblema7 = new int[splitIndex][splitIndex];
		
		int[][]result11 = new int[splitIndex][splitIndex];
		int[][]result12 = new int[splitIndex][splitIndex];
		int[][]result21 = new int[splitIndex][splitIndex];
		int[][]result22 = new int[splitIndex][splitIndex];
		
		int[][]result = new int[matrixA.length][matrixB[0].length];
		
		fillMatrix(matrixA, matrixA11, matrixA12, matrixA21, matrixA22, splitIndex);
		fillMatrix(matrixB, matrixB11, matrixB12, matrixB21, matrixB22, splitIndex);
		
		subproblema1 = matrixMultiplication(subtractMatrix(matrixA12, matrixA22), addMatrix(matrixB21, matrixB22));
		subproblema2 = matrixMultiplication(addMatrix(matrixA11, matrixA22), addMatrix(matrixB11, matrixB22));
		subproblema3 = matrixMultiplication(subtractMatrix(matrixA21, matrixA11), addMatrix(matrixB11, matrixB12));
		subproblema4 = matrixMultiplication(addMatrix(matrixA11, matrixA12), matrixB22);
		subproblema5 = matrixMultiplication(matrixA11, subtractMatrix(matrixB12, matrixB22));
		subproblema6 = matrixMultiplication(matrixA22, subtractMatrix(matrixB21, matrixB11));
		subproblema7 = matrixMultiplication(addMatrix(matrixA21, matrixA22), matrixB11);
		
		result11 = subtractMatrix(addMatrix(subproblema1, subproblema2), addMatrix(subproblema4, subproblema6));
		result12 = addMatrix(subproblema4, subproblema5);
		result21 = addMatrix(subproblema6, subproblema7);
		result22 = addMatrix(addMatrix(subproblema2, subproblema3), subtractMatrix(subproblema5, subproblema7));
		
		for (int i = 0; i < splitIndex; i++) {
			for (int j = 0; j < splitIndex; j++) {
				result[i][j] = result11[i][j];
				result[i][j + splitIndex] = result12[i][j];
				result[i + splitIndex][j] = result21[i][j];
				result[i + splitIndex][j + splitIndex] = result22[i][j];
			}
		}
		
		return result;
	}
	
	public static void main (String[] args) {
		System.out.println("Multiplicacion de matrices");
		System.out.println("--------------------------\n");

		int[][] matrixA = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 2, 2, 2, 2 } };

		System.out.println("Matrix A");
		System.out.println("--------");
		printMatrix(matrixA);

		int[][] matrixB = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 2, 2, 2, 2 } };

		System.out.println("Matrix B");
		System.out.println("--------");
		printMatrix(matrixB);

		System.out.println("Matrix AxB");
		System.out.println("----------");
		int[][] result = matrixMultiplication_DyV(matrixA, matrixB);
		printMatrix(result);
	}
}
