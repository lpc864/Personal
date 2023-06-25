package divide_and_conquer;

public class MatrixMultiplication {

	public static int[][] matrixMultiplication(int[][] matrixA, int[][] matrixB) {
		if (matrixA[0].length != matrixB.length) {
			throw new RuntimeException("Deben coincidir las columnas de la primera matriz con respecto a las filas de la segunda matriz");
		}

		int[][] result = new int[matrixA.length][matrixB[0].length];

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = 0;
				for (int k = 0; k < matrixA[0].length; k++) {
					result[i][j] += (matrixA[i][k] * matrixB[k][j]);
				}
			}
		}

		return result;
	}
	
	public static void printMatrix (int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println();
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
		}
		System.out.println("\n");
	}

	public static void main(String[] args) {
		System.out.println("Multiplicacion de matrices");
		System.out.println("--------------------------\n");
		
		int[][] matrixA = {
				{ 2, 3, 5 },
				{ 7, 2, 4 } 
				};

		System.out.println("Matrix A");
		System.out.println("--------");
		printMatrix(matrixA);
		
		int[][] matrixB = {
				{ 1,  6 },
				{ 7,  2 }, 
				{ 0, -5 }
				};

		System.out.println("Matrix B");
		System.out.println("--------");
		printMatrix(matrixB);
		
		System.out.println("Matrix AxB");
		System.out.println("----------");
		int[][]result = matrixMultiplication(matrixA, matrixB);
		printMatrix(result);
		
		
		int[][] matrixC = {
				{ 1, 2, 3 },
				{-2, 5, 1 } 
				};

		System.out.println("Matrix C");
		System.out.println("--------");
		printMatrix(matrixC);
		
		int[][] matrixD = {
				{ 1, -1,  1 },
				{ 0,  5,  2 }, 
				{ 2,  3, -3 }
				};

		System.out.println("Matrix D");
		System.out.println("--------");
		printMatrix(matrixD);
		
		System.out.println("Matrix CxD");
		System.out.println("----------");
		result = matrixMultiplication(matrixC, matrixD);
		printMatrix(result);
		
		int[][] matrixE = {
				{ 2, 4, 6 },
				{ 6, 4, 2 }, 
				{ 8, 10, 12}
				};

		System.out.println("Matrix E");
		System.out.println("--------");
		printMatrix(matrixE);
		
		int[][] matrixF = {
				{ 1, 2, 3 },
				{ 3, 2, 3 }, 
				{ 2, 2, 2 }
				};

		System.out.println("Matrix F");
		System.out.println("--------");
		printMatrix(matrixF);
		
		System.out.println("Matrix ExF");
		System.out.println("----------");
		result = matrixMultiplication(matrixE, matrixF);
		printMatrix(result);
	}
}
